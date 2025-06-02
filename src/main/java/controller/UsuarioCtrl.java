package controller;

import configuration.SesionUsuario;
import configuration.UsuarioConectado;
import dao.IUsuarioDao;
import dao.UsuarioDao;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.Administrador.InicioAdmin;
import view.Docente.DashboardDocente;
import view.Login;
import view.Secretaria.DashboardMatricula;

public class UsuarioCtrl {

    private IUsuarioDao usuarioDao;

    public UsuarioCtrl(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public boolean validarLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }

        UsuarioConectado usuario = usuarioDao.validarLogin(username, password);

        if (usuario != null) {
            SesionUsuario.setUsuarioActual(usuario);
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            return false;
        }
    }

    public void mostrarVista() {

        String rol = SesionUsuario.getUsuarioActual().getRol();

        InicioAdmin vAdmin = new InicioAdmin();
        DashboardDocente vDocente = new DashboardDocente();
        DashboardMatricula vMatricula = new DashboardMatricula();

        try {
            switch (rol) {
                case "administrador" -> {
                    vAdmin.setVisible(true);
                    vAdmin.setLocationRelativeTo(null);
                }

                case "docente" -> {
                    vDocente.setVisible(true);
                    vDocente.setLocationRelativeTo(null);
                }

                case "secretaria" -> {
                    vMatricula.setVisible(true);
                    vMatricula.setLocationRelativeTo(null);
                }

                default ->
                    JOptionPane.showMessageDialog(null, "Por favor contacte al administrador");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar vistar: " + e.getMessage());
        }
    }

    public void mostrarDatosUsuario(JLabel lbNomUserConectado) {
        lbNomUserConectado.setText(SesionUsuario.getUsuarioActual().getNombres() + " " + SesionUsuario.getUsuarioActual().getApellidos());
    }

}
