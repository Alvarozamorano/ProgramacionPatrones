package StateComanda;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * Clase que representa el estado Pendiente de la Comanda
 * @author David Menoyo Ros
 */
public class EstadoComandaPendiente implements iEstadoComanda, Serializable{

    /**
     * Acción a ejecutar en este estado.
     * @param comanda 
     */
    @Override
    public void ejecutar(Comanda comanda) {
        //Añadimos la comanda a la persona
        comanda.getPersona().añadirComanda(comanda);
        System.out.println("Comanda pendiente");
        
        //Creamos el ticket 
        crearTicketComanda(comanda);
    }

    /**
     * Crea el ticket de comanda
     *
     * @param comanda
     */
    public void crearTicketComanda(Comanda comanda) {
        BufferedWriter bw;
        try {
            int dia = comanda.getFechaComanda().getDate();
            int mes = comanda.getFechaComanda().getMonth() + 1;
            int año = comanda.getFechaComanda().getYear() + 1900;
            int h = comanda.getFechaComanda().getHours();
            int min = comanda.getFechaComanda().getMinutes();
            int sec = comanda.getFechaComanda().getSeconds();
            String dniPersona = comanda.getPersona().getDni();
            String fecha = "-" + dia + "-" + mes + "-" + año;
            String hora = h + ":" + min + ":" + sec;
            //Creando un objeto File sobre el directorio que queremos explorar o crear si no existe
            File file = new File("./TicketsCafeteria/");
            if(!file.exists()){
                //Creando el directorio
                boolean bool = file.mkdir();
                if(bool){
                   System.out.println("Directorio creado correctamente");
                }else{
                   System.out.println("No se pudo crear el directorio");
                }
            }
            String nombre = "TicketsCafeteria/" + dniPersona + fecha + ".txt";
            bw = new BufferedWriter(new FileWriter(nombre));
            bw.write("\r\n");
            bw.write("Productos: ");
            bw.write("\n" + comanda.listadoProductos());
            bw.write("\r\n");
            bw.write("Dni Usuario: ");
            bw.write(comanda.getPersona().getDni());
            bw.write("\r\n");
            bw.write("Nombre Usuario: ");
            bw.write(comanda.getPersona().getNombre() + " " + comanda.getPersona().getApellidos());
            bw.write("\r\n");
            bw.write("Fecha Comanda: ");
            bw.write("" + comanda.getFechaComanda().toString());
            bw.write("\r\n");
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error al realizar txt comanda");
        }

    }
    
    /**
     * Método toString que devuelve una representación de este estado.
     * @return String
     */
    @Override
    public String toString() {
        return "Comanda pendiente";
    }
    
}

