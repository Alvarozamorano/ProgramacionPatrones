package StrategyOrdenacion;

import FactPublicaciones.FactoriaPublicaciones;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para probar el correcto funcionamiento del patrón Strategy
 * @author Álvaro Zamorano
 */
public class PruebaStrategy {

    public static void main(String[] args) {
        FactoriaPublicaciones fp = new FactoriaPublicaciones();
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("autor1");
        Date d = new Date();
        Biblioteca b = new Biblioteca("Politecnica");
        iProductoBiblioteca libro1, revista1, proyecto1;
        libro1 = fp.getPublicacion(0, "libro1", "ed", 1, "L1", "ISBN", "titulo", "autoresa", d, "materia",b);
        revista1 = fp.getPublicacion(1, "revista1", 2, 3, "R1", "ISBN", "titulo", "autoresb", d, "materia",b);
        proyecto1 = fp.getPublicacion(2, autores, "proyecto1", 3.5, "P1", "ISBN", "titulo", "autoresc", d, "materia",b);

        ArrayList<iProductoBiblioteca> pub = new ArrayList<>();
        pub.add(libro1);
        pub.add(revista1);
        pub.add(proyecto1);

        Estrategia est = new EstrategiaConcretaAutor();
        //El contexto
        Contexto contexto = new Contexto(pub);
        contexto.setEstrategia(est);
        contexto.ejecutaEstrategia("asc");
    }
}
