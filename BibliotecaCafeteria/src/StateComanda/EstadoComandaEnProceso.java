package StateComanda;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el estado En Proceso de la Comanda
 * @author David Menoyo Ros
 */
public class EstadoComandaEnProceso implements iEstadoComanda, Serializable{

    /**
     * Acción a ejecutar en este estado.
     * Simula la acción de cocinar con una espera de 6 segundos.
     * @param comanda 
     */
    @Override
    public void ejecutar(Comanda comanda) {
        try {
            System.out.println("Comanda empieza a concinarse:");
            for (int i = 0; i < 6; i++) {
                System.out.print(".");
                Thread.sleep(1000);
                
            }
            Thread.sleep(10);
            System.out.println("Termina de concinarse");
            } catch (InterruptedException ex) {
            Logger.getLogger(EstadoComandaEnProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método toString que devuelve una representación de este estado.
     * @return String
     */
    @Override
    public String toString() {
        return "Comanda en proceso";
    }
     
}
