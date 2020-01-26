/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactPublicaciones;

import bibliotecacafeteria.Biblioteca;

/**
 *
 * Clase Sala
 *
 * @author Álvaro Zamorano
 */
public class Sala extends Infraestructura {

    private int _capacidad;

    public Sala(int capacidad, int aforo, String identificador, Biblioteca biblioteca) {
        super(aforo, identificador, biblioteca);
        _capacidad = capacidad;
    }

    public int getCapacidad() {
        return _capacidad;
    }

    public void setCapacidad(int capacidad) {
        this._capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sala: " + " Id= " + _identificador + ", Capacidad= " + _capacidad
                + ", Identificador= " + _identificador + ", Aforo= " + _aforo
                + ", Disponible= " + _disponible + ".";
    }

}
