package project.main;

import configuration.Conexion;
import view.Login;

public class Main {

    public static void main(String[] args) {

        Conexion objConexion = new Conexion();
        objConexion.estableceConexion();
 

        Login LoginView = new Login();
        LoginView.setVisible(true);
        LoginView.setLocationRelativeTo(null);

    }

}
