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
import model.funcionalidad.catalogo.Antecedente;
import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;
import model.funcionalidad.ConductaProblematica;
import model.funcionalidad.FichaAbc;

/**
 *
 * @author rpasc
 */
public class RegistroIncidenteDao implements IRegistroIncidente {

    private Connection conn;

    public RegistroIncidenteDao() {
        conn = Conexion.estableceConexion();
    }

    @Override
    public List<TipoConducta> obtenerTipoConductas() {
        List<TipoConducta> listaTipoConductas = new ArrayList<>();

        String sql = "SELECT id_tipo_conducta, nombre FROM tipo_conducta";

        try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                TipoConducta tipoConducta = new TipoConducta(
                        rs.getInt("id_tipo_conducta"),
                        rs.getString("nombre")
                );
                listaTipoConductas.add(tipoConducta);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener tipos de conducta: : " + e.getMessage());
        }
        return listaTipoConductas;
    }

    @Override
    public List<FuncionComportamiento> obtenerFuncionComportamientos() {
        List<FuncionComportamiento> listaFuncionComportamientos = new ArrayList<>();

        String sql = "SELECT id_funcion, nombre FROM funcion_comportamiento";

        try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                FuncionComportamiento funcionComportamiento = new FuncionComportamiento(
                        rs.getInt("id_funcion"),
                        rs.getString("nombre")
                );
                listaFuncionComportamientos.add(funcionComportamiento);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de categorias: : " + e.getMessage());
        }
        return listaFuncionComportamientos;
    }

    @Override
    public List<Antecedente> obtenerAntecedentes() {
        List<Antecedente> listaAntecedentes = new ArrayList<>();

        String sql = "SELECT id_antecedente, descripcion FROM antecedente";

        try (PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Antecedente antecedente = new Antecedente(
                        rs.getInt("id_antecedente"),
                        rs.getString("descripcion")
                );
                listaAntecedentes.add(antecedente);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de categorias: : " + e.getMessage());
        }
        return listaAntecedentes;
    }

    @Override
    public boolean guardarConductaProblematica(int idEstudiante, int idConducta, int idFuncionComportamiento, int gravedad, String descripcion) {

        String sql = "INSERT INTO conducta_problematica (id_estudiante, fecha, id_tipo_conducta, id_funcion_comportamiento, descripcion, gravedad) VALUES (?, NOW(), ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            pst.setInt(2, idConducta);
            pst.setInt(3, idFuncionComportamiento);
            pst.setString(4, descripcion);
            pst.setInt(5, gravedad);

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar conducta problemática:  " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean guardarFichaAbc(int idEstudiante, int idAntecedente, String comportamiento, String consecuencia, int gravedad) {

        String sql = "INSERT INTO ficha_abc (id_estudiante, fecha, id_antecedente, comportamiento, consecuencia, gravedad) VALUES (?, NOW(), ?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            pst.setInt(2, idAntecedente);
            pst.setString(3, comportamiento);
            pst.setString(4, consecuencia);
            pst.setInt(5, gravedad);

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar Ficha ABC:  " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<ConductaProblematica> obtenerConductasPorEstudiante(int idEstudiante) {
        List<ConductaProblematica> listaConductas = new ArrayList<>();
        String sql = "SELECT c.id_conducta, c.fecha, t.nombre AS tipo_conducta, c.gravedad, c.descripcion "
                + "FROM conducta_problematica c "
                + "JOIN tipo_conducta t ON c.id_tipo_conducta = t.id_tipo_conducta "
                + "WHERE c.id_estudiante = ? "
                + "ORDER BY c.fecha DESC";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaConductas.add(new ConductaProblematica(
                        rs.getInt("id_conducta"),
                        rs.getDate("fecha"),
                        new TipoConducta(rs.getString("tipo_conducta")),
                        rs.getString("descripcion"),
                        rs.getInt("gravedad")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener conductas del estudiante: " + e.getMessage());
        }

        return listaConductas;
    }

    @Override
    public List<FichaAbc> obtenerFichasPorEstudiante(int idEstudiante) {
        List<FichaAbc> listaFichas = new ArrayList<>();
        String sql = "SELECT f.fecha, a.descripcion AS antecedente, f.comportamiento, f.gravedad "
                + "FROM ficha_abc f "
                + "JOIN antecedente a ON f.id_antecedente = a.id_antecedente "
                + "WHERE f.id_estudiante = ? "
                + "ORDER BY f.fecha DESC";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                listaFichas.add(new FichaAbc(
                        rs.getDate("fecha"),
                        new Antecedente(rs.getString("antecedente")), // ✅ Se usa `descripcion`
                        rs.getString("comportamiento"),
                        rs.getInt("gravedad")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener fichas ABC del estudiante: " + e.getMessage());
        }

        return listaFichas;
    }

}
