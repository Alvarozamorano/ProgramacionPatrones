package FactProductosCafeteria;

import bibliotecacafeteria.Cafeteria;

/**
 * Clase factoria para los productos de cafeteria
 * @author David Menoyo Ros
 */
public class FactoriaProductoCafeteria {
    private static final int Comida = 0;
    private static final int Bebida = 1;
    private static final int Menu = 2;
    private static final int Postre = 3;
    
    public ProductoCafeteria getProductoCafeteria(int tipo,String _nombre,float _precio,String _identificador, Cafeteria _cafeteria){
        switch (tipo) {
            case Comida:
                return new Comida(_nombre, _precio, _identificador, _cafeteria);
            case Bebida:
               return new Bebida(_nombre, _precio, _identificador, _cafeteria);
            case Menu:
                return new Menu(_nombre, _precio, _identificador, _cafeteria);
            case Postre:
                return new Postre(_nombre, _precio, _identificador, _cafeteria);
            default:
                return null;
        }
    }
}
