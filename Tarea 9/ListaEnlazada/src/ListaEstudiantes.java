public class ListaEstudiantes {

    private NodoEstudiante head;

    public ListaEstudiantes() {
        this.head = null;
    }

    // Inserta al inicio de la lista
    public void agregarInicio(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota);
        nuevo.setNext(head);
        head = nuevo;
    }

    // Inserta al final de la lista
    public void agregarFinal(String carnet, String nombre, double nota) {
        NodoEstudiante nuevo = new NodoEstudiante(carnet, nombre, nota);
        if (head == null) {
            head = nuevo;
            return;
        }
        NodoEstudiante actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(nuevo);
    }

    // Elimina el nodo con ese carnet
    public void eliminarPorCarnet(String carnet) {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        if (head.getCarnet().equals(carnet)) {
            head = head.getNext();
            System.out.println("Estudiante con carnet " + carnet + " eliminado.");
            return;
        }
        NodoEstudiante actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getCarnet().equals(carnet)) {
                actual.setNext(actual.getNext().getNext());
                System.out.println("Estudiante con carnet " + carnet + " eliminado.");
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Carnet " + carnet + " no encontrado.");
    }

    // Retorna el nodo o null si no existe
    public NodoEstudiante buscarPorCarnet(String carnet) {
        NodoEstudiante actual = head;
        while (actual != null) {
            if (actual.getCarnet().equals(carnet)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    // Imprime todos los estudiantes en orden
    public void imprimirLista() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoEstudiante actual = head;
        System.out.println("=== Lista de Estudiantes ===");
        while (actual != null) {
            System.out.println("Carnet: " + actual.getCarnet() +
                    " | Nombre: " + actual.getNombre() +
                    " | Nota: " + actual.getNota());
            actual = actual.getNext();
        }
    }

    // Retorna el promedio de notas
    public double obtenerPromedio() {
        if (head == null) return 0;
        double suma = 0;
        int count = 0;
        NodoEstudiante actual = head;
        while (actual != null) {
            suma += actual.getNota();
            count++;
            actual = actual.getNext();
        }
        return suma / count;
    }

    // Retorna el estudiante con mayor nota
    public NodoEstudiante obtenerMejorNota() {
        if (head == null) return null;
        NodoEstudiante mejor = head;
        NodoEstudiante actual = head.getNext();
        while (actual != null) {
            if (actual.getNota() > mejor.getNota()) {
                mejor = actual;
            }
            actual = actual.getNext();
        }
        return mejor;
    }

    public static void main(String[] args) {

        // PARTE 1 — Lista Simplemente Enlazada
        System.out.println("  PARTE 1 - LISTA SIMPLEMENTE ENLAZADA ");

        ListaEstudiantes lista = new ListaEstudiantes();

        lista.agregarFinal("202300001", "Ana García", 85.5);
        lista.agregarFinal("202300002", "Carlos López", 92.0);
        lista.agregarFinal("202300004", "José Ramos", 95.5);
        lista.agregarInicio("202300003", "María Pérez", 78.0);

        System.out.println(" Lista inicial:");
        lista.imprimirLista();

        System.out.println("\n>> Promedio de notas: " + String.format("%.2f", lista.obtenerPromedio()));

        NodoEstudiante mejor = lista.obtenerMejorNota();
        System.out.println(">> Estudiante con mejor nota: " + mejor.getNombre() + " (" + mejor.getNota() + ")");

        System.out.println("Buscar carnet 202300002:");
        NodoEstudiante encontrado = lista.buscarPorCarnet("202300002");
        if (encontrado != null)
            System.out.println("   Encontrado → " + encontrado.getNombre() + " | Nota: " + encontrado.getNota());
        else
            System.out.println("   No encontrado.");

        System.out.println("Buscar carnet 999999999 ");
        NodoEstudiante noExiste = lista.buscarPorCarnet("999999999");
        if (noExiste != null)
            System.out.println("   Encontrado → " + noExiste.getNombre());
        else
            System.out.println("   No encontrado.");

        System.out.println("Eliminar head (202300003 - María Pérez):");
        lista.eliminarPorCarnet("202300003");
        lista.imprimirLista();

        System.out.println("Eliminar nodo del medio");
        lista.eliminarPorCarnet("202300002");
        lista.imprimirLista();

        System.out.println("Eliminar tail 202300004");
        lista.eliminarPorCarnet("202300004");
        lista.imprimirLista();

        System.out.println("Eliminar último nodo 202300001");
        lista.eliminarPorCarnet("202300001");
        lista.imprimirLista();

        System.out.println("Intentar eliminar en lista vacía:");
        lista.eliminarPorCarnet("202300001");

        // PARTE 2 — Lista Doblemente Enlazada
        System.out.println("   PARTE 2 - LISTA DOBLEMENTE ENLAZADA   ");

        ListaDobleEstudiantes listaDoble = new ListaDobleEstudiantes();

        System.out.println("Insertando estudiantes:");
        listaDoble.insertarOrdenado("202300004", "José Ramos",   95.5);
        listaDoble.insertarOrdenado("202300001", "Ana García",   85.5);
        listaDoble.insertarOrdenado("202300003", "María Pérez",  78.0);
        listaDoble.insertarOrdenado("202300002", "Carlos López", 92.0);
        listaDoble.insertarOrdenado("202300005", "Luis Torres",  60.0);
        listaDoble.insertarOrdenado("202300006", "Sofía Ruiz",   60.0);

        listaDoble.imprimirAdelante();
        System.out.println();
        listaDoble.imprimirAtras();

        System.out.println("Eliminar 202300004 ");
        listaDoble.eliminarPorCarnet("202300004");
        listaDoble.imprimirAdelante();

        System.out.println("Eliminar 202300005 ");
        listaDoble.eliminarPorCarnet("202300005");
        listaDoble.imprimirAdelante();

        System.out.println("Eliminar nodo del medio ");
        listaDoble.eliminarPorCarnet("202300001");
        listaDoble.imprimirAdelante();

        System.out.println("Intentar eliminar carnet inexistente ");
        listaDoble.eliminarPorCarnet("999999999");

        System.out.println("Vaciando lista...");
        listaDoble.eliminarPorCarnet("202300006");
        listaDoble.eliminarPorCarnet("202300003");
        listaDoble.eliminarPorCarnet("202300002");

        System.out.println("Imprimir lista:");
        listaDoble.imprimirAdelante();

        System.out.println("Agregar un único nodo y eliminar");
        listaDoble.agregarInicio("202300010", "Pedro Juárez", 70.0);
        listaDoble.imprimirAdelante();
        listaDoble.eliminarPorCarnet("202300010");
        listaDoble.imprimirAdelante();

    }

}
