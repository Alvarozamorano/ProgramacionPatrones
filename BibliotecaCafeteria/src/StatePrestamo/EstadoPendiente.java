package StatePrestamo;

import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import bibliotecacafeteria.Biblioteca;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa las funciones a realizar cuando un usuario indica que
 * quiere un producto de la biblioteca
 *
 * @author Álvaro Zamorano
 */
public class EstadoPendiente implements iEstadoPrestamo {

    @Override
    public void ejecutar(Prestamo prestamo) {
        //Añadimos el préstamo a la clase Personal
        prestamo.getPersona().añadirPrestamo(prestamo);

        //Identificamos como no disponible el producto del préstamo
        prestamo.getProductoBiblioteca().setEstaDisponible(false);

        //Añadimos el prestamo a la biblioteca
        String nombreBiblio = prestamo.getProductoBiblioteca().getBiblioteca().getNombre();
        try {
            Biblioteca biblioteca = (Biblioteca) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.BIBLIOTECA, nombreBiblio);
            biblioteca.añadirPrestamo(prestamo);
            prestamo.setBiblioteca(biblioteca);
        } catch (IOException ex) {
            Logger.getLogger(EstadoPendiente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstadoPendiente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
