package BuilderMenu;

import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.FactoriaProductoCafeteria;
import FactProductosCafeteria.Menu;
import FactProductosCafeteria.Postre;
import bibliotecacafeteria.Cafeteria;
import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ClaseMenuBaratoBuilder
 * @author David Menoyo Ros
 */
public class MenuBaratoBuilder extends MenuBuilder{

    @Override
    public void ponerPrimerPlato(Comida comida) {
        try {
            FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
            Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
            
            ((Menu) this._menu).setPrimerPlato(fp.getProductoCafeteria(0,"gachas",1.0f,"M1",cafeteria));
        } catch (IOException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ponerSegundoPlato(Comida comida) {
        try {
            FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
            Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
            ((Menu) this._menu).setSegundoPlato(fp.getProductoCafeteria(0,"ensalada",1.0f,"M1",cafeteria));
        } catch (IOException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ponerPostre(Postre postre) {
        try {
            FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
            Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
            ((Menu) this._menu).setPostre(fp.getProductoCafeteria(3,"yogur",1.0f,"P1",cafeteria));
        } catch (IOException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ponerBebida(Bebida bebida) {
        try {
            FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
            Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
            ((Menu) this._menu).setBebida(fp.getProductoCafeteria(1,"agua",0.55f,"M1",cafeteria));
        } catch (IOException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuBaratoBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
