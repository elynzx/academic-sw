/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.funcionalidad.catalogo.CategoriaConducta;

/**
 *
 * @author rpasc
 */
public class SeguimientoDao implements ISeguimiento {

    private Connection conn;

    public SeguimientoDao() {
        conn = Conexion.estableceConexion();
    }

    @Override
    public List<CategoriaConducta> ObtenerCategoriaConductas() {
        List<CategoriaConducta> listaCategorias = new ArrayList<>();

        String sql = "SELECT id_categoria, nombre FROM categoria_conducta";

        try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                CategoriaConducta categoria = new CategoriaConducta(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre")
                );
                listaCategorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de categorias: : " + e.getMessage());
        }
        return listaCategorias;

    }

    @Override
    public boolean guardarSeguimiento(int idEstudiante, int idCategoria, String descripcion, int frecuencia, String observaciones) {
        String sql = "INSERT INTO seguimiento_conductual (id_estudiante, fecha, id_categoria, descripcion_conducta, frecuencia, observaciones) "
                + "VALUES (?, NOW(), ?, ?, ?, ?)";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            pst.setInt(2, idCategoria);
            pst.setString(3, descripcion);
            pst.setInt(4, frecuencia);
            pst.setString(5, observaciones);

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar seguimiento: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Map<String, Object>> obtenerPromedioFrecuencia(int idEstudiante) {
        List<Map<String, Object>> listaPromedios = new ArrayList<>();
        String sql = "SELECT c.nombre AS categoria, AVG(s.frecuencia) AS promedio "
                + "FROM seguimiento_conductual s "
                + "JOIN categoria_conducta c ON s.id_categoria = c.id_categoria "
                + "WHERE s.id_estudiante = ? "
                + "GROUP BY c.nombre";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Map<String, Object> registro = new HashMap<>();
                registro.put("categoria", rs.getString("categoria"));
                registro.put("promedio", rs.getDouble("promedio"));
                listaPromedios.add(registro);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener promedio de frecuencia: " + e.getMessage());
        }

        return listaPromedios;
    }
}
