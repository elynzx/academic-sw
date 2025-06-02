package controller;

import configuration.SesionUsuario;
import configuration.UsuarioConectado;
import dao.DocenteDao;
import dao.IDocenteDao;
import dao.IUsuarioDao;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.Administrador.InicioAdmin;
import view.Docente.DashboardDocente;
import view.Secretaria.DashboardMatricula;

public class UsuarioCtrl {

    private IDocenteDao docenteDao;
    private IUsuarioDao usuarioDao;

    public UsuarioCtrl(IUsuarioDao usuarioDao, IDocenteDao docenteDao) {
        this.usuarioDao = usuarioDao;
        this.docenteDao = docenteDao;
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
        int idPersona = SesionUsuario.getUsuarioActual().getIdPersona();
        int idDocente = docenteDao.obtenerIdDocenteporPersona(idPersona);

        try {
            switch (rol) {
                case "administrador" -> {
                    InicioAdmin vAdmin = new InicioAdmin();
                    vAdmin.setVisible(true);
                    vAdmin.setLocationRelativeTo(null);
                }

                case "docente" -> {
                    if (idDocente != -1) {
                        DashboardDocente vDocente = new DashboardDocente(idDocente, docenteDao);
                        vDocente.setVisible(true);
                        vDocente.setLocationRelativeTo(null);

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró información del docente");
                    }
                }

                case "secretaria" -> {
                    DashboardMatricula vMatricula = new DashboardMatricula();
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
