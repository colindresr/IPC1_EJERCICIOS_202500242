public class NodoEstudianteDoble {

    private String carnet;
    private String nombre;
    private double nota;
    private NodoEstudianteDoble prev;
    private NodoEstudianteDoble next;

    public NodoEstudianteDoble(String carnet, String nombre, double nota) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
        this.prev = null;
        this.next = null;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public NodoEstudianteDoble getPrev() {
        return prev;
    }

    public void setPrev(NodoEstudianteDoble prev) {
        this.prev = prev;
    }

    public NodoEstudianteDoble getNext() {
        return next;
    }

    public void setNext(NodoEstudianteDoble next) {
        this.next = next;
    }
}
