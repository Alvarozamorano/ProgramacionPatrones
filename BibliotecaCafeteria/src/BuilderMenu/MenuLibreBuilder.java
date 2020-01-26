package BuilderMenu;

import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.Menu;
import FactProductosCafeteria.Postre;

/**
 * Clase MenuLibreBuilder
 * @author David Menoyo Ros
 */
public class MenuLibreBuilder extends MenuBuilder{

    @Override
    public void ponerPrimerPlato(Comida comida) {
        ((Menu) this._menu).setPrimerPlato(comida);
    }

    @Override
    public void ponerSegundoPlato(Comida comida) {
        ((Menu) this._menu).setSegundoPlato(comida);
    }

    @Override
    public void ponerPostre(Postre postre) {
        ((Menu) this._menu).setPostre(postre);
    }

    @Override
    public void ponerBebida(Bebida bebida) {
        ((Menu) this._menu).setBebida(bebida);
    }
    
}
