package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase factoría de publicaciones
 * @author Álvaro Zamorano
 */
public class FactoriaPublicaciones {
    private static final int Libro = 0;
    private static final int Revista = 1;
    private static final int Proyecto = 2;

    /**
     * Crea una publicación con los argumentos pasados por parámetro
     * @param tipo 0(Libro), 1(Revista), 2(Proyecto)
     * @param param1 editorial(String) en caso de ser Libro,
     * la periodicidad(String) en caso de ser Revista,
     * el tribunal(ArrayList<String>) en caso de ser Proyecto.
     * @param param2 localidad(String) en caso de ser Libro,
     * el volumen(int) en caso de ser Revista,
     * la titulacion(String) en caso de ser Proyecto.
     * @param param3 edicion(int) en caso de ser Libro,
     * el numero(int) en caso de ser Revista,
     * la calificacion(double) en caso de ser Proyecto.
     * @param identificador
     * @param ISBN 
     * @param titulo 
     * @param autor 
     * @param fechaPublicacion
     * @param materia
     * @param biblioteca
     * @return Publicacion
     */
    public Publicacion getPublicacion(int tipo,Object param1,Object param2,Object param3,
            String identificador,String ISBN, String titulo, String autor, 
            Date fechaPublicacion, String materia,Biblioteca biblioteca) {
        switch (tipo) {
            case Libro:
                return new Libro((String)param1,(String)param2,(int)param3,
                        identificador,ISBN,titulo,autor,fechaPublicacion,materia,biblioteca);
            case Revista:
                return new Revista((String)param1,(int)param2,(int)param3,
                        identificador,ISBN,titulo,autor,fechaPublicacion,materia,biblioteca);
            case Proyecto:
                return new Proyecto((ArrayList<String>)param1,(String)param2,
                        (double)param3,identificador,ISBN,titulo,autor,
                        fechaPublicacion,materia,biblioteca);
            default:
                return null;
        }
    }
}
