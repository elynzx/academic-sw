package project.main;

import configuration.Conexion;
import controller.UsuarioCtrl;
import dao.IUsuarioDao;
import dao.UsuarioDao;
import java.sql.SQLException;
import view.Login;

public class Main {

    public static void main(String[] args) {

        Conexion.estableceConexion();
        IUsuarioDao usuarioDao = new UsuarioDao();

        UsuarioCtrl usuarioCtrl = new UsuarioCtrl(usuarioDao);

        Login loginView = new Login(usuarioCtrl);
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Conexion.cerrarConexion();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }));
    }
}
