package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;
import java.io.Serializable;

/**
 *
 * Interfaz para los productos de biblioteca
 *
 * @author Álvaro Zamorano
 */
public interface iProductoBiblioteca extends Serializable {

    public boolean estaDisponible();

    public void setEstaDisponible(boolean disponible);

    public String getIdeintificador();

    public Biblioteca getBiblioteca();
}
