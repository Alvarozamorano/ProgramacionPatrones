package SingletonProxyServidor;

import BuilderMenu.DirectorBuilder;
import BuilderMenu.MenuBaratoBuilder;
import BuilderMenu.MenuBuilder;
import BuilderMenu.MenuCaroBuilder;
import BuilderMenu.MenuLibreBuilder;
import FactProductosCafeteria.Bebida;
import FactProductosCafeteria.Comida;
import FactProductosCafeteria.FactoriaProductoCafeteria;
import FactProductosCafeteria.Menu;
import FactProductosCafeteria.Postre;
import FactProductosCafeteria.ProductoCafeteria;
import FactPublicaciones.FactoriaPublicaciones;
import FactPublicaciones.Sala;
import FactPublicaciones.iProductoBiblioteca;
import bibliotecacafeteria.Biblioteca;
import bibliotecacafeteria.Cafeteria;
import FactRol.RolBibliotecario;
import FactRol.RolCamarero;
import FactRol.RolEstudiante;
import PersonalUniversidad.Direccion;
import PersonalUniversidad.PersonalUniversidad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase para probar el funcionamiento del servidor y su patrón proxy. Además,
 * realiza la creación inicial de toda la base de datos necesaria para ejecutar
 * la aplicación correctamente.
 * @author David Menoyo Ros
 */
public class PruebaSingletonProxyServer {

