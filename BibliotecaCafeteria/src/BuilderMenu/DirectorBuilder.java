package BuilderMenu;

import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.Menu;
import FactProductosCafeteria.Postre;

/**
 * Clase director del builder
 * @author David Menoyo Ros
 */
public class DirectorBuilder {
    
    private MenuBuilder _menuBuilder;

    public void setMenuBuilder(MenuBuilder _menuBuilder) {
        this._menuBuilder = _menuBuilder;
    }
    
    public Menu getMenu(){
        return (Menu) this._menuBuilder.getMenu();
    }
    
    /**
     * Construye el producto Pizza paso a paso.
     * @param primerPlato
     * @param segundoPlato
     * @param postre
     * @param bebida
     */
    public void crearMenu(Comida primerPlato, Comida segundoPlato, Postre postre, Bebida bebida) {
        _menuBuilder.ponerPrimerPlato(primerPlato);
        _menuBuilder.ponerSegundoPlato(segundoPlato);
        _menuBuilder.ponerPostre(postre);
        _menuBuilder.ponerBebida(bebida);
    }
    
}
