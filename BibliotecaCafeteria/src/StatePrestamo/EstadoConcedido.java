package StatePrestamo;

import FactPublicaciones.Libro;
import FactPublicaciones.Revista;
import FactPublicaciones.Sala;
import FactPublicaciones.iProductoBiblioteca;
import FactRol.Rol;
import FactRol.RolBibliotecario;
import FactRol.RolEstudiante;
import FactRol.RolProfesor;
import PersonalUniversidad.PersonalUniversidad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase que implementa las funciones a realizar cuando se concede un producto
 * de biblioteca a un Usuario
 *
 * @author Álvaro Zamorano
 */
public class EstadoConcedido implements iEstadoPrestamo {

    private boolean esProfesor = false;
    private boolean esBibliotecario = false;
    private boolean esEstudiante = false;
    private boolean esCamarero = false;

    //Dias de prestamo para cada usuario y producto
    private final int _diasPrestamoRevistaProfesor = 6;
    private final int _diasPrestamoLibroProfesor = 10;
    private final int _diasPrestamoProyectoProfesor = 12;
    private final int _diasPrestamoRevistaEstudiante = 3;
    private final int _diasPrestamoLibroEstudiante = 6;
    private final int _diasPrestamoProyectoEstudiante = 10;
    private final int _horasPrestamoSala = 2;
    private final int _diasPrestamoLibroCamareroBibliotecario = 5;
    private int _diasPrestamo;
    private int _horasPrestamo;

    @Override
    public void ejecutar(Prestamo prestamo) {
        getRolPersona(prestamo.getPersona());
        iProductoBiblioteca productoPrestamo = prestamo.getProductoBiblioteca();

        //Identificamos los días de prestamo segun el usuario y producto
        if (productoPrestamo instanceof Sala) {
            darDiasPrestamoSala(prestamo);
        } else if (productoPrestamo instanceof Libro) {
            darDiasPrestamoLibro(prestamo);
        } else if (productoPrestamo instanceof Revista) {
            darDiasPrestamoRevista(prestamo);
        } else {
            darDiasPrestamoProyecto(prestamo);
        }

        //Creamos la fecha de creación del préstamo
        Date fechaCreacionPrestamo = new Date();
        prestamo.setFechaCreacionPrestamo(fechaCreacionPrestamo);

        //Creamos la fecha de devolución del préstamo
        if (productoPrestamo instanceof Sala) {
            Date fechaDevolucion = sumarRestarHorasFecha(fechaCreacionPrestamo, _horasPrestamo);
            prestamo.setFechaDevolucionPrestamo(fechaDevolucion);
        } else {
            Date fechaDevolucion = sumarRestarDiasFecha(fechaCreacionPrestamo, _diasPrestamo);
            prestamo.setFechaDevolucionPrestamo(fechaDevolucion);
        }

        //Creamos el ticket de préstamo
        crearTicketPrestamo(prestamo);
    }

    /**
     * Se identifica el rol de la persona
     *
     * @param persona
     */
    private void getRolPersona(PersonalUniversidad persona) {
        ArrayList<Rol> rolesPersona = persona.getListaRoles();

        Rol rolPersona;

        for (int i = 0; i < rolesPersona.size(); i++) {
            rolPersona = rolesPersona.get(i);
            if (rolPersona instanceof RolBibliotecario) {
                esBibliotecario = true;
            } else if (rolPersona instanceof RolProfesor) {
                esProfesor = true;
            } else if (rolPersona instanceof RolEstudiante) {
                esEstudiante = true;
            } else {
                esCamarero = true;
            }
        }
    }

    /**
     * Establece los dias en la clase prestamo en caso de la sala
     *
     * @param prestamo
     */
    private void darDiasPrestamoSala(Prestamo prestamo) {
        prestamo.setHorasPermitidas(_horasPrestamoSala);
        _horasPrestamo = _horasPrestamoSala;
    }

    /**
     * Establece los dias en la clase prestamo en caso de un libro
     *
     * @param prestamo
     */
    private void darDiasPrestamoLibro(Prestamo prestamo) {
        if (esProfesor) {
            prestamo.setDiasPermitidos(_diasPrestamoLibroProfesor);
            _diasPrestamo = _diasPrestamoLibroProfesor;
        } else if (esEstudiante) {
            prestamo.setDiasPermitidos(_diasPrestamoLibroEstudiante);
            _diasPrestamo = _diasPrestamoLibroEstudiante;
        } else { //Es camarero o bibliotecario
            prestamo.setDiasPermitidos(_diasPrestamoLibroCamareroBibliotecario);
            _diasPrestamo = _diasPrestamoLibroCamareroBibliotecario;
        }
    }

    /**
     * Establece los dias en la clase prestamo en casa de una revista
     *
     * @param prestamo
     */
    private void darDiasPrestamoRevista(Prestamo prestamo) {
        if (esProfesor) {
            prestamo.setDiasPermitidos(_diasPrestamoRevistaProfesor);
            _diasPrestamo = _diasPrestamoRevistaProfesor;
        } else {//Es estudiante
            prestamo.setDiasPermitidos(_diasPrestamoRevistaEstudiante);
            _diasPrestamo = _diasPrestamoRevistaEstudiante;
        }
    }

    /**
     * Establece los dias en la clase prestamo en casa de un proyecto
     *
     * @param prestamo
     */
    private void darDiasPrestamoProyecto(Prestamo prestamo) {
        if (esProfesor) {
            prestamo.setDiasPermitidos(_diasPrestamoProyectoProfesor);
            _diasPrestamo = _diasPrestamoProyectoProfesor;
        } else { //Es estudiante
            prestamo.setDiasPermitidos(_diasPrestamoProyectoEstudiante);
            _diasPrestamo = _diasPrestamoProyectoEstudiante;
        }
    }

    /**
     * Devuelve una fecha sumada o restada tantos dias pasados como parámetro
     *
     * @param fecha Fecha a la que se quiere sumar o restar dias
     * @param dias Dias que se quieren restar (-) o sumar
     * @return Fecha sumada o restada tantos dias que se pasan por parametro
     */
    private Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    /**
     * Devuelve una fecha sumada o restada tantas horas pasadas como parámetro
     *
     * @param fecha Fecha a la que se quiere sumar o restar dias
     * @param horas horas que se quieren restar (-) o sumar
     * @return Fecha sumada o restada tantas horas que se pasan por parametro
     */
    private Date sumarRestarHorasFecha(Date fecha, int horas) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.HOUR_OF_DAY, horas);
        return calendar.getTime();
    }

    /**
     * Crea el ticket de préstamo
     *
     * @param prestamo
     */
    private void crearTicketPrestamo(Prestamo prestamo) {
        BufferedWriter bw;
        try {
            int dia = prestamo.getFechaCreacionPrestamo().getDay();
            int mes = prestamo.getFechaCreacionPrestamo().getMonth() + 1;
            int año = prestamo.getFechaCreacionPrestamo().getYear() + 1900;
            int h = prestamo.getFechaCreacionPrestamo().getHours();
            int min = prestamo.getFechaCreacionPrestamo().getMinutes();
            int sec = prestamo.getFechaCreacionPrestamo().getSeconds();
            String dniPersona = prestamo.getPersona().getDni();
            String fecha = "-" + dia + "-" + mes + "-" + año;
            String hora = h + ":" + min + ":" + sec;
            File file = new File("./TicketsBiblioteca/PrestamoConcedido/");
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
            String nombre = "./TicketsBiblioteca/PrestamoConcedido/" + dniPersona + fecha + ".txt";
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
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error al realizar txt prestamo concedido");
        }

    }
}
