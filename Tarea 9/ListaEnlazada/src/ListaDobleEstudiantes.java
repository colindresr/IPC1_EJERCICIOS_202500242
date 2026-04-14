public class ListaDobleEstudiantes {

    private NodoEstudianteDoble head;
    private NodoEstudianteDoble tail;

    public ListaDobleEstudiantes() {
        this.head = null;
        this.tail = null;
    }

    // Inserta al inicio
    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.setNext(head);
            head.setPrev(nuevo);
            head = nuevo;
        }
    }

    // Inserta al final
    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
        if (tail == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setNext(nuevo);
            nuevo.setPrev(tail);
            tail = nuevo;
        }
    }

    // Elimina el nodo con ese carnet actualizando prev y next
    public void eliminarPorCarnet(String carnet) {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoEstudianteDoble actual = head;
        while (actual != null) {
            if (actual.getCarnet().equals(carnet)) {
                // Caso: único nodo
                if (actual.getPrev() == null && actual.getNext() == null) {
                    head = null;
                    tail = null;
                }
                // Caso: es el head
                else if (actual.getPrev() == null) {
                    head = actual.getNext();
                    head.setPrev(null);
                }
                // Caso: es el tail
                else if (actual.getNext() == null) {
                    tail = actual.getPrev();
                    tail.setNext(null);
                }
                // Caso: nodo en el medio
                else {
                    actual.getPrev().setNext(actual.getNext());
                    actual.getNext().setPrev(actual.getPrev());
                }
                System.out.println("Estudiante con carnet " + carnet + " eliminado.");
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Carnet " + carnet + " no encontrado.");
    }

    // Recorre HEAD → TAIL
    public void imprimirAdelante() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("=== Lista (HEAD -> TAIL) ===");
        NodoEstudianteDoble actual = head;
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() +
                    "  Nombre: " + actual.getNombre() +
                    "  Nota: " + actual.getNota());
            actual = actual.getNext();
        }
    }

    // Recorre TAIL → HEAD
    public void imprimirAtras() {
        if (tail == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("=== Lista (TAIL -> HEAD) ===");
        NodoEstudianteDoble actual = tail;
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() +
                    "  Nombre: " + actual.getNombre() +
                    "  Nota: " + actual.getNota());
            actual = actual.getPrev();
        }
    }

    // Inserta manteniendo orden ascendente por nota
    public void insertarOrdenado(String carnet, String nombre, double nota) {
        if (head == null || nota <= head.getNota()) {
            agregarInicio(carnet, nombre, nota);
            return;
        }
        if (nota >= tail.getNota()) {
            agregarFinal(carnet, nombre, nota);
            return;
        }
        NodoEstudianteDoble actual = head.getNext();
        while (actual != null) {
            if (nota <= actual.getNota()) {
                NodoEstudianteDoble nuevo = new NodoEstudianteDoble(carnet, nombre, nota);
                nuevo.setPrev(actual.getPrev());
                nuevo.setNext(actual);
                actual.getPrev().setNext(nuevo);
                actual.setPrev(nuevo);
                return;
            }
            actual = actual.getNext();
        }
        agregarFinal(carnet, nombre, nota);
    }

}
