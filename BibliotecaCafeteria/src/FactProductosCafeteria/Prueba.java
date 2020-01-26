package FactProductosCafeteria;

import BuilderMenu.DirectorBuilder;
import BuilderMenu.MenuBuilder;
import BuilderMenu.MenuLibreBuilder;
import bibliotecacafeteria.Cafeteria;
import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import java.io.IOException;

/**
 * Clase para probar el correcto funcionamiento de la factoria de productos
 * de la cafeteria
 * @author David Menoyo Ros
 */
public class Prueba {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
       Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
       
       
        ProductoCafeteria comida1, comida2, postre1,bebida1;
        comida1 = fp.getProductoCafeteria(0,"macarrones",2.5f,"C1", cafeteria);
        comida2 = fp.getProductoCafeteria(0,"pollo en salsa",3.5f,"C2", cafeteria);
        bebida1 = fp.getProductoCafeteria(1,"cocacolo",2.0f,"B1", cafeteria);
        postre1 = fp.getProductoCafeteria(3,"tarta de chocolate",1.5f,"P1", cafeteria);
        //Creacion del menú
        ProductoCafeteria menu1;
        menu1 = fp.getProductoCafeteria(2, "menu1", 10.0f, "M1", cafeteria);
        
        MenuBuilder menuBuilder = new MenuLibreBuilder();
        menuBuilder.crearNuevoMenu("menu1", 5.0f, "M1",cafeteria);
        DirectorBuilder directorBuilder = new DirectorBuilder();
        directorBuilder.setMenuBuilder(menuBuilder);
        
        directorBuilder.crearMenu(new Comida("lentejas",5.0f,"M1", cafeteria), new Comida("lentejas",5.0f,"M1", cafeteria), new Postre("helado",5.0f,"M1", cafeteria), new Bebida("lentejas",5.0f,"M1", cafeteria));
        Menu menu2 = directorBuilder.getMenu();
        
        System.out.println(menu2.toString());
        
    }
}
