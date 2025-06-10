package model.entidades;
import java.sql.Date;

public class Secretaria extends Persona {
    private int idSecretaria;
    private Usuario usuario;

    public Secretaria(int idSecretaria, Usuario usuario, int id, String nombres, String apellidos, String dni, String celular, String correo, String direccion, Date fechaNacimiento, String genero) {
        super(id, nombres, apellidos, dni, celular, correo, direccion, fechaNacimiento, genero);
        this.idSecretaria = idSecretaria;
        this.usuario = usuario;
    }

    public int getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(int idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
