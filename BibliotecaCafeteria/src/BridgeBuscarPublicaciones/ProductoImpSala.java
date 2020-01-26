package BridgeBuscarPublicaciones;

import FactPublicaciones.Sala;
import FactPublicaciones.iProductoBiblioteca;
import Iterator.Agregado;
import Iterator.AgregadoConcreto;
import Iterator.Iterador;
import java.util.ArrayList;

/**
 * Define las implementacion necesaria para buscar las salas por capacidad
 *
 * @author Álvaro Zamorano
 */
public class ProductoImpSala extends ProductoImp {

    public ProductoImpSala(ArrayList<iProductoBiblioteca> _publicaciones) {
        super(_publicaciones);
    }

    /**
     * Devuelve las salas enumeradas con la capacidad pasado por parámetro
     *
     * @param capacidad Capacidad a buscar en las salas
     * @return Cadena de salas con la capacidad pasada por parámetro
     */
    @Override
    public String busca(Object capacidad) {
        int capacidadBuscar = (int) capacidad;
        ArrayList<iProductoBiblioteca> salas = new ArrayList<>();
        Agregado agregado = new AgregadoConcreto(_productos);
        // Crea el iterador.
        Iterador iterador = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iterador.hayMas()) {
            iProductoBiblioteca producto = (iProductoBiblioteca) iterador.elementoActual();
            if (producto instanceof Sala) {
                Sala sala = (Sala) producto;
                if (sala.getCapacidad() == capacidadBuscar) {
                    salas.add(sala);
                }
            }

            iterador.siguiente();
        }
        return listadoProductos(salas);
    }

}
