package AdapterTemplateMethod_SingletonProxyServidor;

import SingletonProxyServidor.TipoArchivo;
import java.io.File;
import java.io.IOException;

/**
 * Clase concreta del adaptador del servidor que implementa las concreciones para
 * la biblioteca
 * @author David Menoyo Ros
 */
public class AdaptadorServidorBiblioteca extends AdaptadorServidor {

    public AdaptadorServidorBiblioteca() {

    }

    @Override
    public File obtenerRuta() {
        return new File(super.singletonProxyServidor.getRutaBiblioteca());
    }

    @Override
    public Object obtenerDeserializable(String identificador) throws IOException, ClassNotFoundException {
        return super.singletonProxyServidor.cargar_archivo(TipoArchivo.BIBLIOTECA, identificador);
    }

}
