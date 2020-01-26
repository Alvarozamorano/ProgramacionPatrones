package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.Date;

/**

 * Clase Revista

 * @author Álvaro Zamorano
 */
public class Revista extends Publicacion {

    private String _periodicidad;
    private int _volumen;
    private int _numero;

    public Revista(String periodicidad, int volumen, int numero,
            String identificador, String ISBN, String titulo, String autor,
            Date fechaPublicacion, String materia, Biblioteca biblioteca) {
        super(identificador, ISBN, titulo, autor, fechaPublicacion, materia, biblioteca);
        this._periodicidad = periodicidad;
        this._volumen = volumen;
        this._numero = numero;
    }

    public String getPeriodicidad() {
        return _periodicidad;
    }

    public int getVolumen() {
        return _volumen;
    }

    public int getNumero() {
        return _numero;
    }

    /**
     *
     * @return Periodicidad (Srting)
     */
    @Override
    public Object getParametro1() {
        return getPeriodicidad();
    }

    /**
     *
     * @return Volumen (int)
     */
    @Override
    public Object getParametro2() {
        return getVolumen();
    }

    /**
     *
     * @return Numero (int)
     */
    @Override
    public Object getParametro3() {
        return getNumero();
    }

    @Override
    public String toString() {
        return "Revista: " + " Id= " + _identificador + ", Periodicidad= " + _periodicidad
                + ", Volumen= " + _volumen + ", Numero= " + _numero
                + ", ISBN= " + _ISBN + ", Titulo= " + _titulo + ", Autor= " + _autor
                + ", Materia= " + _materia + ", Fecha Publicacion= " + _fechaPublicacion
                + ", Disponible= " + _disponible + ".";
    }

}
