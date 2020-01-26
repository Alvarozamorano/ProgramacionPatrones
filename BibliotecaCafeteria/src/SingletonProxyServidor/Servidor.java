package SingletonProxyServidor;

import FactProductosCafeteria.ProductoCafeteria;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import bibliotecacafeteria.Cafeteria;
import PersonalUniversidad.PersonalUniversidad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/** Clase que representa el servidor
 * Servicios para guardar, cargar y eliminar objetos del servidor almacenados.
 * @author David Menoyo Ros
 */
public class Servidor implements IServidor{

    
    public static String RUTA_PERSONAL_UNIVERSIDAD = "./personalUniversidad/";
    public static String RUTA_PRODUCTO_CAFETERIA = "./productoCafeteria/";
    public static String RUTA_PRODUCTO_BIBLIOTECA = "./productoBiblioteca/";
    public static String RUTA_BIBLIOTECA = "./Biblioteca/";
    public static String RUTA_CAFETERIA = "./Cafeteria/";
    public static String EXTENSION_ARCHIVO = ".dat";
    
   
    /**
     * Servicio para eliminar un objeto.
     * @param objeto
     * @throws IOException 
     */
    @Override
    public void eliminar_archivo(Object objeto) throws IOException {
        String ruta = "";
        String identificador = "";
        
        if( objeto instanceof PersonalUniversidad){
            ruta = RUTA_PERSONAL_UNIVERSIDAD;
            identificador = ((PersonalUniversidad)objeto).getDni()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof ProductoCafeteria ){
            ruta = RUTA_PRODUCTO_CAFETERIA;
            identificador =  ((ProductoCafeteria)objeto).getIdentificador()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof iProductoBiblioteca){
            ruta = RUTA_PRODUCTO_BIBLIOTECA;
            identificador = ((iProductoBiblioteca)objeto).getIdeintificador()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof Biblioteca){
            ruta = RUTA_BIBLIOTECA;
            identificador = ((Biblioteca)objeto).getNombre()+EXTENSION_ARCHIVO;
        }
        
        
        File carpeta = new File(ruta);
        if(carpeta.isDirectory()){
            
            //Eliminamos el serializable 
            // Aquí la carpeta donde se encuentra, puesto que ya sabemos que existe, vamos directamente.
            String pathSerializable = ruta + identificador;           
            File archivo = new File(pathSerializable);
            archivo.delete();//Borro directamente el serializable.
            System.out.println("He borrado el archivo registrado.");

        }else{
              System.out.println("El archivo no existe.");
        }
        
    }
    
    
    /**
     * Servicio para guardar un objeto.
     * @param objeto
     * @throws IOException 
     */
    @Override
    public void guardar_archivo(Object objeto) throws IOException{ 
        String ruta = "";
        String identificador = "";
        
        if( objeto instanceof PersonalUniversidad){
            ruta = RUTA_PERSONAL_UNIVERSIDAD;
            identificador = ((PersonalUniversidad)objeto).getDni()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof ProductoCafeteria ){
            ruta = RUTA_PRODUCTO_CAFETERIA;
            identificador =  ((ProductoCafeteria)objeto).getIdentificador()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof iProductoBiblioteca){
            ruta = RUTA_PRODUCTO_BIBLIOTECA;
            identificador = ((iProductoBiblioteca)objeto).getIdeintificador()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof Biblioteca){
            ruta = RUTA_BIBLIOTECA;
            identificador = ((Biblioteca)objeto).getNombre()+EXTENSION_ARCHIVO;
        }else if(objeto instanceof Cafeteria){
            ruta = RUTA_CAFETERIA;
            identificador = ((Cafeteria)objeto).getNombre()+EXTENSION_ARCHIVO;
        }
        
        //Creando un objeto File sobre el directorio que queremos explorar o crear si no existe
        File file = new File(ruta);
        if(!file.exists()){
            //Creando el directorio
            boolean bool = file.mkdir();
            if(bool){
               System.out.println("Directorio creado correctamente");
            }else{
               System.out.println("No se pudo crear el directorio");
            }
        }
        
        FileOutputStream fileOutputStream = new FileOutputStream(ruta + identificador);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(objeto);
            objectOutputStream.flush();
        }        
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
    public Object cargar_archivo(TipoArchivo tipoArchivo,String identificacion) throws IOException, ClassNotFoundException {
        String ruta = "";
        String identificador = "";
        if( tipoArchivo == TipoArchivo.PERSONAL_UNIVERSIDAD){
            ruta = RUTA_PERSONAL_UNIVERSIDAD;
            identificador = identificacion+EXTENSION_ARCHIVO;
        }else if(tipoArchivo == TipoArchivo.PRODUCTO_CAFETERIA){
            ruta = RUTA_PRODUCTO_CAFETERIA;
            identificador =  identificacion+EXTENSION_ARCHIVO;
        }else if(tipoArchivo == TipoArchivo.PRODUCTO_BIBLIOTECA){
            ruta = RUTA_PRODUCTO_BIBLIOTECA;
            identificador = identificacion+EXTENSION_ARCHIVO;
        }else if(tipoArchivo == TipoArchivo.BIBLIOTECA){
            ruta = RUTA_BIBLIOTECA;
            identificador = identificacion+EXTENSION_ARCHIVO;
        }else if(tipoArchivo == TipoArchivo.CAFETERIA){
            ruta = RUTA_CAFETERIA;
            identificador = identificacion+EXTENSION_ARCHIVO;
        }
        
        Object objeto = null;
        
        FileInputStream fileInputStream = new FileInputStream(ruta + identificador);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        
        objeto = objectInputStream.readObject();
        objectInputStream.close(); 
        
        return objeto;
    }
      
}
