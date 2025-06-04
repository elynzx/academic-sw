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
import java.util.List;
import model.catalogo.CategoriaConducta;

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

}
