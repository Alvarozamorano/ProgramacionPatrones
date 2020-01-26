package bibliotecacafeteria;

import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import java.io.IOException;

/**
 * Clase con la que comprobamos la correcta carga de los objetos Cafeteria y
 * Biblioteca.
 * @author Álvaro Zamorano
 */
public class BibliotecaCafeteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Biblioteca biblioteca = (Biblioteca) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.BIBLIOTECA, "Politecnica");
        Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
        
        System.out.println(biblioteca.getPrestamos().toString());
    }
    
}
