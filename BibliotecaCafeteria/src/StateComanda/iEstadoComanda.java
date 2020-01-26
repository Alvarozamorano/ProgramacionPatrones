package StateComanda;

/**
 * Interfaz de los estados de la Comanda.
 * @author David Menoyo Ros
 */
public interface iEstadoComanda {

    /**
     * Acción a ejecutar del estado concreto.
     * @param comanda 
     */
    public void ejecutar(Comanda comanda);
    
    /**
     * Método toString que devuelve una cadena que representa el estado o la
     * información/acción más importante del estado concreto.
     * @return 
     */
    @Override
    public String toString();
    
    
}
