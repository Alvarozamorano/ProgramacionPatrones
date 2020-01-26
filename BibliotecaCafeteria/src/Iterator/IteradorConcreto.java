package Iterator;

/**
 * Clase iterator concreto del iterator
 * @author Álvaro Zamorano
 */
public class IteradorConcreto implements Iterador {

    // Referencia al agregado concreto.
    private AgregadoConcreto _agregado;
    // Indica la posición actual en la lista.
    private int _indice = 0;

    /**
     * Constructor.
     *
     * @param agregado Agregado concreto.
     */
    public IteradorConcreto(AgregadoConcreto agregado) {
        _agregado = agregado;
    }

    @Override
    public Object primero() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (!_agregado._elementos.isEmpty()) {
            _indice = 0;
            objeto = _agregado._elementos.get(0);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }

    @Override
    public Object siguiente() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (_indice < _agregado._elementos.size()) {
            objeto = _agregado._elementos.get(_indice);
            _indice++;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }

    @Override
    public boolean hayMas() {
        boolean resultado = true;
        if (_agregado._elementos.isEmpty() || _indice == _agregado._elementos.size()) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public Object elementoActual() throws IndexOutOfBoundsException {
        Object objeto = null;
        if (_indice < _agregado._elementos.size()) {
            objeto = _agregado._elementos.get(_indice);
        } else {
            throw new IndexOutOfBoundsException();
        }
        return objeto;
    }
}
