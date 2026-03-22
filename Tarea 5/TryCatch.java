import java.util.Scanner;

/*
    Ejemplo de Try Catch en Java que maneja error al ingresar una cadena de texto en vez de un entero
*/
public class TryCatch {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Menu de opciones
        while(opcion !=3){
            System.out.println("————————————————Try Catch————————————————");
            System.out.println("1. Ejemplo de Try Catch");
            System.out.println("2. Ejemplo sin Try Catch");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    conTryCatch();
                    break;
                case 2:
                    sinTryCatch();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        }
        sc.close();
    }
    
    public static void conTryCatch(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese un numero entero: ");
            int numero = sc.nextInt();
            System.out.println("El numero ingresado es: " + numero);
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un numero entero.");
        }
    }
    
    public static void sinTryCatch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        int numero = sc.nextInt();
        System.out.println("El numero ingresado es: " + numero);
    }

}