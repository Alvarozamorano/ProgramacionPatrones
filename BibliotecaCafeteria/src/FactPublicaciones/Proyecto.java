package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * Clase Proyecto
 *
 * @author Álvaro Zamorano
 */
public class Proyecto extends Publicacion {

    private ArrayList<String> _tribunal;
    private String _titulacion;
    private double _calificacion;

    /**
     * Constructor
     *
     * @param tribunal
     * @param titulacion
     * @param calificacion
     * @param identificador
     * @param ISBN
     * @param titulo
     * @param autores
     * @param fechaPublicacion
     * @param materia
     * @param biblioteca
     */
    public Proyecto(ArrayList<String> tribunal, String titulacion, double calificacion,
            String identificador, String ISBN, String titulo, String autores,
            Date fechaPublicacion, String materia, Biblioteca biblioteca) {
        super(identificador, ISBN, titulo, autores, fechaPublicacion, materia, biblioteca);
        _tribunal = tribunal;
        _titulacion = titulacion;
        _calificacion = calificacion;
    }

    public ArrayList<String> getTribunal() {
        return _tribunal;
    }

    public String getTitulacion() {
        return _titulacion;
    }

    public double getCalificacion() {
        return _calificacion;
    }

    /**
     *
     * @return Tribunal (ArrayList<String>)
     */
    @Override
    public Object getParametro1() {
        return getTribunal();
    }

    /**
     *
     * @return Titulacion (String)
     */
    @Override
    public Object getParametro2() {
        return getTitulacion();
    }

    /**
     *
     * @return Calificacion (double)
     */
    @Override
    public Object getParametro3() {
        return getCalificacion();
    }

    @Override
    public String toString() {
        return "Proyecto: " + " Id= " + _identificador + ", Tribunal= " + _tribunal
                + ", Titulacion= " + _titulacion + ", Calificacion= " + _calificacion
                + ", ISBN= " + _ISBN + ", Titulo= " + _titulo + ", Autor= " + _autor
                + ", Materia= " + _materia + ", Fecha Publicacion= " + _fechaPublicacion
                + ", Disponible= " + _disponible + ".";
    }

}
