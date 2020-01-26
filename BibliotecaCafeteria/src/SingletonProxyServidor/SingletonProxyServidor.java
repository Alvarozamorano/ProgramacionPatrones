package SingletonProxyServidor;

import java.io.IOException;

/**
 * Objeto Singleton del Servidor
 * @author David Menoyo Ros
 */
public class SingletonProxyServidor implements IServidor {

    private Servidor servidor = new Servidor();
    private static SingletonProxyServidor instancia;
    
    

    /**
     * Constructor privado
     */
    private SingletonProxyServidor() {

    }

    /**
     * Devuelve la instancia de la clase.
     *
     * @return Instancia de la clase.
     */
    public static SingletonProxyServidor getInstancia() {
        if (instancia == null) {// Si la instancia es null, se crea.
            instancia = new SingletonProxyServidor();
        }
        return instancia;
    }

    //Servicios
    
    /**
     * Servicio para eliminar un objeto.
     * @param objeto
     * @throws IOException 
     */
    @Override
    public void eliminar_archivo(Object objeto) throws IOException {
        servidor.eliminar_archivo(objeto);
    }

    /**
     * Servicio para guardar un objeto.
     * @param objeto
     * @throws IOException 
     */
    @Override
    public void guardar_archivo(Object objeto) throws IOException {
        servidor.guardar_archivo(objeto);
    }

    /**
     * Servicio para cargar un objeto de un determinado tipo e identificación.
     * @param tipoArchivo
     * @param identificacion
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    @Override
    public Object cargar_archivo(TipoArchivo tipoArchivo, String identificacion) throws IOException, ClassNotFoundException {
        return servidor.cargar_archivo(tipoArchivo, identificacion);
    }

    //Gets
    public String getRutaPersonalUniversidad() {
        return servidor.RUTA_PERSONAL_UNIVERSIDAD;
    }

    public String getRutaProductoCafeteria() {
        return servidor.RUTA_PRODUCTO_CAFETERIA;
    }

    public String getRutaProductoBiblioteca() {
        return servidor.RUTA_PRODUCTO_BIBLIOTECA;
    }

    public String getRutaBiblioteca() {
        return servidor.RUTA_BIBLIOTECA;
    }

    public String getExtensionArchivo() {
        return servidor.EXTENSION_ARCHIVO;
    }
    
    public String getRutaCafeteria() {
        return servidor.RUTA_CAFETERIA;
    }

}
