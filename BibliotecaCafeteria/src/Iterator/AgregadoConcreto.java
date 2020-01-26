package Iterator;

import java.util.ArrayList;

/**
 * Clase agregado concreto del iterator
 * @author Álvaro Zamorano
 */
public class AgregadoConcreto implements Agregado {

    // Lista de elementos a recorrer.
    public ArrayList _elementos;

    /**
     * Constructor.
     *
     * @param vec Lista de elementos a recorrer.
     */
    public AgregadoConcreto(ArrayList vec) {
        _elementos = vec;
    }

    @Override
    public Iterador crearIterador() {
        return new IteradorConcreto(this);
    }
}
