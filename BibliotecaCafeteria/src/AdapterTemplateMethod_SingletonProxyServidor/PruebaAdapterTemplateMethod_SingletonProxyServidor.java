package AdapterTemplateMethod_SingletonProxyServidor;

import FactPublicaciones.iProductoBiblioteca;
import java.util.HashMap;

/**
 * Clase para probar el correcto funcionamiento del AdapterTemplateMethod
 * del proxy del servidor.
 * @author David Menoyo Ros
 */
public class PruebaAdapterTemplateMethod_SingletonProxyServidor {

    public static void main(String[] args) {

        //Obtengo el adaptador concreto del PersonalUniversidad
        /*AdaptadorServidor adaptadorServidorPersonalUniversida = new AdaptadorServidorPersonalUniversidad();
        ArrayList listaPersonalUniversidad = adaptadorServidorPersonalUniversida.obtener_todo_dato();
        
        // Recorro la lista de PersonalUniversidad obtenida para ver que se ha
        // obtenido correctamente
        Agregado agregado = new AgregadoConcreto(listaPersonalUniversidad);
        // Crea el iterador.
        Iterador iteradorPersonalUniversidad = agregado.crearIterador();

        // Recorre la lista con el iterador.
        while (iteradorPersonalUniversidad.hayMas()) {
            PersonalUniversidad personalUniversidad = (PersonalUniversidad) iteradorPersonalUniversidad.elementoActual();
            System.out.println(personalUniversidad.toString());
            iteradorPersonalUniversidad.siguiente();
        }
        
        
        
        
        //Obtengo el adaptador concreto de los ProductoCafeteria
        AdaptadorServidor adaptadorServidorProductoCafeteria = new AdaptadorServidorProductoCafeteria();
        //ArrayList listaProductoCafeteria = adaptadorServidorProductoCafeteria.obtener_todo_dato();
        HashMap listaProducto = adaptadorServidorProductoCafeteria.obtener_todo_dato();
        
        // Recorro la lista de PersonalUniversidad obtenida para ver que se ha
        // obtenido correctamente
        Agregado agregadoProductoCafeteria = new AgregadoConcreto(listaProductoCafeteria);
        // Crea el iterador.
        Iterador iteradorProductoCafeteria = agregadoProductoCafeteria.crearIterador();

        // Recorre la lista con el iterador.
        while (iteradorProductoCafeteria.hayMas()) {
            ProductoCafeteria productoCafeteria = (ProductoCafeteria) iteradorProductoCafeteria.elementoActual();
            System.out.println(productoCafeteria.toString());
            iteradorProductoCafeteria.siguiente();
        }
        
        
         */
        //Obtengo el adaptador concreto de las Publicacion
        AdaptadorServidor adaptadorServidorPersonas= new AdaptadorServidorPersonalUniversidad();
        HashMap usuarios = adaptadorServidorPersonas.obtener_todo_dato();
        
        
        AdaptadorServidor adaptadorServidorPublicacion = new AdaptadorServidorProductoBiblioteca();
        HashMap listaPublicacion = adaptadorServidorPublicacion.obtener_todo_dato();
        String id = "R1";

        if (listaPublicacion.containsKey(id)) {
            iProductoBiblioteca producto2 = (iProductoBiblioteca) listaPublicacion.get(id);
            if (producto2.estaDisponible()) {
                System.out.println("Esta disponible");
            }
        }else{
            System.out.println("Hay error");
        }
            // Recorro la lista de PersonalUniversidad obtenida para ver que se ha
            // obtenido correctamente
            /*Agregado agregadoPublicacion = new AgregadoConcreto(listaPublicacion);
        // Crea el iterador.
        Iterador iteradorPublicacion = agregadoPublicacion.crearIterador();

        // Recorre la lista con el iterador.
        while (iteradorPublicacion.hayMas()) {
            Publicacion productoPublicacion = (Publicacion) iteradorPublicacion.elementoActual();
            System.out.println(productoPublicacion.toString());
            iteradorPublicacion.siguiente();
        }*/

        }
    }
