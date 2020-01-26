package AdapterTemplateMethod_SingletonProxyServidor;

import FactProductosCafeteria.ProductoCafeteria;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import PersonalUniversidad.PersonalUniversidad;
import SingletonProxyServidor.SingletonProxyServidor;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * Clase abstracta para adaptar el servidor
 * @author David Menoyo Ros
 */
public abstract class AdaptadorServidor {
    
    //Objeto adaptado
    SingletonProxyServidor singletonProxyServidor;
    
   
    public AdaptadorServidor() {
        this.singletonProxyServidor = SingletonProxyServidor.getInstancia();
    }
    
    
    /**
     * Método que obtendrá todos los datos de un tipo almacenados en el servidor.
     * Por ejemplo obtendrá todos los ProductoCafetería almacenados.
     * @return HashMap
     */
    public HashMap obtener_todo_dato(){
        //ArrayList listaDatos = new ArrayList<>();
        HashMap listaDatos = new HashMap();
        
        String nombreArchivo;
        File carpeta = obtenerRuta();
        File[] listOfFiles = carpeta.listFiles(); 
        
        try{
            int i = 0;
            while (i < listOfFiles.length) 
            {
                if (listOfFiles[i].isFile())
                {
                    nombreArchivo = listOfFiles[i].getName();//Me devuelve un String... recuerda que el nombre del archivo es su nif
                    String identificador = nombreArchivo.replace(singletonProxyServidor.getExtensionArchivo(), "");
                    Object objetoDeserializado = obtenerDeserializable(identificador);
                    if(objetoDeserializado instanceof PersonalUniversidad){
                        listaDatos.put(((PersonalUniversidad) objetoDeserializado).getDni(), objetoDeserializado);
                    }else if(objetoDeserializado instanceof iProductoBiblioteca){
                        listaDatos.put(((iProductoBiblioteca) objetoDeserializado).getIdeintificador(), objetoDeserializado);
                    }else if(objetoDeserializado instanceof ProductoCafeteria){
                        listaDatos.put(((ProductoCafeteria) objetoDeserializado).getIdentificador(), objetoDeserializado);
                    }else if(objetoDeserializado instanceof Biblioteca){
                        listaDatos.put(((Biblioteca) objetoDeserializado).getNombre(), objetoDeserializado);
                    }
                    //listaDatos.add(objetoDeserializado);
                }
                i++;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\nFue del dominio del array: " + e.toString());
        }catch(NumberFormatException e){
            System.out.println("\nError en el formato del numero: " + e.toString());           
        }catch(NullPointerException e){
            System.out.println("\nVariable no definida. No hay datos registrados: " + e.toString());
        }catch(ClassCastException e){
            System.out.println("\nError al realizar el casting o conversión: " + e.toString());            
        }catch(IOException | ClassNotFoundException e){           
            System.out.println("\nSe ha podrucido un error: " + e.toString());
        }finally{
            return listaDatos;
        }     
    }
    
    
    /**
     * Método abstracto definido por el Template Method.
     * Devuelve el File de la ruta concreta que se quiera utilizar
     * @return File
     */
    public abstract File obtenerRuta();
    
    /**
     * Método abstracto definido por el Template Method.
     * Devuelve el File de la ruta concreta que se quiera utilizar
     * @return Object objeto que se quiere obtener
     */
    public abstract Object obtenerDeserializable(String identificador) throws IOException,ClassNotFoundException;
    
}
