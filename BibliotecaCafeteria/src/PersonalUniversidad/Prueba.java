package PersonalUniversidad;

/**
 * Clase para probar la creación de PersonalUniversidad con el patrón prototype
 * @author David Menoyo Ros
 */
public class Prueba {
    public static void main(String[] args){
        
        PersonalUniversidad pu1 = new PersonalUniversidad("pepe", "ramirez", "34000000W", "yo@tumail.com", "1234", "112", new Direccion("C/Mayor", "11", "3"), null);
        
        PersonalUniversidad pu2 = (PersonalUniversidad) pu1.copia();
        
    }
}
