/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg7;

import java.util.Scanner;

/**
 *
 * @author colin
 */
public class Tarea7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
        Curso[] cursos = new Curso[50];
        int totalCursos = 0;
        int opcion;
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Crear curso");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Mostrar cursos y tareas");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            if (opcion == 1) {
                System.out.print("Nombre del curso: ");
                String nombre = sc.nextLine();
                System.out.print("Codigo: ");
                String codigo = sc.nextLine();
                System.out.print("Tutor: ");
                String tutor = sc.nextLine();
                
                cursos[totalCursos] = new Curso(nombre, codigo, tutor);
                totalCursos++;
                System.out.println("Curso creado!");
                
            } else if (opcion == 2) {
                if (totalCursos == 0) {
                    System.out.println("No hay cursos todavia.");
                } else {
                    System.out.print("Codigo del curso: ");
                    String cod = sc.nextLine();
                    
                    Curso cursoEncontrado = null;
                    for (int i = 0; i < totalCursos; i++) {
                        if (cursos[i].getCodigo().equals(cod)) {
                            cursoEncontrado = cursos[i];
                        }
                    }
                    
                    if (cursoEncontrado == null) {
                        System.out.println("No se encontro el curso.");
                    } else {
                        System.out.print("Titulo de la tarea: ");
                        String titulo = sc.nextLine();
                        System.out.print("Codigo de la tarea: ");
                        String codigoT = sc.nextLine();
                        System.out.print("Descripcion: ");
                        String desc = sc.nextLine();
                        System.out.print("Fecha de entrega: ");
                        String fecha = sc.nextLine();
                        
                        Tarea t = new Tarea(titulo, codigoT, desc, fecha);
                        cursoEncontrado.agregarTarea(t);
                        System.out.println("Tarea agregada!");
                    }
                }
                
            } else if (opcion == 3) {
                if (totalCursos == 0) {
                    System.out.println("No hay cursos.");
                } else {
                    System.out.println("\n--- Cursos ---");
                    for (int i = 0; i < totalCursos; i++) {
                        System.out.println("----------------");
                        cursos[i].mostrarInformacion();
                    }
                }
                
            } else if (opcion == 4) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion no valida.");
            }
            
        } while (opcion != 4);
        
        sc.close();
    }  
}
