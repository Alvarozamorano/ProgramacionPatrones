package PersonalUniversidad;

import FactPublicaciones.Infraestructura;
import FactRol.FactoriaRol;
import FactRol.Rol;
import FactRol.RolBibliotecario;
import FactRol.RolCamarero;
import StatePrestamo.Prestamo;
import StateComanda.Comanda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Clase que representa a todo personal de la universidad.
 * La diferencia sustancial entre el personal radica en el rol o roles
 * que posean.
 * @author David Menoyo Ros
 */
public class PersonalUniversidad implements Copiable, Observer, Serializable {

    private String _nombre;
    private String _apellidos;
    private String _dni;
    private String _email;
    private String password;
    private String telefono;
    private Direccion _direccion;
    private ArrayList<Rol> _listaRoles;
    private ArrayList<Prestamo> _prestamos;
    private ArrayList<Comanda> _comandas;
    private Date _fechaFinMulta;

    /**
     *
     * @param _nombre
     * @param _apellidos
     * @param _dni
     * @param _email
     * @param password
     * @param telefono
     * @param _direccion
     * @param listaRoles
     */
    public PersonalUniversidad(String _nombre, String _apellidos, String _dni, String _email, String password, String telefono, Direccion _direccion, ArrayList<Rol> listaRoles) {
        this._nombre = _nombre;
        this._apellidos = _apellidos;
        this._dni = _dni;
        this._email = _email;
        this.password = password;
        this.telefono = telefono;
        this._direccion = _direccion;
        this._listaRoles = listaRoles;
        _fechaFinMulta = null;
        _prestamos = new ArrayList<>();
        _listaRoles = new ArrayList<>();
        _comandas = new ArrayList<>();
    }

    
    /**
     * Método copiar.
     * @return 
     */
    @Override
    public Object copia() {
        return new PersonalUniversidad(_nombre, _apellidos, _dni, _email, password, telefono, (Direccion) _direccion.copia(), new ArrayList<>());
    }


    /**
     * Devuelve una fecha sumada o restada tantos dias pasados como parámetro
     *
     * @param fecha Fecha a la que se quiere sumar o restar dias
     * @param dias Dias que se quieren restar (-) o sumar
     * @return Fecha sumada o restada tantos dias que se pasan por parametro
     */
    private Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    /**
     * Devuelve una fecha sumada o restada tantas horas pasadas como parámetro
     *
     * @param fecha Fecha a la que se quiere sumar o restar dias
     * @param horas horas que se quieren restar (-) o sumar
     * @return Fecha sumada o restada tantas horas que se pasan por parametro
     */
    private Date sumarRestarHorasFecha(Date fecha, int horas) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.HOUR_OF_DAY, horas);
        return calendar.getTime();
    }

    /**
     * Acción que ejecuta el Observer (esta clase)
     * @param obs
     * @param arg 
     */
    @Override
    public void update(Observable obs, Object arg) {

        if (obs instanceof Comanda) {
            System.out.println("¡Comanda recibida! Ya estoy comiendo. Ñam Ñam");
        } else if (obs instanceof Prestamo) {
            System.out.println("¡¡Update de Prestamo!!");
            Prestamo p = (Prestamo) obs;
            boolean hayMulta = p.isSancion();
            String res;

            if (hayMulta) {
                Date fechaActual = new Date();
                if (p.getProductoBiblioteca() instanceof Infraestructura) {
                    _fechaFinMulta = sumarRestarHorasFecha(fechaActual, p.getHorasPermitidas());
                } else {
                    _fechaFinMulta = sumarRestarDiasFecha(fechaActual, p.getDiasPermitidos());
                }
                res = "Prestamo de producto con id " + p.getProductoBiblioteca().getIdeintificador() + " no devuelto. Hay multa hasta el dia: " + _fechaFinMulta;
            } else {
                res = "Prestamo de producto con id " + p.getProductoBiblioteca().getIdeintificador() + " hasta dia de multa " + p.getFechaDevolucionPrestamo();
            }
            System.out.println(res);
        } else {
            System.out.println("Update sin firma?? jummm");
        }

    }
    
    
    //Gets y Sets
    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    public String getDni() {
        return _dni;
    }

    public void setDni(String _dni) {
        this._dni = _dni;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return _direccion;
    }

    public void setDireccion(Direccion _direccion) {
        this._direccion = _direccion;
    }

    public ArrayList<Rol> getListaRoles() {
        return _listaRoles;
    }

    public void setListaRoles(ArrayList<Rol> listaRoles) {
        this._listaRoles = listaRoles;
    }
    
    public RolBibliotecario getRolBibliotecario() {
        RolBibliotecario bibliotecario = null;
        for (int i = 0; i < _listaRoles.size(); i++) {
            if (_listaRoles.get(i) instanceof RolBibliotecario) {
                bibliotecario = (RolBibliotecario) _listaRoles.get(i);
            }
        }
        return bibliotecario;
    }
    
    public RolCamarero getRolCamarero() {
        FactoriaRol ft = new FactoriaRol();
        RolCamarero camarero = (RolCamarero) ft.getRol(2);
        for (int i = 0; i < _listaRoles.size(); i++) {
            if (_listaRoles.get(i) instanceof RolCamarero) {
                camarero = (RolCamarero) _listaRoles.get(i);
            }
        }
        return camarero;
    }
    
    public boolean esBibliotecario() {
        boolean esBibliotecario = false;
        for (int i = 0; i < _listaRoles.size(); i++) {
            if (_listaRoles.get(i) instanceof RolBibliotecario) {
                esBibliotecario = true;
            }
        }
        return esBibliotecario;
    }
    
    public boolean esCamarero() {
        boolean esCamarero = false;
        for (int i = 0; i < _listaRoles.size(); i++) {
            if (_listaRoles.get(i) instanceof RolCamarero) {
                esCamarero = true;
            }
        }
        return esCamarero;
    }
    
    public ArrayList<Prestamo> getPrestamos() {
        return _prestamos;
    }

    public void añadirPrestamo(Prestamo prestamo) {
        _prestamos.add(prestamo);
    }

    public void añadirRol(Rol rol) {
        _listaRoles.add(rol);
    }

    public ArrayList<Comanda> getComandas() {
        return _comandas;
    }

    public void setComandas(ArrayList<Comanda> _comandas) {
        this._comandas = _comandas;
    }

    public void añadirComanda(Comanda comanda) {
        this._comandas.add(comanda);
    }

    public Date getFechaFinMulta() {
        return _fechaFinMulta;
    }

    public void setFechaFinMulta(Date _fechaFinMulta) {
        this._fechaFinMulta = _fechaFinMulta;
    }

    /**
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "PersonalUniversidad{" + "_nombre=" + _nombre + ", _apellidos=" + _apellidos + ", _dni=" + _dni + ", _email=" + _email + ", password=" + password + ", telefono=" + telefono + ", _direccion=" + _direccion + ", _listaRoles=" + _listaRoles.toString() + '}';
    }

}
