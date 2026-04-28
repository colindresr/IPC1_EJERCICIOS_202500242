import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicio1 {

    public static boolean validarCarnet(String carnet) {
        String patron = "^\\d{9}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(carnet);
        return matcher.matches();
    }

    public static boolean validarCorreoUSAC(String correo) {
        String patron = "^[a-zA-Z0-9][a-zA-Z0-9._-]*@usac\\.edu\\.gt$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean validarTelefonoGT(String telefono) {
        String patron = "^[3456]\\d{3}-?\\d{4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("=== Validación de Carnet ===");
        System.out.println("202300123: " + validarCarnet("202300123"));
        System.out.println("202512345: " + validarCarnet("202512345"));
        System.out.println("20230012: " + validarCarnet("20230012"));
        System.out.println("2023ABC12: " + validarCarnet("2023ABC12"));

        // Validar Correo USAC
        System.out.println("\n=== Validación de Correo ==");
        System.out.println("juan.perez@usac.edu.gt: " + validarCorreoUSAC("juan.perez@usac.edu.gt"));
        System.out.println("carla_001@usac.edu.gt: " + validarCorreoUSAC("carla_001@usac.edu.gt"));
        System.out.println("juan@gmail.com: " + validarCorreoUSAC("juan@gmail.com"));
        System.out.println(".juan@usac.edu.gt: " + validarCorreoUSAC(".juan@usac.edu.gt"));

        System.out.println("\n=== Validar Teléfono ===");
        System.out.println("5555-1234: " + validarTelefonoGT("5555-1234"));
        System.out.println("30001234: " + validarTelefonoGT("30001234"));
        System.out.println("1234-5678: " + validarTelefonoGT("1234-5678"));
        System.out.println("555-1234: " + validarTelefonoGT("555-1234"));
    }
}