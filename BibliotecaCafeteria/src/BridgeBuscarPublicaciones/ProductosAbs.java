package BridgeBuscarPublicaciones;

/**
 * Abstracción: Define la interfaz de la abstracción y mantiene una referencia
 * al objeto Implementador.
 *
 * @author Álvaro Zamorano
 */
public class ProductosAbs {

    private ProductoImp _imp;

    public ProductoImp getImp() {
        return _imp;
    }

    public void setImp(ProductoImp _imp) {
        this._imp = _imp;
    }

    /**
     * Busca en los productos según el criterio pasado como arguumento.
     *
     * @param criterio Criterio de búsqueda.
     * @return Cadena con los productos buscadas.
     */
    public String busca(Object criterio) {
        return _imp.busca(criterio);
    }
}
