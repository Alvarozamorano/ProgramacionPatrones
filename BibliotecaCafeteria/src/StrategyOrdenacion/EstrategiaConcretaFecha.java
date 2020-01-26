package StrategyOrdenacion;

import FactPublicaciones.Publicacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementa las reglas necesarias para buscar las publicacion por fecha
 *
 * @author Álvaro Zamorano
 */
public class EstrategiaConcretaFecha implements Estrategia {

    /**
     * Ordena las publicaciones por fecha
     *
     * @param publicaciones
     * @param criterio
     */
    @Override
    public void ordena(ArrayList<Publicacion> publicaciones, String criterio) {
        //Comparador para ordenar las publicaciones por fecha.
        Comparator TituloComp = new Comparator() {
            @Override
            public int compare(Object p1, Object p2) {
                Publicacion pu1 = (Publicacion) p1;
                Publicacion pu2 = (Publicacion) p2;
                return pu1.getFechaPublicacion().compareTo(pu2.getFechaPublicacion());
            }
        };
        Collections.sort(publicaciones, TituloComp);
        if (criterio.equals("des")) {
            Collections.reverse(publicaciones);
        }
    }
}
