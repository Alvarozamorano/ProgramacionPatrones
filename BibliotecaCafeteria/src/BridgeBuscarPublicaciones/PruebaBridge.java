package BridgeBuscarPublicaciones;

import FactPublicaciones.FactoriaPublicaciones;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Álvaro Zamorano Ortega
 */
public class PruebaBridge {

    public static void main(String[] args) throws ParseException {
        FactoriaPublicaciones fp = new FactoriaPublicaciones();
        ArrayList<String> autores = new ArrayList<String>();
        autores.add("autor1");
        String fecha = "04/05/1998 02:02:02";
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = f1.parse(fecha);
        Biblioteca b = new Biblioteca("Politecnica");
        iProductoBiblioteca libro1, revista1, proyecto1;
        libro1 = fp.getPublicacion(0, "libro1", "ed", 1, "L1", "ISBN", "titulo", "autoresa", d, "materia", b);
        revista1 = fp.getPublicacion(1, "revista1", 2, 3, "R1", "ISBN", "titulo", "autoresb", d, "materia", b);
        proyecto1 = fp.getPublicacion(2, autores, "proyecto1", 3.5, "P1", "ISBN", "titulo", "autoresc", d, "materia", b);

        ArrayList<iProductoBiblioteca> pub = new ArrayList<>();
        pub.add(libro1);
        pub.add(revista1);
        pub.add(proyecto1);

        ProductosAbs abst = new ProductosAbs();
        ProductoImpPubFecha imp = new ProductoImpPubFecha(pub);
        abst.setImp(imp);
        String fecha1 = "04/05/1998 02:02:02";
        //SimpleDateFormat f11 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date11 = f1.parse(fecha);
        System.out.println(date11.toString());
        System.out.println(abst.busca(date11));

        if (d.equals(date11)) {
            System.out.println("HOLA");
        }

    }
}
