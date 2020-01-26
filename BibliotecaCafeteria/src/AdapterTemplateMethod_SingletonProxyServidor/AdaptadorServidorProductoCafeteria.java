package AdapterTemplateMethod_SingletonProxyServidor;

import SingletonProxyServidor.TipoArchivo;
import java.io.File;
import java.io.IOException;

/**
 * Clase concreta del adaptador del servidor que implementa las concreciones para
 * los productos de cafeteria
 * @author David Menoyo Ros
 */
public class AdaptadorServidorProductoCafeteria extends AdaptadorServidor {

    public AdaptadorServidorProductoCafeteria() {
    }

    @Override
    public File obtenerRuta() {
        return new File(super.singletonProxyServidor.getRutaProductoCafeteria());
    }

    @Override
    public Object obtenerDeserializable(String identificador) throws IOException, ClassNotFoundException {
        return super.singletonProxyServidor.cargar_archivo(TipoArchivo.PRODUCTO_CAFETERIA, identificador);
    }
    
}
