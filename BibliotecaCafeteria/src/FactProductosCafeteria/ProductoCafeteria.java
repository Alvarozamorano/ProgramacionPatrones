package FactProductosCafeteria;

import bibliotecacafeteria.Cafeteria;
import java.io.Serializable;

/**
 * Clase abstracta ProductoCafeteria
 * @author David Menoyo Ros
 */
public abstract class ProductoCafeteria implements Serializable{
    protected String _nombre;
    protected float _precio;
    protected String _identificador;
    protected Cafeteria _cafeteria;


    public ProductoCafeteria(){
        
    }
    
    public ProductoCafeteria(String _nombre, float _precio, String _identificador, Cafeteria cafeteria) {
        this._nombre = _nombre;
        this._precio = _precio;
        this._identificador = _identificador;
        this._cafeteria = cafeteria;
        _cafeteria.añadirProducto(this);
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public float getPrecio() {
        return _precio;
    }

    public void setPrecio(float _precio) {
        this._precio = _precio;
    }

    public String getIdentificador() {
        return _identificador;
    }

    public void setIdentificador(String _identificador) {
        this._identificador = _identificador;
    }

    public Cafeteria getCafeteria() {
        return _cafeteria;
    }

    public void setCafeteria(Cafeteria _cafeteria) {
        this._cafeteria = _cafeteria;
    }
    
    


    @Override
    public abstract String toString();
    
}
