package StatePrestamo;

import java.io.Serializable;

/**
 * Interfaz que define los métodos que dependen del estado del prestamo
 *
 * @author Álvaro Zamorano
 */
public interface iEstadoPrestamo extends Serializable {

    /**
     * Ejecuta las reglas definidas en cada estado
     *
     * @param prestamo
     */
    public void ejecutar(Prestamo prestamo);
}
