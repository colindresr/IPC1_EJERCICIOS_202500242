import java.util.Scanner;

/**
 * Calculadora de consola con operaciones básicas: suma, resta, multiplicación, división, potencia y raíz.
 */
public class Calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // Ciclo principal
        while (opcion != 7) {
            System.out.println("\n===== CALCULADORA =====");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                // Raíz solo necesita un valor
                if (opcion == 6 || opcion == 7) {
                    if (opcion == 7) {
                        System.out.println("Gracias por utilizar esta calculadora");
                        break;
                    }
                    System.out.print("Ingrese el valor de a: ");
                    double a = Double.parseDouble(sc.nextLine());
                    raiz(a);
                    continue;
                }

                // Leer los dos operandos para las demás operaciones
                System.out.print("Ingrese el valor de a: ");
                double a = Double.parseDouble(sc.nextLine());

                System.out.print("Ingrese el valor de b: ");
                double b = Double.parseDouble(sc.nextLine());

                // Llamar al método según la opción elegida
                switch (opcion) {
                    case 1: suma(a, b);           break;
                    case 2: resta(a, b);          break;
                    case 3: multiplicacion(a, b); break;
                    case 4: division(a, b);       break;
                    case 5: potencia(a, b);       break;
                    default: System.out.println("Acción no válida"); break;
                }

            } catch (NumberFormatException e) {
                // Captura entradas que no sean números
                System.out.println("Error: Ingrese un valor numérico válido.");
            }
        }

        sc.close();
    }

    /** Suma dos números y muestra el resultado. */
    public static void suma(double a, double b) {
        try {
            double sumatoria = a + b;
            System.out.println("El resultado de la suma es: " + sumatoria);
        } catch (Exception e) {
            System.out.println("No se puede realizar esta suma: " + e.getMessage());
        }
    }

    /** Resta dos números y muestra el resultado. */
    public static void resta(double a, double b) {
        try {
            double diferencia = a - b;
            System.out.println("El resultado de la resta es: " + diferencia);
        } catch (Exception e) {
            System.out.println("No se puede realizar esta resta: " + e.getMessage());
        }
    }

    /** Multiplica dos números y muestra el resultado. */
    public static void multiplicacion(double a, double b) {
        try {
            double resultado = a * b;
            System.out.println("El resultado de la multiplicación es: " + resultado);
        } catch (Exception e) {
            System.out.println("No se puede realizar esta multiplicación: " + e.getMessage());
        }
    }

    /** Divide dos números. Valida que el divisor no sea cero. */
    public static void division(double a, double b) {
        try {
            if (b == 0) {
                System.out.println("No se puede dividir entre cero");
            } else {
                double resultado = a / b;
                System.out.println("El resultado de la división es: " + resultado);
            }
        } catch (Exception e) {
            System.out.println("No se puede realizar esta división: " + e.getMessage());
        }
    }

    /** Eleva a la potencia b y muestra el resultado. */
    public static void potencia(double a, double b) {
        try {
            double resultado = Math.pow(a, b);
            System.out.println("El resultado de la potencia es: " + resultado);
        } catch (Exception e) {
            System.out.println("No se puede realizar esta operación: " + e.getMessage());
        }
    }

    /** Calcula la raíz cuadrada. Valida que el número no sea negativo. */
    public static void raiz(double a) {
        try {
            if (a < 0) {
                System.out.println("No se pueden realizar raíces negativas");
            } else {
                double resultado = Math.sqrt(a);
                System.out.println("El resultado de la raíz es: " + resultado);
            }
        } catch (Exception e) {
            System.out.println("No se puede realizar esta operación: " + e.getMessage());
        }
    }
}