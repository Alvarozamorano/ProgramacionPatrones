package AdapterTemplateMethod_SingletonProxyServidor;

import SingletonProxyServidor.TipoArchivo;
import java.io.File;
import java.io.IOException;

/**
 * Clase concreta del adaptador del servidor que implementa las concreciones para
 * el personal de universidad
 * @author David Menoyo Ros
 */
public class AdaptadorServidorPersonalUniversidad extends AdaptadorServidor {

    public AdaptadorServidorPersonalUniversidad() {
        
    }

    @Override
    public File obtenerRuta() {
        return new File(super.singletonProxyServidor.getRutaPersonalUniversidad());
    }

    @Override
    public Object obtenerDeserializable(String identificador) throws IOException, ClassNotFoundException {
        return super.singletonProxyServidor.cargar_archivo(TipoArchivo.PERSONAL_UNIVERSIDAD, identificador);
    }
}
