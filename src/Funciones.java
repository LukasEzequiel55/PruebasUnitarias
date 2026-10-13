import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funciones {

    public double sumar(double a, double b){
        return a + b;
    }//sumar

    public boolean validarCorreo(String correo){
        Pattern regex = Pattern.compile("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
        Matcher m = regex.matcher(correo);

        if (!m.matches()){
            return false;
        }//if
        return true;
    }//Validar Correo
}//class Funciones
