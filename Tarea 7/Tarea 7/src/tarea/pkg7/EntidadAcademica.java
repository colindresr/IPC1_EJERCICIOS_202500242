/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea.pkg7;
/**
 *
 * @author colin
 */
public abstract class EntidadAcademica {
    
    private String nombre;
    private String codigo;
    
    public abstract void mostrarInformacion();

    public EntidadAcademica() {
    }
   
    public EntidadAcademica(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }    
}
