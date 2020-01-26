package bibliotecacafeteria;

import FactPublicaciones.iProductoBiblioteca;
import StatePrestamo.EstadoPendiente;
import StatePrestamo.Prestamo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Clase que representa una Biblioteca
 * @author Álvaro Zamorano
 */
public class Biblioteca implements Serializable {

    private String _nombre;
    private ArrayList<iProductoBiblioteca> _productos;
    private ArrayList<Prestamo> _prestamos;

    /**
     * Constructor
     * @param _nombre 
     */
    public Biblioteca(String _nombre) {
        this._nombre = _nombre;
        _productos = new ArrayList();
        _prestamos = new ArrayList();
    }

    /**
     * Añadimos un producto pasado por parámetro a la lista de productos de la
     * biblioteca.
     * @param producto 
     */
    public void añadirProducto(iProductoBiblioteca producto) {
        _productos.add(producto);
    }

    /**
     * Eliminamos un producto pasado por parámetro de la lista de productos de
     * la biblioteca
     * @param producto 
     */
    public void borrarProducto(iProductoBiblioteca producto) {
        _productos.remove(producto);
    }

    /**
     * Obtenemos la cantidad de productos disponibles en la biblioteca
     * @return int
     */
    public int numeroProductos() {
        return _productos.size();
    }

    /**
     * Añadimos un préstamo pasado parámetro a la lista de prestamos de la
     * biblioteca
     * @param prestamo 
     */
    public void añadirPrestamo(Prestamo prestamo) {
        _prestamos.add(prestamo);
    }

    /**
     * Obtenemos la cantidad de préstamos de la biblioteca.
     * @return int
     */
    public int numeroPrestamos() {
        return _prestamos.size();
    }

    /**
     * Obtenemos una cadena que representa los préstamos en estado pendiente
     * de la lista de prestamos de la cafetería.
     * @return String
     */
    public String obtienePrestamosPendientes() {
        //ArrayList<Prestamo> prestamos = new ArrayList<>(_prestamos.values());
        ArrayList<Prestamo> prestamosPendientes = new ArrayList();
        for (int i = 0; i < _prestamos.size(); i++) {
            if (_prestamos.get(i).getEstadoPrestamo() instanceof EstadoPendiente) {
                prestamosPendientes.add(_prestamos.get(i));
            }
        }
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (Prestamo p : prestamosPendientes) {
            lista.append(i++).append(" - ");
            lista.append(p.toString()).append("\n");
        }
        return lista.toString();
    }

    /**
     * Obtenemos el índice de un préstamos concreto en la lista de préstamos
     * @param prestamo
     * @return int
     */
    public int devIndicePrestamo(Prestamo prestamo) {
        int j = 0;
        for (int i = 0; i < _prestamos.size(); i++) {
            if (_prestamos.get(i).equals(prestamo)) {
                j = i;
            }
        }
        return j;
    }

    /**
     * Obtenemos el préstamo identificado por su id si dicho prestamo está en
     * estado pendiente.
     * @param id
     * @return Prestamo
     */
    public Prestamo contienePrestamoConcedido(String id) {
        for (int i = 0; i < _prestamos.size(); i++) {
            if (_prestamos.get(i).getEstadoPrestamo() instanceof EstadoPendiente
                    && _prestamos.get(i).getProductoBiblioteca().getIdeintificador().equals(id)) {
                return _prestamos.get(i);
            }
        }
        return null;
    }
    
    
    //Gets
    public ArrayList<iProductoBiblioteca> getProductos() {
        return _productos;
    }

    public String getNombre() {
        return _nombre;
    }
    
    public ArrayList<Prestamo> getPrestamos() {
        return _prestamos;
    }

}
