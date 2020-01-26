package AdapterTemplateMethod_SingletonProxyServidor;

import SingletonProxyServidor.TipoArchivo;
import java.io.File;
import java.io.IOException;

/**
 * Clase concreta del adaptador del servidor que implementa las concreciones para
 * los productos de biblioteca
 * @author David Menoyo Ros
 */
public class AdaptadorServidorProductoBiblioteca extends AdaptadorServidor {

    public AdaptadorServidorProductoBiblioteca() {
    }

    @Override
    public File obtenerRuta() {
        return new File(super.singletonProxyServidor.getRutaProductoBiblioteca());
    }

    @Override
    public Object obtenerDeserializable(String identificador) throws IOException, ClassNotFoundException {
        return super.singletonProxyServidor.cargar_archivo(TipoArchivo.PRODUCTO_BIBLIOTECA,identificador);
    }
    
}
