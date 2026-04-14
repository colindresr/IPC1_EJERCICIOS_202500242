public class NodoEstudiante {

    private String carnet;
    private String nombre;
    private double nota;
    private NodoEstudiante next;

    public NodoEstudiante(String carnet, String nombre, double nota) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.nota = nota;
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

    public NodoEstudiante getNext() {
        return next;
    }

    public void setNext(NodoEstudiante next) {
        this.next = next;
    }
}
