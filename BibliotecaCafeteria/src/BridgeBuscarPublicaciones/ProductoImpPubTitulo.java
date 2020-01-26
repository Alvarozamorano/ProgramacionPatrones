package BridgeBuscarPublicaciones;

import FactPublicaciones.Publicacion;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;

/**
 * Define las implementacion necesaria para buscar las publicaciones por titulo
 *
 * @author Álvaro Zamorano
 */
public class ProductoImpPubTitulo extends ProductoImp {

    public ProductoImpPubTitulo(ArrayList<iProductoBiblioteca> _publicaciones) {
        super(_publicaciones);
    }

    /**
     * Devuelve las publicaciones enumeradas con el titulo pasado por parámetro
     *
     * @param titulo Titulo a buscar en las publicaciones
     * @return Cadena de publicaciones con el titulo pasada por parámetro
     */
    @Override
    public String busca(Object titulo) {
        String tituloBuscar = (String) titulo;
        ArrayList<iProductoBiblioteca> publicacionesBuscar = new ArrayList<>();

        Agregado agregado = new AgregadoConcreto(_productos);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca producto = (iProductoBiblioteca) iterador.elementoActual();
            if (producto instanceof Publicacion) {
                Publicacion publicacion = (Publicacion) producto;
                if (publicacion.getTitulo().equals(tituloBuscar)) {
                    publicacionesBuscar.add(publicacion);
                }
            }

            iterador.siguiente();
        }
        return listadoProductos(publicacionesBuscar);
    }

}
