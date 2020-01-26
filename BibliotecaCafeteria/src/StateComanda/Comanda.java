package StateComanda;

import FactProductosCafeteria.ProductoCafeteria;
import PersonalUniversidad.PersonalUniversidad;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**
 * Clase que representa la comanda que se realiza en una cafetería.
 *
 * @author David Menoyo Ros
 */
public class Comanda extends Observable implements Serializable {

    //Atributos
    private PersonalUniversidad persona;
    private iEstadoComanda estadoComanda;
    private Date fechaComanda;
    private ArrayList<ProductoCafeteria> listaProductoCafeteria;

    /**
     * Constructor
     * @param personalUniversidad
     * @param listaProductoCafeteria 
     */
    public Comanda(PersonalUniversidad personalUniversidad, ArrayList<ProductoCafeteria> listaProductoCafeteria) {
        this.persona = personalUniversidad;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        this.fechaComanda = date;
        this.listaProductoCafeteria = listaProductoCafeteria;
        //Iniciamos la solicitud de la comanda en su creación.
        iEstadoComanda estadoInicial = new EstadoComandaPendiente();
        setEstadoComanda(estadoInicial);
        ejecutarEstado();
        this.addObserver(persona);
    }

    /**
     * Ejecuta el estado actual.
     */
    public void ejecutarEstado() {
        estadoComanda.ejecutar(this);
    }

    /**
     * Cambia el estado de la Comanda por EstadoComandaPendiente, el cual
     * representa una comanda pendiente.
     */
    public void solicitarComanda() {
        estadoComanda = new EstadoComandaPendiente();
        estadoComanda.ejecutar(this);
    }

    /**
     * Cambia el estado de la Comanda por EstadoComandaEnProceso, el cual
     * representa una comanda cocinándose.
     */
    public void prepararComanda() {
        estadoComanda = new EstadoComandaEnProceso();
        estadoComanda.ejecutar(this);
    }

    /**
     * Cambia el estado de la Comanda por EstadoComandaFinalizado, el cual
     * representa una comanda cocinándose. Además, realiza la acción de
     * notificación para el patrón observer
     */
    public void entregarComanda() {
        estadoComanda = new EstadoComandaFinalizado();
        estadoComanda.ejecutar(this);
        setChanged();
        notifyObservers();
    }

    /**
     * Obtenemos una cadena que representa los productos contenidos en el
     * atributo listaProductoCafeteria de la Comanda.
     * @return 
     */
    public String listadoProductos() {
        StringBuilder lista = new StringBuilder();
        int i = 1;
        for (ProductoCafeteria oe : listaProductoCafeteria) {
            lista.append(i++).append(" - ");
            lista.append(oe.toString()).append("\n");
        }
        return lista.toString();
    }
    
    //Gets y Sets
    public PersonalUniversidad getPersona() {
        return persona;
    }

    public void setPersona(PersonalUniversidad persona) {
        this.persona = persona;
    }

    public iEstadoComanda getEstadoComanda() {
        return estadoComanda;
    }

    public void setEstadoComanda(iEstadoComanda estadoComanda) {
        this.estadoComanda = estadoComanda;
    }

    public Date getFechaComanda() {
        return fechaComanda;
    }

    public void setFechaComanda(Date fechaComanda) {
        this.fechaComanda = fechaComanda;
    }

    public ArrayList<ProductoCafeteria> getListaProductoCafeteria() {
        return listaProductoCafeteria;
    }

    public void setListaProductoCafeteria(ArrayList<ProductoCafeteria> listaProductoCafeteria) {
        this.listaProductoCafeteria = listaProductoCafeteria;
    }

    /**
     * Método toString que devuelve una cadena con la información más importante
     * de la comanda
     * @return String
     */
    @Override
    public String toString() {
        return "Comanda{" + "persona=" + persona.toString() + ", estadoComanda=" + estadoComanda.toString() + ", fechaComanda=" + fechaComanda + ", listaProductoCafeteria=" + listaProductoCafeteria + '}';
    }

}
