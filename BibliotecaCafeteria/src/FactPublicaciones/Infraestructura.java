package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;

/**
 * Clase abstracta Infraestructura
 *
 * @author Álvaro Zamorano
 */
public abstract class Infraestructura implements iProductoBiblioteca {

    protected int _aforo;
    protected boolean _disponible;
    protected String _identificador;
    protected Biblioteca _biblioteca;

    /**
     * Constructor
     *
     * @param aforo
     * @param identificador
     * @param biblioteca
     */
    public Infraestructura(int aforo, String identificador, Biblioteca biblioteca) {
        _aforo = aforo;
        _disponible = true;
        _identificador = identificador;
        _biblioteca = biblioteca;
        _biblioteca.añadirProducto(this);
    }

    public int getAforo() {
        return _aforo;
    }

    public void setAforo(int aforo) {
        this._aforo = aforo;
    }

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
