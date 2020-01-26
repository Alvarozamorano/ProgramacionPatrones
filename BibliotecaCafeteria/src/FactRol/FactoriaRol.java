package FactRol;

/**
 * Clase factoría para la creación de roles
 * @author David Menoyo Ros
 */
public class FactoriaRol {
    private static final int RolProfesor = 0;
    private static final int RolEstudiante = 1;
    private static final int RolCamarero = 2;
    private static final int RolBibliotecario = 3;
    
    public Rol getRol(int tipo) {
        switch (tipo) {
            case RolProfesor:
                return new RolProfesor();
            case RolEstudiante:
                return new RolEstudiante();
            case RolCamarero:
                return new RolCamarero();
            case RolBibliotecario:
                return new RolBibliotecario();
            default:
                return null;
        }
    }
    
}
