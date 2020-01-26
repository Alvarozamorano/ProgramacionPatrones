package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para probar la factoria de publicaciones
 * @author Álvaro Zamorano
 */
public class Prueba {

    public static void main(String[] args) {
        FactoriaPublicaciones fp = new FactoriaPublicaciones();
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("autor1");
        Date d = new Date();
        Biblioteca b = new Biblioteca("Politecnica");
        Publicacion libro1, revista1, proyecto1;
        libro1 = fp.getPublicacion(0, "libro1", "ed", 1, "L1", "ISBN", "titulo", "autoresa", d, "materia",b);
        revista1 = fp.getPublicacion(1, "revista1", 2, 3, "R1", "ISBN", "titulo", "autoresb", d, "materia",b);
        proyecto1 = fp.getPublicacion(2, autores, "proyecto1", 3.5, "P1", "ISBN", "titulo", "autoresc", d, "materia",b);
        String editorial = (String) libro1.getParametro2();
        System.out.println(editorial);
        Infraestructura sala1 = new Sala(2, 3, "S1",b);
        System.out.println(sala1.toString());
        
    }

}
