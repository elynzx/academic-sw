/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

/**
 *
 * @author rpasc
 */
public class UsuarioConectado {

    private int idUsuario;
    private String username;
    private String rol;
    private String nombres;
    private String apellidos;

    public UsuarioConectado(int idUsuario, String username, String rol, String nombres, String apellidos) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public String getRol() {
        return rol;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

}
