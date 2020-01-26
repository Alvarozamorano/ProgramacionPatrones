package StatePrestamo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Clase que implementa las funciones a realizar cuando se devuelve un producto
 * por parte de un usuario
 *
 * @author Álvaro Zamorano
 */
public class EstadoDevuelto implements iEstadoPrestamo {

    @Override
    public void ejecutar(Prestamo prestamo) {
        //Instanciamos la fecha de devolucion
        Date fechaDevolucionPersona = new Date();
        prestamo.setFechaDevolucionPersona(fechaDevolucionPersona);

        //Establecemos que el producto está disponible
        prestamo.getProductoBiblioteca().setEstaDisponible(true);

        //Obtenemos la fecha en la que tenía que haberse devuelto el producto
        Date fechaDevolucionPrestamo = prestamo.getFechaDevolucionPrestamo();

        //Hay sancion si el producto se ha devuelto más tarde que el obligado
        if (fechaDevolucionPersona.after(fechaDevolucionPrestamo)) {
            prestamo.setSancion(true);
        }

        //Creamos ticket
        crearTicketDevolucion(prestamo);
    }

    /**
     * Crea el ticket de devolución
     *
     * @param prestamo
     */
    public void crearTicketDevolucion(Prestamo prestamo) {
        BufferedWriter bw;
        try {
            int dia = prestamo.getFechaDevolucionPersona().getDay();
            int mes = prestamo.getFechaDevolucionPersona().getMonth() + 1;
            int año = prestamo.getFechaDevolucionPersona().getYear() + 1900;
            int h = prestamo.getFechaDevolucionPersona().getHours();
            int min = prestamo.getFechaDevolucionPersona().getMinutes();
            int sec = prestamo.getFechaDevolucionPersona().getSeconds();
            String dniPersona = prestamo.getPersona().getDni();
            String fecha = "-" + dia + "-" + mes + "-" + año;
            String hora = h + ":" + min + ":" + sec;
            //Creando un objeto File sobre el directorio que queremos explorar o crear si no existe
            File file = new File("./TicketsBiblioteca/PrestamoDevuelto/");
            if (!file.exists()) {
                //Creando el directorio
                File file1 = new File("./TicketsBiblioteca/");
                if (!file.exists()) {
                    file1.mkdir();
                }
                boolean bool = file.mkdir();
                if (bool) {
                    System.out.println("Directorio creado correctamente");
                } else {
                    System.out.println("No se pudo crear el directorio");
                }
            }
            String nombre = "./TicketsBiblioteca/PrestamoDevuelto/" + dniPersona + fecha + ".txt";
            bw = new BufferedWriter(new FileWriter(nombre));
            bw.write("\r\n");
            bw.write("Producto-> ");
            bw.write("" + prestamo.getProductoBiblioteca().toString());
            bw.write("\r\n");
            bw.write("Dni Usuario: ");
            bw.write(prestamo.getPersona().getDni());
            bw.write("\r\n");
            bw.write("Nombre Usuario: ");
            bw.write(prestamo.getPersona().getNombre() + " " + prestamo.getPersona().getApellidos());
            bw.write("\r\n");
            bw.write("Fecha Prestamo: ");
            bw.write("" + prestamo.getFechaCreacionPrestamo().toString());
            bw.write("\r\n");
            bw.write("Fecha devolucion: ");
            bw.write("" + prestamo.getFechaDevolucionPrestamo().toString());
            bw.write("\r\n");
            bw.write("Fecha devolucion del Usuario: ");
            bw.write("" + prestamo.getFechaDevolucionPersona().toString());
            bw.write("\r\n");
            String multa;
            bw.write("Multa: ");
            if (prestamo.isSancion()) {
                multa = "Si";
            } else {
                multa = "No";
            }
            bw.write("" + multa);
            bw.write("\r\n");
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error al realizar txt prestamo devuelto");
        }

    }
}
