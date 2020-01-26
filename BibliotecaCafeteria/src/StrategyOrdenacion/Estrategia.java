package StrategyOrdenacion;

import FactPublicaciones.Publicacion;
import java.util.ArrayList;

/**
 * Interfaz que define los métodos que maneja la clase Contexto
 *
 * @author Álvaro Zamorano
 */
public interface Estrategia {

    /**
     * Ordena la lista de publicaciones con el criterio de ordenación dado
     *
     * @param publicaciones Lista de publicaciones
     * @param criterio asc(ascendente) o des(descendente)
     */
    public void ordena(ArrayList<Publicacion> publicaciones, String criterio);
}
