/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea.pkg7;

import java.util.ArrayList;

/**
 *
 * @author colin
 */

public class Curso extends EntidadAcademica{
        
    private String tutor;
    private ArrayList<Tarea> listaDeTareas;

    public Curso(String nombre, String codigo, String tutor) {
        super(nombre, codigo);
        this.tutor = tutor;
        this.listaDeTareas = new ArrayList<>();
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public ArrayList<Tarea> getListaDeTareas() {
        return listaDeTareas;
    }

    public void setListaDeTareas(ArrayList<Tarea> listaDeTareas) {
        this.listaDeTareas = listaDeTareas;
    }
    
     public void agregarTarea(Tarea t) {
        listaDeTareas.add(t);
    }
     
     @Override
    public void mostrarInformacion(){
      System.out.println("Curso: " + getNombre());
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Tutor: " + tutor);
        
        if (listaDeTareas.isEmpty()) {
            System.out.println("No hay tareas para este curso.");
        } else {
            System.out.println("Tareas:");
            for (int i = 0; i < listaDeTareas.size(); i++) {
                listaDeTareas.get(i).mostrarInformacion();
            }
        }
    }     
      
}
