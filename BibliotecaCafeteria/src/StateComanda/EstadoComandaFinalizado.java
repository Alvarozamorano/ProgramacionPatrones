package StateComanda;

import java.io.Serializable;

/**
 * Clase que representa el estado Finalizado de la Comanda
 * @author David Menoyo Ros
 */
public class EstadoComandaFinalizado implements iEstadoComanda, Serializable{

    /**
     * Acción a ejecutar en este estado.
     * @param comanda 
     */
    @Override
    public void ejecutar(Comanda comanda) {
        System.out.println("Comanda entregada");
    }
    
    /**
     * Método toString que devuelve una representación de este estado.
     * @return String
     */
    @Override
    public String toString() {
        return "Comanda finalizada";
    }
}
