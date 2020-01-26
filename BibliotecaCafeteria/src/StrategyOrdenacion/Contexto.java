package StrategyOrdenacion;

import FactPublicaciones.Publicacion;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;

/**
 * Utiliza las diferentes estrategias para las diferentes opciones de búsqueda
 *
 * @author Álvaro Zamorano
 */
public class Contexto {

    private Estrategia _estrategia; // Estrategia que se usa.
    private ArrayList<Publicacion> _publicaciones; // Lista de publicaciones

    /**
     * Constructor.
     *
     * @param publicaciones Lista de publicaciones.
     */
    public Contexto(ArrayList<iProductoBiblioteca> publicaciones) {
        _publicaciones = obtenerListaPublicaciones(publicaciones);
    }

    /**
     * Establece la estrategia a usar.
     *
     * @param e Estrategia a usar.
     */
    public void setEstrategia(Estrategia e) {
        this._estrategia = e;
    }

    public void setPublicaciones(ArrayList<iProductoBiblioteca> publicaciones) {
        this._publicaciones = obtenerListaPublicaciones(publicaciones);;
    }

    /**
     * Ejecuta la estrategia.
     *
     * @param criterio des (descendente) o asc(ascendente)
     * @return String de publicaciones enumeradas
     */
    public String ejecutaEstrategia(String criterio) {
        _estrategia.ordena(_publicaciones, criterio);

        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (iProductoBiblioteca oe : _publicaciones) {
            lista.append(i++).append(" - ");
            lista.append(oe.toString()).append("\n");
        }
        return lista.toString();
    }

    /**
     * Devuelve una lista con las publicaciones de la lista de productos de
     * biblioteca pasados por parametro
     *
     * @param lista Lista de productos de biblioteca
     * @return Lista de publicaciones
     */
    private ArrayList obtenerListaPublicaciones(ArrayList<iProductoBiblioteca> lista) {
        Agregado agregado = new AgregadoConcreto(lista);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        ArrayList publicaciones = new ArrayList();
        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca publicacion = (iProductoBiblioteca) iterador.elementoActual();
            if (publicacion instanceof Publicacion) {
                publicaciones.add(publicacion);
            }
            iterador.siguiente();
        }
        return publicaciones;
    }
}
