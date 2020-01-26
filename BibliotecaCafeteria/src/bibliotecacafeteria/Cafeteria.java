package bibliotecacafeteria;

import FactProductosCafeteria.ProductoCafeteria;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import StateComanda.Comanda;
import StateComanda.EstadoComandaPendiente;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Clase que representa una Cafetería
 * @author David Menoyo Ros
 */
public class Cafeteria implements Serializable{
    private String _nombre;
    private ArrayList<ProductoCafeteria> _productos;
    private ArrayList<Comanda> _comandas;

    /**
     * Constructor
     * @param _nombre 
     */
    public Cafeteria(String _nombre) {
        this._nombre = _nombre;
        _productos = new ArrayList<>();
        _comandas = new ArrayList<>();
        
    }

    /**
     * Añade a la lista de productos de la cafetería el producto pasado por
     * parámetro.
     * @param producto 
     */
    public void añadirProducto(ProductoCafeteria producto) {
        _productos.add(producto);
    }
    
    /**
     * Añade a la lista de comandas de la cafetería la comanda pasada por
     * parámetro.
     * @param comanda 
     */
    public void añadirComanda(Comanda comanda) {
        _comandas.add(comanda);
    }
    
    /**
     * Elimina a la lista de productos de la cafetería el producto que concuerde
     * con el identificador pasado por parámetro.
     * @param identificador 
     */
    public void eliminarProductoPorIdentificador(String identificador){
        for (int i = 0; i< _productos.size();i++) {
            
               if(_productos.get(i).getIdentificador().equals(identificador)){
                   _productos.remove(i);
               }
        }
    }
    
    /**
     * Obtenemos un booleano que nos indica si existe un cierto producto en la
     * lista de productos según su identificador.
     * @param identificador 
     * @return boolean
     */
    public boolean existeProductoPorIdentificador(String identificador){
        boolean existe = false;
        int i = 0;
        while (i< _productos.size() && !existe) {
            if(_productos.get(i).getIdentificador().equals(identificador)){
                existe = true;
            }
            i++;
        }
       return existe;
    }

    /**
     * Obtenemos el objeto ProductoCafeteria concreto de la lista de productos
     * de la Cafetería según su identificador.
     * @param id
     * @return ProductoCafeteria
     */
    public ProductoCafeteria getProductoConcreto(String id) {
        ProductoCafeteria producto = null;
        boolean productoObtenido = false;
        int i = 0;
        while (i< _productos.size() && !productoObtenido) {
            if(_productos.get(i).getIdentificador().equals(id)){
                producto = _productos.get(i);
            }
            i++;
        }
       return producto;
    }
    
    /**
     * Obtenemos una cadena que representa las comandas en estado pendiente
     * de la lista de Comandas de la Cafetería.
     * @return String
     */
    public String obtenerComandasPendientesString() {
        ArrayList<Comanda> comandasPendientes = new ArrayList();
        
        
        // Recorre la lista con el iterador.
        Agregado agregado = new AgregadoConcreto(_comandas);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            if (((Comanda)iterador.elementoActual()).getEstadoComanda() instanceof EstadoComandaPendiente) {
                comandasPendientes.add(((Comanda)iterador.elementoActual()));     
            }      
            iterador.siguiente();
        }
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (Comanda p : comandasPendientes) {
            lista.append(i++).append(" - ");
            lista.append(p.toString()).append("\n");
        }
        return lista.toString();
    }
    
    /**
     * Obtenemos una lista de objetos Comandas que estén en estado Pendiente
     * en la Cafetería.
     * @return ArrayList\<Comanda\>
     */
    public ArrayList<Comanda> obtenerComandasPendientes() {
        ArrayList<Comanda> comandasPendientes = new ArrayList();
        
        // Recorre la lista con el iterador.
        Agregado agregado = new AgregadoConcreto(_comandas);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            if (((Comanda)iterador.elementoActual()).getEstadoComanda() instanceof EstadoComandaPendiente) {
                comandasPendientes.add(((Comanda)iterador.elementoActual()));     
            }      
            iterador.siguiente();
        }
        return comandasPendientes;
    }
    
    
    
    //Gets y Sets
    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public ArrayList<ProductoCafeteria> getProductos() {
        return _productos;
    }

    public void setProductos(ArrayList<ProductoCafeteria> _productos) {
        this._productos = _productos;
    }

    public ArrayList<Comanda> getComandas() {
        return _comandas;
    }

    public void setComandas(ArrayList<Comanda> _comandas) {
        this._comandas = _comandas;
    }
    
}
