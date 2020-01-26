package BuilderMenu;

import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.FactoriaProductoCafeteria;
import FactProductosCafeteria.Postre;
import FactProductosCafeteria.ProductoCafeteria;
import bibliotecacafeteria.Cafeteria;

/**
 * Clase abstracta MenuBuilder
 * @author David Menoyo Ros
 */
public abstract class MenuBuilder {
    protected ProductoCafeteria _menu;

    public ProductoCafeteria getMenu() {
        return _menu;
    }
    
    public void crearNuevoMenu(String _nombre,float _precio,String _identificador,Cafeteria _cafeteria){
        FactoriaProductoCafeteria fpc = new FactoriaProductoCafeteria();
        _menu = fpc.getProductoCafeteria(2,_nombre, _precio, _identificador, _cafeteria);
    }
    
    
    public abstract void ponerPrimerPlato(Comida comida);
    
    public abstract void ponerSegundoPlato(Comida comida);
    
    public abstract void ponerPostre(Postre postre);
    
    public abstract void ponerBebida(Bebida postre);
    
}
