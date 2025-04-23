package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.facade.model;

public class UsuarioFacade {

    public boolean login(String usuario,String Correo, String clave){
        boolean claveSegura=comprobarClave(clave);
        if(!usuario.isBlank() || !Correo.isBlank() || !clave.isBlank() && claveSegura){
            return false;
        }
        return false;
    }

    private boolean comprobarClave(String clave) {
        if (clave.length()>7 && clave.matches(".*\\d.*")){
            return true;
        }

        return false;
    }
}
