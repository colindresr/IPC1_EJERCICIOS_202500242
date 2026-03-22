/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea.pkg7;

/**
 *
 * @author colin
 */
public class Tarea extends EntidadAcademica{
    
    private String descripcion;
    private String fecha;

    public Tarea(String nombre, String codigo, String descripcion, String fecha) {
        super(nombre, codigo);
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("   - Titulo: " + getNombre());
        System.out.println("     Codigo: " + getCodigo());
        System.out.println("     Descripcion: " + descripcion);
        System.out.println("     Fecha de entrega: " + fecha);
    }
}
