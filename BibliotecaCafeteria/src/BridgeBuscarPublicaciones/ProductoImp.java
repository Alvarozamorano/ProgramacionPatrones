package BridgeBuscarPublicaciones;

import FactPublicaciones.iProductoBiblioteca;
import java.util.ArrayList;

/**
 * Implementador. Clase general para buscar las publicaciones.
 *
 * @author Álvaro Zamorano
 */
public abstract class ProductoImp {

    protected ArrayList<iProductoBiblioteca> _productos;

    public ProductoImp(ArrayList<iProductoBiblioteca> _publicaciones) {
        //this._publicaciones = obtenerListaPublicaciones(_publicaciones);
         this._productos = _publicaciones;
    }

    /**
     * Busca en las publicaciones por el criterio indicado.
     *
     * @param criterio autor(String), fecha(Date), materia(String) o
     * título(String)
     * @return Cadena con las publicaciones ordenadas.
     */
    public abstract String busca(Object criterio);

    /**
     * Devuelve una cadena con las publicaciones de una manera correcta para
     * visualizar
     *
     * @param publicaciones
     * @return Cadena enumerada
     */
    public String listadoProductos(ArrayList<iProductoBiblioteca> productos) {
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (iProductoBiblioteca oe : productos) {
            lista.append(i++).append(" - ");
            lista.append(oe.toString()).append("\n");
        }
        return lista.toString();
    }
    
}
