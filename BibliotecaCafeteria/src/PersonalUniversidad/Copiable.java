package PersonalUniversidad;

/**
 * Interfaz Copiable para poder realizar el patrón de creación Prototype.
 * @author David Menoyo Ros
 */
public interface Copiable {
    
     /**
     * Motodo de copia.
     *
     * @return Objeto copiado.
     */
    public Object copia();
}
