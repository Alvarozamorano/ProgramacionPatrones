package FactProductosCafeteria;

import bibliotecacafeteria.Cafeteria;

/**
 * Clase Postre
 * @author David Menoyo Ros
 */
public class Postre extends ProductoCafeteria{

    public Postre(String _nombre, float _precio, String _identificador, Cafeteria _cafeteria) {
        super(_nombre, _precio, _identificador,_cafeteria);
    }
    
    @Override
    public String toString() {
        return "Comida{" + "_nombre=" + _nombre + ", _precio=" + _precio + ", _identificador=" + _identificador + '}';
    }
}
