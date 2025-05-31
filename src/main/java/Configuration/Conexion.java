package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conectar = null;

    String usuario = "root";
    String contrasena = "1234";
    String bd = "escuela_inclusiva";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la BD" + e.toString());
        }
        return conectar;
    }

    public void CerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se logró cerrar la conexion" + e.toString());
        }
    }

}
