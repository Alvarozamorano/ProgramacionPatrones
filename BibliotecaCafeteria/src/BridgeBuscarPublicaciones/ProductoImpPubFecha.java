package BridgeBuscarPublicaciones;

import FactPublicaciones.Publicacion;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;
import java.util.Date;

/**
 * Define las implementacion necesaria para buscar las publicaciones por fecha
 *
 * @author Álvaro Zamorano
 */
public class ProductoImpPubFecha extends ProductoImp {

    public ProductoImpPubFecha(ArrayList<iProductoBiblioteca> _publicaciones) {
        super(_publicaciones);
    }

    /**
     * Devuelve las publicaciones enumeradas con la fecha pasado por parámetro
     *
     * @param fecha Fecha a buscar en las publicaciones
     * @return Cadena de publicaciones con la fecha pasada por parámetro
     */
    @Override
    public String busca(Object fecha) {
        Date FechaBuscar = (Date) fecha;
        ArrayList<iProductoBiblioteca> publicacionesBuscar = new ArrayList<>();

        Agregado agregado = new AgregadoConcreto(_productos);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca producto = (iProductoBiblioteca) iterador.elementoActual();
            if (producto instanceof Publicacion) {
                Publicacion publicacion = (Publicacion) producto;
                if (publicacion.getFechaPublicacion().equals(FechaBuscar)) {
                    publicacionesBuscar.add(publicacion);
                }
            }

            iterador.siguiente();
        }
        return listadoProductos(publicacionesBuscar);
    }
}
