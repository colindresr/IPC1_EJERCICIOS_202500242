import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicio2 {

    private static final String TEXTO = "UNIVERSIDAD DE SAN CARLOS DE GUATEMALA Facultad de Ingeniería — Boletín Informativo 2024-04-25\n" +
            "Actividades programadas: - Conferencia el 2024-05-01 a las 10:30 en el Edificio T3 -Examen parcial el 2024-05-15 a las 08:00 en el Edificio S11 - Defensa de proyecto el 2024-06-10 a las 14:30 en el Edificio T7\n" +
            "Contactos del departamento: - Coordinador:  coord.ipc1@ingenieria.usac.edu.gt  Tel: 2418-8000 -Auxiliar 1:  aux01_ipc1@ingenieria.usac.edu.gt  Tel: 5555-1234 -Auxiliar 2:  aux02.ipc1@gmail.com Tel: 4321-9876";

    public static void extraerFechas(String texto) {
        String patron = "(\\d{4})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println("Año: " + matcher.group(1) + " | Mes: " + matcher.group(2) + " | Día: " + matcher.group(3));
        }
    }

    public static void extraerCorreos(String texto) {
        String patron = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static String censurarDatos(String texto) {
        String resultado = texto;

        // Formato para correo
        String patronCorreo = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern patternCorreo = Pattern.compile(patronCorreo);
        Matcher matcherCorreo = patternCorreo.matcher(resultado);
        resultado = matcherCorreo.replaceAll("[CORREO]");

        //Poner formato de telefono
        String patronTelefono = "\\d{4}-\\d{4}";
        Pattern patternTelefono = Pattern.compile(patronTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(resultado);
        resultado = matcherTelefono.replaceAll("[TEL]");

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("=== Extraer Fechas ===");
        extraerFechas(TEXTO);

        System.out.println("\n=== Extraer Correos ===");
        extraerCorreos(TEXTO);

        System.out.println("\n=== Censurar Datos Sensibles ===");
        String textoPrueba = "Llama a 5555-1234 o escribe a juan@usac.edu.gt para más info.";
        System.out.println("Entrada: " + textoPrueba);
        System.out.println("Salida: " + censurarDatos(textoPrueba));
    }
}
