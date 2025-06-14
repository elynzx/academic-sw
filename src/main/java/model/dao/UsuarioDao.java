package model.dao;

import configuration.Conexion;
import configuration.UsuarioConectado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao implements IUsuarioDao {

    private Connection conn;

    public UsuarioDao() {
        conn = Conexion.estableceConexion();
    }

    @Override
    public UsuarioConectado validarLogin(String username, String password) {
        String sql = "SELECT u.id_usuario, u.username, u.rol, p.id_persona, p.nombres, p.apellidos, u.password "
                + "FROM usuario u "
                + "JOIN persona p ON u.id_persona = p.id_persona "
                + "WHERE u.username = ? AND u.estado = 'activo'";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String passwordIn = rs.getString("password");
                if (password.equals(passwordIn)) {
                    return new UsuarioConectado(
                            rs.getInt("id_usuario"),
                            rs.getString("username"),
                            rs.getString("rol"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getInt("id_persona")
                    );
                } else {

                    System.out.println("Contraseña incorrecta.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error en validarLogin: " + e.getMessage());
        }
        return null;
    }

}
