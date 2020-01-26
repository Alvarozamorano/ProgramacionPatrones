package FactProductosCafeteria;

import bibliotecacafeteria.Cafeteria;

/**
 * Clase Menu
 * @author David Menoyo Ros
 */
public class Menu extends ProductoCafeteria{

    private ProductoCafeteria _primerPlato;
    private ProductoCafeteria _segundoPlato;
    private ProductoCafeteria _postre;
    private ProductoCafeteria _bebida;
    
    public Menu(String _nombre, float _precio, String _identificador, Cafeteria _cafeteria) {
        super(_nombre, _precio, _identificador,_cafeteria);
    }
    
    //[TODO] Hacer el toString, pero el menú es un objeto más complejo por lo
    //que hasta que no esté acabado no haré el toString()

    public ProductoCafeteria getPrimerPlato() {
        return _primerPlato;
    }

    public void setPrimerPlato(ProductoCafeteria _primerPlato) {
        this._primerPlato = _primerPlato;
    }

    public ProductoCafeteria getSegundoPlato() {
        return _segundoPlato;
    }

    public void setSegundoPlato(ProductoCafeteria _segundoPlato) {
        this._segundoPlato = _segundoPlato;
    }

    public ProductoCafeteria getPostre() {
        return _postre;
    }

    public void setPostre(ProductoCafeteria _postre) {
        this._postre = _postre;
    }

    public ProductoCafeteria getBebida() {
        return _bebida;
    }

    public void setBebida(ProductoCafeteria _bebida) {
        this._bebida = _bebida;
    }

    @Override
    public String toString() {
        return "Menu{" + "_primerPlato=" + _primerPlato.toString() + ", _segundoPlato=" + _segundoPlato.toString() + ", _postre=" + _postre.toString() + ", _bebida=" + _bebida.toString() + '}';
    }
}
