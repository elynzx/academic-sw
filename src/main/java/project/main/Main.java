package project.main;

import Configuration.Conexion;
import View.Docente.Seguimiento;

public class Main {

    public static void main(String[] args) {

        Conexion objConexion = new Conexion();
        objConexion.estableceConexion();
 

        Seguimiento seguimiento = new Seguimiento();
        seguimiento.setVisible(true);
        seguimiento.setLocationRelativeTo(null);

    }

}
