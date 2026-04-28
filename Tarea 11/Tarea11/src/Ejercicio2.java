import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio2 {

    private static final String TEXTO =
            "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA Facultad de Ingeniería — Boletín Informativo 2024-04-25\n" +
                    "Actividades programadas: - Conferencia el 2024-05-01 a las 10:30 en el Edificio T3 " +
                    "- Examen parcial el 2024-05-15 a las 08:00 en el Edificio S11 " +
                    "- Defensa de proyecto el 2024-06-10 a las 14:30 en el Edificio T7\n" +
                    "Contactos del departamento: - Coordinador:  coord.ipc1@ingenieria.usac.edu.gt  Tel: 2418-8000 " +
                    "- Auxiliar 1:  aux01_ipc1@ingenieria.usac.edu.gt  Tel: 5555-1234 " +
                    "- Auxiliar 2:  aux02.ipc1@gmail.com  Tel: 4321-9876";

    public static void extraerFechas(String texto) {
        String patron = "(\\d{4})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Año: " + matcher.group(1) + " | Mes: " + matcher.group(2) + " | Día: " + matcher.group(3));
        }
    }

    public static void extraerCorreos(String texto) {
        // Patrón general: parte local @ dominio . extensión (mín. 2 chars)
        String patron = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static String censurarDatos(String texto) {
        String resultado = texto;

        // Censurar correo
        String patronCorreo = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        resultado = Pattern.compile(patronCorreo).matcher(resultado).replaceAll("[CORREO]");

        // Censurar telefono
        String patronTelefono = "\\d{4}-\\d{4}";
        resultado = Pattern.compile(patronTelefono).matcher(resultado).replaceAll("[TEL]");

        return resultado;
    }

    public static void main(String[] args) {

        System.out.println("=== Extraer Fechas (texto principal) ===");
        extraerFechas(TEXTO);

        System.out.println("\n=== Extraer Fechas (fechas alternativas) ===");
        extraerFechas("Reunión el 2025-01-15 y entrega el 2025-02-28");

        System.out.println("\n=== Extraer Fechas (sin fechas) ===");
        String sinFechas = "No hay ninguna fecha en este texto.";
        extraerFechas(sinFechas);
        System.out.println("(ninguna fecha encontrada en: \"" + sinFechas + "\")");

        System.out.println("\n=== Extraer Correos (texto principal) ===");
        extraerCorreos(TEXTO);

        System.out.println("\n=== Extraer Correos (correos alternativos) ===");
        extraerCorreos("Escribe a admin@gmail.com o a soporte@usac.edu.gt para consultas.");

        System.out.println("\n=== Extraer Correos (sin correos) ===");
        String sinCorreos = "Este texto no contiene ningún correo.";
        extraerCorreos(sinCorreos);
        System.out.println("(ningún correo encontrado en: \"" + sinCorreos + "\")");

        System.out.println("\n=== Censurar Datos Sensibles ===");

        String caso1 = "Llama a 5555-1234 o escribe a juan@usac.edu.gt para más info.";
        System.out.println("Entrada: " + caso1);
        System.out.println("Salida:  " + censurarDatos(caso1));

        String caso2 = "Contacto: coord@usac.edu.gt, Tel: 2418-8000 o aux@gmail.com, Tel: 4321-9876";
        System.out.println("\nEntrada: " + caso2);
        System.out.println("Salida:  " + censurarDatos(caso2));

        String caso3 = "No hay teléfonos ni correos aquí.";
        System.out.println("\nEntrada: " + caso3);
        System.out.println("Salida:  " + censurarDatos(caso3));
    }
}