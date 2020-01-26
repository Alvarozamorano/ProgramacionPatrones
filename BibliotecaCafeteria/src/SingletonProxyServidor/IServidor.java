package SingletonProxyServidor;

import java.io.IOException;

/**
 * Interfaz de un servidor.
 * Servicios para guardar, cargar y eliminar objetos del servidor almacenados.
 * @author David Menoyo Ros
 */
public interface IServidor {
    
    /**
     * Servicio para eliminar un objeto.
     * @param objeto
     * @throws IOException 
     */
    void eliminar_archivo(Object objeto)throws IOException;
    
    /**
     * Servicio para guardar un objeto.
     * @param objeto
     * @throws IOException 
     */
    void guardar_archivo(Object objeto)throws IOException;
    
    /**
     * Servicio para cargar un objeto de un determinado tipo e identificación.
     * @param tipoArchivo
     * @param identificacion
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    Object cargar_archivo(TipoArchivo tipoArchivo, String identificacion) throws IOException, ClassNotFoundException;
}
