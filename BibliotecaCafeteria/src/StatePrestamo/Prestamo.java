package StatePrestamo;

import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import PersonalUniversidad.PersonalUniversidad;
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

/**
 * Clase que representa un prestamo de un producto de la biblioteca
 *
 * @author Álvaro Zamorano
 */
public class Prestamo extends Observable implements Serializable {

    private PersonalUniversidad _persona;
    private iEstadoPrestamo _estadoPrestamo;
    private Date _fechaCreacionPrestamo;
    private Date _fechaDevolucionPrestamo;//fecha en la que tiene que devolver
    private Date _fechaDevolucionPersona;//fecha  en la que ha devuelto
    private iProductoBiblioteca _productoBiblioteca;
    private boolean _sancion;
    private int _diasPermitidos;
    private int _horasPermitidas; //Para infraestructuras
    private Biblioteca _biblioteca;

    public Prestamo(PersonalUniversidad persona, iProductoBiblioteca productoBiblioteca) {
        _persona = persona;
        _productoBiblioteca = productoBiblioteca;
        _sancion = false;
        iEstadoPrestamo estadoInicial = new EstadoPendiente();
        setEstadoPrestamo(estadoInicial);
        ejecutarEstado();
        this.addObserver(persona);
    }

    /**
     * Se establece la fecha en la que se ha dado el producto a la persona
     *
     * @param _fechaCreacionPrestamo
     */
    public void setFechaCreacionPrestamo(Date _fechaCreacionPrestamo) {
        this._fechaCreacionPrestamo = _fechaCreacionPrestamo;
    }

    /**
     * Se establece la fecha de devolución en la que la persona tiene que
     * devolverlo
     *
     * @param fechaDevolucionPrestamo
     */
    public void setFechaDevolucionPrestamo(Date fechaDevolucionPrestamo) {
        _fechaDevolucionPrestamo = fechaDevolucionPrestamo;
    }

    public void setSancion(boolean sancion) {
        _sancion = sancion;
    }

    public iEstadoPrestamo getEstadoPrestamo() {
        return _estadoPrestamo;
    }

    public void setEstadoPrestamo(iEstadoPrestamo _estadoPrestamo) {
        this._estadoPrestamo = _estadoPrestamo;
    }

    public PersonalUniversidad getPersona() {
        return _persona;
    }

    /**
     * Se obtiene la fecha en la que se ha prestado el producto
     *
     * @return
     */
    public Date getFechaCreacionPrestamo() {
        return _fechaCreacionPrestamo;
    }

    /**
     * Se obtiene la fecha en la que se se tiene que devolver el producto
     *
     * @return
     */
    public Date getFechaDevolucionPrestamo() {
        return _fechaDevolucionPrestamo;
    }

    public iProductoBiblioteca getProductoBiblioteca() {
        return _productoBiblioteca;
    }

    public boolean isSancion() {
        return _sancion;
    }

    public int getDiasPermitidos() {
        return _diasPermitidos;
    }

    public void setDiasPermitidos(int diasPermitidos) {
        this._diasPermitidos = diasPermitidos;
    }

    /**
     * Se obtiene la fecha en la que la persona ha devuelto el producto
     *
     * @return
     */
    public Date getFechaDevolucionPersona() {
        return _fechaDevolucionPersona;
    }

    /**
     * Se establece la fecha en la que la persona ha devuelto el producto
     *
     * @param _fechaDevolucionPersona
     */
    public void setFechaDevolucionPersona(Date _fechaDevolucionPersona) {
        this._fechaDevolucionPersona = _fechaDevolucionPersona;
    }

    public int getHorasPermitidas() {
        return _horasPermitidas;
    }

    public void setHorasPermitidas(int _horasPermitidas) {
        this._horasPermitidas = _horasPermitidas;
    }

    public Biblioteca getBiblioteca() {
        return _biblioteca;
    }

    public void setBiblioteca(Biblioteca _biblioteca) {
        this._biblioteca = _biblioteca;
    }

    public void setPersona(PersonalUniversidad _persona) {
        this._persona = _persona;
    }

    /**
     * Ejecuta el estado actual.
     */
    public void ejecutarEstado() {
        _estadoPrestamo.ejecutar(this);
    }

    /**
     * Simula el estado de conceder el prestamo. Esta ejecución debe ir
     * posteriormente al estado pendiente.
     */
    public void concederPrestamo() {
        iEstadoPrestamo estadoConcedido = new EstadoConcedido();
        setEstadoPrestamo(estadoConcedido);
        ejecutarEstado();
    }

    /**
     * Simula el estado de devolver el producto del prestamo. Esta ejecución
     * debe ir posteriormente al estado concedido.
     */
    public void devolverPrestamo() {
        iEstadoPrestamo estadoDevuelto = new EstadoDevuelto();
        setEstadoPrestamo(estadoDevuelto);
        ejecutarEstado();
        this.deleteObservers();
    }

    /**
     * Modifica sancion y notifica a la persona si tiene sanción y cuantos días
     * le quedan.
     */
    public void verMulta() {
        Date diaActual = new Date();
        if (diaActual.after(_fechaDevolucionPrestamo)) {
            _sancion = true;
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Prestamo{" + "_persona=" + _persona + ", _estadoPrestamo=" + _estadoPrestamo + ", _fechaCreacionPrestamo=" + _fechaCreacionPrestamo + ", _fechaDevolucionPrestamo=" + _fechaDevolucionPrestamo + ", _fechaDevolucionPersona=" + _fechaDevolucionPersona + ", _productoBiblioteca=" + _productoBiblioteca + ", _sancion=" + _sancion + ", _diasPermitidos=" + _diasPermitidos + '}';
    }

}
