package FactProductosCafeteria;

import bibliotecacafeteria.Cafeteria;

/**
 * Clase Bebida
 * @author David Menoyo Ros
 */
public class Bebida extends ProductoCafeteria{

    public Bebida(String _nombre, float _precio, String _identificador, Cafeteria _cafeteria) {
        super(_nombre, _precio, _identificador,_cafeteria);
    }

    @Override
    public String toString() {
        return "Bebida{" + "_nombre=" + _nombre + ", _precio=" + _precio + ", _identificador=" + _identificador + '}';
    }
    
}
