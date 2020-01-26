package BridgeBuscarPublicaciones;

import FactPublicaciones.Publicacion;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;

/**
 * Define las implementacion necesaria para buscar las publicaciones por autor
 *
 * @author Álvaro Zamorano
 */
public class ProductoImpPubAutor extends ProductoImp {

    public ProductoImpPubAutor(ArrayList<iProductoBiblioteca> _publicaciones) {
        super(_publicaciones);
    }

    /**
     * Devuelve las publicaciones enumeradas con el autor pasado por parámetro
     *
     * @param autor Autor a buscar
     * @return Cadena con el autor pasado por parámetro
     */
    @Override
    public String busca(Object autor) {
        String autorBuscar = (String) autor;
        ArrayList<iProductoBiblioteca> publicacionesBuscar = new ArrayList<>();
        Agregado agregado = new AgregadoConcreto(_productos);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca producto = (iProductoBiblioteca) iterador.elementoActual();
            if (producto instanceof Publicacion) {
                Publicacion publicacion = (Publicacion) producto;
                if (publicacion.getAutor().equals(autorBuscar)) {
                    publicacionesBuscar.add(publicacion);
                }
            }

            iterador.siguiente();
        }
        return listadoProductos(publicacionesBuscar);
    }

}
