package bibliotecacafeteria;

/**
 * Clase para tratar errores
 */
public class UsuarioException extends Exception {

    public static final String NIF_INCORRECTO = "El NIF proporcionado no corresponde a ninguna persona.";

    public static final String CONTRASEÑA_INCORRECTA = "La contraseña no es correcta.";

    public static final String SIN_PERMISOS = "No dispone de permisos";

    public static final String ADMIN_INCORRECTO = "El NOMBRE DE USUARIO DEL ADMINISTRADOR ES INCORRECTO";
    
    public static final String ID_INCORRECTO = "El identificador no corresponde con ningún producto";
    
    public static final String PRODUCTO_NO_DISPONIBLE = "El producto no está disponible";

    public UsuarioException() {
        super("Se ha producido una excepción en la aplicación.");
    }

    public UsuarioException(String txt) {
        super(txt);
    }
}
