package BridgeBuscarPublicaciones;

import FactPublicaciones.Publicacion;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;

/**
 * Define las implementacion necesaria para buscar las publicaciones por materia
 *
 * @author Álvaro Zamorano
 */
public class ProductoImpPubMateria extends ProductoImp {

    public ProductoImpPubMateria(ArrayList<iProductoBiblioteca> _publicaciones) {
        super(_publicaciones);
    }

    /**
     * Devuelve las publicaciones enumeradas con la materia pasado por parámetro
     *
     * @param materia Materia a buscar en las publicaciones
     * @return Cadena de publicaciones con la materia pasada por parámetro
     */
    @Override
    public String busca(Object materia) {
        String MateriaBuscar = (String) materia;
        ArrayList<iProductoBiblioteca> publicacionesBuscar = new ArrayList<>();

        Agregado agregado = new AgregadoConcreto(_productos);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca producto = (iProductoBiblioteca) iterador.elementoActual();
            if (producto instanceof Publicacion) {
                Publicacion publicacion = (Publicacion) producto;
                if (publicacion.getMateria().equals(MateriaBuscar)) {
                    publicacionesBuscar.add(publicacion);
                }
            }

            iterador.siguiente();
        }
        return listadoProductos(publicacionesBuscar);
    }
}
