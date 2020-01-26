package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.Date;

/**
 *
 * Clase abstracta Publicación
 *
 */
public abstract class Publicacion implements iProductoBiblioteca {

    protected String _ISBN;
    protected String _titulo;
    protected String _autor;
    protected Date _fechaPublicacion;
    protected String _materia;
    protected boolean _disponible;
    protected String _identificador;
    protected Biblioteca _biblioteca;

    /**
     * Constructor vacío
     */
    public Publicacion() {
    }

    /**
     * Constructor principal
     *
     * @param identificador
     * @param ISBN
     * @param titulo
     * @param autores
     * @param fechaPublicacion
     * @param materia
     * @param biblioteca
     */
    public Publicacion(String identificador, String ISBN, String titulo,
            String autores, Date fechaPublicacion, String materia, Biblioteca biblioteca) {
        _ISBN = ISBN;
        _titulo = titulo;
        _autor = autores;
        _fechaPublicacion = fechaPublicacion;
        _materia = materia;
        _disponible = true;
        _identificador = identificador;
        _biblioteca = biblioteca;
        _biblioteca.añadirProducto(this);
    }

    public String getISBN() {
        return _ISBN;
    }

    public String getTitulo() {
        return _titulo;
    }

    public String getAutor() {
        return _autor;
    }

    public Date getFechaPublicacion() {
        return _fechaPublicacion;
    }

    public String getMateria() {
        return _materia;
    }

    /**
     * Devuelve la editorial en caso de ser Libro. Devuelve la periodicidad en
     * caso de ser Revista. Devuelve el tribunal en caso de ser Proyecto.
     */
    public abstract Object getParametro1();

    /**
     * Devuelve la localidad en caso de ser Libro. Devuelve el volumen en caso
     * de ser Revista. Devuelve la titulacion en caso de ser Proyecto.
     */
    public abstract Object getParametro2();

    /**
     * Devuelve la edicion en caso de ser Libro. Devuelve el numero en caso de
     * ser Revista. Devuelve la calificacion en caso de ser Proyecto.
     */
    public abstract Object getParametro3();

    @Override
    public boolean estaDisponible() {
        return _disponible;
    }

    @Override
    public void setEstaDisponible(boolean disponible) {
        _disponible = disponible;
    }

    @Override
    public String getIdeintificador() {
        return _identificador;
    }

    @Override
    public Biblioteca getBiblioteca() {
        return _biblioteca;
    }

}
