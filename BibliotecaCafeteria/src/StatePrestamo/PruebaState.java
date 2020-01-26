package StatePrestamo;

import FactPublicaciones.FactoriaPublicaciones;
import FactPublicaciones.Sala;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import FactRol.Rol;
import FactRol.RolEstudiante;
import FactRol.RolProfesor;
import PersonalUniversidad.Direccion;
import PersonalUniversidad.PersonalUniversidad;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Álvaro Zamorano
 */
public class PruebaState {
    public static void main(String[] args){
        PersonalUniversidad personalUniversidad = new PersonalUniversidad("pepe", "ramirez", "34000000W", "yo@tumail.com", "1234", "112", new Direccion("C/Mayor", "11", "3"), null);
        Rol estudiante = new RolEstudiante();
        Rol profesor = new RolProfesor();
        personalUniversidad.añadirRol(estudiante);//p.añadirRol(profesor);
        
        FactoriaPublicaciones fp = new FactoriaPublicaciones();
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("autor1");
        Date fechaActual = new Date();
        Biblioteca b = new Biblioteca("Politecnica");
        iProductoBiblioteca libro1 = fp.getPublicacion(0, "libro1", "ed", 1, "L1", "ISBN", "titulo", "autoresa", fechaActual, "materia",b);
        Sala sala1 = new Sala(4,3,"S1",b);
        
        
        Date fechaMulta = new Date(12,4,4);
        personalUniversidad.setFechaFinMulta(fechaMulta);
        if(fechaMulta.after(fechaActual)){
            System.out.println("No puedes coger productos hasta: " + fechaMulta);
        }else{
            Prestamo prestamo = new Prestamo(personalUniversidad,sala1);
            prestamo.concederPrestamo();
            prestamo.verMulta();
            //prestamo.setFechaDevolucionPrestamo(fechaMulta);
            prestamo.devolverPrestamo();
            System.out.println(prestamo.getPersona().getPrestamos().toString());
        }
        
    }
}
