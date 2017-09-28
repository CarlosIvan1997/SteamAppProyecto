package poclin.carlos.steam_app.model;

/**
 * Created by CARLOSIVÁN on 27/09/2017.
 */

public class UserModel {

    public static final String TABLE_NAME = "usuario";
    public static final String NOMBRES_FIELD = "nombres";
    public static final String APELLIDOS_FIELD = "apellidos";
    public static final String CORREO_FIELD = "correo";
    public static final String USER_FIELD = "user";
    public static final String PASSWORD_FIELD = "password";

    private String nombres;
    private String apellidos;
    private String correo;
    private String user;
    private String password;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