    public static void main(String[] args) throws ClassNotFoundException {

        //Servidor
        SingletonProxyServidor singletonProxyServidor = SingletonProxyServidor.getInstancia();
        
        
        //Biblioteca
        Biblioteca b = new Biblioteca("Politecnica");
        //Cafeteria
        Cafeteria c = new Cafeteria("Politecnica");
        
        //Persona1 prototipo
        PersonalUniversidad pu1 = new PersonalUniversidad("Pepe", "Ramirez", "3", "yo@tumail.com", "1234", "970000000", new Direccion("C/Mayor", "11", "3"), null);
        //Persona2 estudiante
        PersonalUniversidad pu2 = (PersonalUniversidad) pu1.copia();
        pu2.setNombre("María");
        pu2.setApellidos("García");
        pu2.setDni("3");
        pu2.setEmail("maria@jmail.es");
        pu2.setPassword("1234");
        pu2.setTelefono("12345567");
        pu2.añadirRol(new RolEstudiante());
        //Persona3 bibliotecario
        PersonalUniversidad pu3 = new PersonalUniversidad("Alvaro", "Zamorano", "1", "yo@tumail.com", "1234", "112", new Direccion("C/Mayor", "11", "3"), null);
        RolBibliotecario bibliotecario = new RolBibliotecario();
        pu3.añadirRol(bibliotecario);
        pu3.getRolBibliotecario().setBiblioteca(b.getNombre());
        //Persona4 camarero
        PersonalUniversidad pu4 = (PersonalUniversidad) pu3.copia();
        pu4.setDni("2");
        pu4.setNombre("Antonio");
        pu4.setApellidos("Fernández");
        pu4.añadirRol(new RolCamarero());
        pu4.getRolCamarero().setNombre_cafeteria(c.getNombre());
        
        
        //Guardar Cafeteria y Biblioteca. Tambien se guardará al final de este
        //script ya que probablemente se produzcan actualizaciones de dichos
        //objetos.
        try {
            singletonProxyServidor.guardar_archivo(b);
            singletonProxyServidor.guardar_archivo(c);
        } catch (IOException ex) {
            Logger.getLogger(PruebaSingletonProxyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Probando PersonalUniversidad
        try {
            //singletonProxyServidor.guardar_archivo(pu1);
            singletonProxyServidor.guardar_archivo(pu2);
            singletonProxyServidor.guardar_archivo(pu3);
            singletonProxyServidor.guardar_archivo(pu4);
            PersonalUniversidad personalUniversitadoDeserializado1 = (PersonalUniversidad) singletonProxyServidor.cargar_archivo(TipoArchivo.PERSONAL_UNIVERSIDAD, pu1.getDni());
            PersonalUniversidad personalUniversitadoDeserializado2 = (PersonalUniversidad) singletonProxyServidor.cargar_archivo(TipoArchivo.PERSONAL_UNIVERSIDAD, pu2.getDni());

            if (personalUniversitadoDeserializado1.getEmail().equals(pu1.getEmail())) {
                System.out.println("Iguales");
            } else {
                System.out.println("Diferentes");
            }
            if (personalUniversitadoDeserializado2.getEmail().equals(pu2.getEmail())) {
                System.out.println("Iguales");
                //singletonProxyServidor.eliminar_archivo(pu2);
            } else {
                System.out.println("Diferentes");
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error en PruebaSingletonProxyServer");
        }

        
        
        // Probando ProductoCafeteria
        try {
            FactoriaProductoCafeteria ft_producto_cafeteria = new FactoriaProductoCafeteria();
            //Comida
            ProductoCafeteria comida1 = ft_producto_cafeteria.getProductoCafeteria(0, "macarrones", 1.5f, "macarrones1",c);
            ProductoCafeteria comida2 = ft_producto_cafeteria.getProductoCafeteria(0, "lentejas", 2.75f, "lentejas1",c);
            ProductoCafeteria comida3 = ft_producto_cafeteria.getProductoCafeteria(0, "cocido", 1.5f, "cocido1",c);
            ProductoCafeteria comida4 = ft_producto_cafeteria.getProductoCafeteria(0, "ternera", 3.5f, "ternera1",c);
            ProductoCafeteria comida5 = ft_producto_cafeteria.getProductoCafeteria(0, "ensalada", 3.5f, "ensalada1",c);
            //Bebida
            ProductoCafeteria bebida1 = ft_producto_cafeteria.getProductoCafeteria(1, "cocacolo", 1.2f, "cocacola1",c);
            ProductoCafeteria bebida2 = ft_producto_cafeteria.getProductoCafeteria(1, "fanta", 1.0f, "fanta1",c);
            ProductoCafeteria bebida3 = ft_producto_cafeteria.getProductoCafeteria(1, "trina", 1.0f, "trina1",c);
            //Postre
            ProductoCafeteria postre1 = ft_producto_cafeteria.getProductoCafeteria(3,"tarta de chocolate",2.0f,"tarta de chocolate1",c);
            ProductoCafeteria postre2 = ft_producto_cafeteria.getProductoCafeteria(3,"helado",0.5f,"helado1",c);
            ProductoCafeteria postre3 = ft_producto_cafeteria.getProductoCafeteria(3,"café",1.25f,"café1",c);
            //Menu
            MenuBuilder menuLibreBuilder = new MenuLibreBuilder();
            menuLibreBuilder.crearNuevoMenu("menu1", 5.0f, "menu1",c);
            DirectorBuilder directorBuilder = new DirectorBuilder();
            directorBuilder.setMenuBuilder(menuLibreBuilder);
            directorBuilder.crearMenu((Comida)comida2, (Comida)comida5, (Postre)postre1, (Bebida)bebida3);
            Menu menu1 = directorBuilder.getMenu();
            
            MenuBuilder menuBaratoBuilder = new MenuBaratoBuilder();
            menuBaratoBuilder.crearNuevoMenu("menuBarato", 5.0f, "menuBarato1", c);
            DirectorBuilder directorBaratoBuilder = new DirectorBuilder();
            directorBaratoBuilder.setMenuBuilder(menuBaratoBuilder);
            directorBaratoBuilder.crearMenu(null, null, null, null);
            Menu menu2 = directorBaratoBuilder.getMenu();
            
            
            MenuBuilder menuCaroBuilder = new MenuCaroBuilder();
            menuCaroBuilder.crearNuevoMenu("menuCaro", 5.0f, "menuCaro1", c);
            DirectorBuilder directorCaroBuilder = new DirectorBuilder();
            directorCaroBuilder.setMenuBuilder(menuCaroBuilder);
            directorCaroBuilder.crearMenu(null, null, null, null);
            Menu menu3 = directorCaroBuilder.getMenu();
                    
            singletonProxyServidor.guardar_archivo(comida1);
            singletonProxyServidor.guardar_archivo(comida2);
            singletonProxyServidor.guardar_archivo(comida3);
            singletonProxyServidor.guardar_archivo(comida4);
            singletonProxyServidor.guardar_archivo(comida5);
            singletonProxyServidor.guardar_archivo(bebida1);
            singletonProxyServidor.guardar_archivo(bebida2);
            singletonProxyServidor.guardar_archivo(bebida3);
            singletonProxyServidor.guardar_archivo(postre1);
            singletonProxyServidor.guardar_archivo(postre2);
            singletonProxyServidor.guardar_archivo(postre3);
            singletonProxyServidor.guardar_archivo(menu1);
            singletonProxyServidor.guardar_archivo(menu2);
            singletonProxyServidor.guardar_archivo(menu3);

        } catch (IOException e) {
            System.out.println("Error en PruebaSingletonProxyServer");
        }

        
        
        //Probando Publicacion
        try {
            ArrayList<String> autores = new ArrayList<String>();
            autores.add("autor1");
            Date d = new Date();

            FactoriaPublicaciones fp = new FactoriaPublicaciones();
            iProductoBiblioteca libro1 = fp.getPublicacion(0, "libro1", "ed", 1, "L1", "ISBN", "titulo", "autoresa", d, "materia", b);
            iProductoBiblioteca revista1 = fp.getPublicacion(1, "revista1", 2, 3, "R1", "ISBN", "titulo", "autoresb", d, "materia", b);
            iProductoBiblioteca proyecto1 = fp.getPublicacion(2, autores, "proyecto1", 3.5, "P1", "ISBN", "titulo", "autoresc", d, "materia", b);
            iProductoBiblioteca sala1 = new Sala(2, 3, "S1", b);

            singletonProxyServidor.guardar_archivo(libro1);
            singletonProxyServidor.guardar_archivo(revista1);
            singletonProxyServidor.guardar_archivo(proyecto1);
            singletonProxyServidor.guardar_archivo(sala1);  
        } catch (IOException ex) {
            Logger.getLogger(PruebaSingletonProxyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Guardar Cafeteria y Biblioteca
        try {
            singletonProxyServidor.guardar_archivo(b);
            singletonProxyServidor.guardar_archivo(c);
            singletonProxyServidor.guardar_archivo(pu4);
        } catch (IOException ex) {
            Logger.getLogger(PruebaSingletonProxyServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
