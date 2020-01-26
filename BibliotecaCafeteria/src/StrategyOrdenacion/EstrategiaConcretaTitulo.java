package StrategyOrdenacion;

import FactPublicaciones.Publicacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Implementa las reglas necesarias para buscar las publicacion por titulo
 *
 * @author Álvaro Zamorano
 */
public class EstrategiaConcretaTitulo implements Estrategia {

    /**
     * Ordena las publicaciones por titulo
     *
     * @param publicaciones
     * @param criterio
     */
    @Override
    public void ordena(ArrayList<Publicacion> publicaciones, String criterio) {
        //Comparador para ordenar las publicaciones por Titulo.
        Comparator TituloComp = new Comparator() {
            @Override
            public int compare(Object p1, Object p2) {
                Publicacion pu1 = (Publicacion) p1;
                Publicacion pu2 = (Publicacion) p2;
                return pu1.getTitulo().compareTo(pu2.getTitulo());
            }
        };
        Collections.sort(publicaciones, TituloComp);
        if (criterio.equals("des")) {
            Collections.reverse(publicaciones);
        }
    }

}
