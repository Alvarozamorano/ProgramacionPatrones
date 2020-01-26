package PersonalUniversidad;

import java.io.Serializable;

/**
 * Clase que representa una dirección.
 * @author David Menoyo Ros
 */
public class Direccion implements Copiable, Serializable{
    
    private String calle;
    private String portal;
    private String puerta;

    /**
     * Constructor
     * @param calle
     * @param portal
     * @param puerta 
     */
    public Direccion(String calle, String portal, String puerta) {
        this.calle = calle;
        this.portal = portal;
        this.puerta = puerta;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Override
    public Object copia() {
        return new Direccion(calle, portal, puerta);
    }
    
}
