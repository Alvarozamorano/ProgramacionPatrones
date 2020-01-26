package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.Date;

/**
 *
 * Clase libro
 *
 * @author Álvaro Zamorano
 */
public class Libro extends Publicacion {

    private String _editorial;
    private String _localidadPublicacion;
    private int _edicion;

    /**
     * Constructor
     * @param editorial
     * @param localidadPublicacion
     * @param edicion
     * @param identificador
     * @param ISBN
     * @param titulo
     * @param autor
     * @param fechaPublicacion
     * @param materia
     * @param biblioteca
     */
    public Libro(String editorial, String localidadPublicacion, int edicion,
            String identificador, String ISBN, String titulo, String autor,
            Date fechaPublicacion, String materia, Biblioteca biblioteca) {
        super(identificador, ISBN, titulo, autor, fechaPublicacion, materia, biblioteca);
        _editorial = editorial;
        _localidadPublicacion = localidadPublicacion;
        _edicion = edicion;
    }

    public String getEditorial() {
        return _editorial;
    }

    public String getLocalidadPublicacion() {
        return _localidadPublicacion;
    }

    public int getEdicion() {
        return _edicion;
    }

    /**
     *
     * @return Editorial (String)
     */
    @Override
    public Object getParametro1() {
        return getEditorial();
    }

    /**
     *
     * @return Localidad (String)
     */
    @Override
    public Object getParametro2() {
        return getLocalidadPublicacion();
    }

    /**
     *
     * @return Edicion (int)
     */
    @Override
    public Object getParametro3() {
        return getEdicion();
    }

    @Override
    public String toString() {
        return "Libro: " + " Id= " + _identificador + ", Editorial= " + _editorial
                + ", LocalidadPublicacion= " + _localidadPublicacion + ", Edicion= " + _edicion
                + ", ISBN= " + _ISBN + ", Titulo= " + _titulo + ", Autor= " + _autor
                + ", Materia= " + _materia + ", Fecha Publicacion= " + _fechaPublicacion
                + ", Disponible= " + _disponible + ".";
    }
}
