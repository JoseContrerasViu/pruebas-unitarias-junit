package Modelo;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private String email;
    private boolean autenticado = false;

    public Usuario(String nombreUsuario, String password, String email) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    public boolean registrar() {
        return true;
    }

    public boolean autenticar(String pass) {
        if (this.password.equals(pass)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }
}