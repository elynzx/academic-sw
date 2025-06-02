/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

/**
 *
 * @author rpasc
 */
public class SesionUsuario {

    private static UsuarioConectado usuarioActual;

    public static void setUsuarioActual(UsuarioConectado usuarioActual) {
        SesionUsuario.usuarioActual = usuarioActual;
    }

    public static UsuarioConectado getUsuarioActual() {
        return usuarioActual;
    }

}

