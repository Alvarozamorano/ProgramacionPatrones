package StateComanda;

import FactProductosCafeteria.FactoriaProductoCafeteria;
import FactProductosCafeteria.ProductoCafeteria;
import bibliotecacafeteria.Cafeteria;
import PersonalUniversidad.Direccion;
import PersonalUniversidad.PersonalUniversidad;
import SingletonProxyServidor.SingletonProxyServidor;
import SingletonProxyServidor.TipoArchivo;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase para comprobar el funcionamiento del Patrón State en las Comandas
 * @author David Menoyo Ros
 */
public class PruebaStateComanda {
        public static void main(String[] args) throws IOException, ClassNotFoundException{
        PersonalUniversidad personalUniversidad = new PersonalUniversidad("pepe", "ramirez", "34000000W", "yo@tumail.com", "1234", "112", new Direccion("C/Mayor", "11", "3"), null);
        FactoriaProductoCafeteria fp = new FactoriaProductoCafeteria();
        Cafeteria cafeteria = (Cafeteria) SingletonProxyServidor.getInstancia().cargar_archivo(TipoArchivo.CAFETERIA, "Politecnica");
        
        
        ArrayList<ProductoCafeteria> listaProductos = new ArrayList<>();
        ProductoCafeteria comida1 = fp.getProductoCafeteria(0,"macarrones",2.5f,"C1", cafeteria);
        ProductoCafeteria comida2 = fp.getProductoCafeteria(0,"pollo en salsa",3.5f,"C2", cafeteria);
        ProductoCafeteria postre1 = fp.getProductoCafeteria(0,"tarta de chocolate",1.5f,"P1", cafeteria);
        ProductoCafeteria bebida1 = fp.getProductoCafeteria(1,"cocacolo",2.0f,"B1", cafeteria);

        listaProductos.add(comida1);
        listaProductos.add(comida2);
        listaProductos.add(postre1);
        listaProductos.add(bebida1);

        Comanda comanda = new Comanda(personalUniversidad, listaProductos);
        comanda.solicitarComanda();
        comanda.prepararComanda();
        comanda.entregarComanda();
        
        System.out.println(comanda.toString());
    }
}
