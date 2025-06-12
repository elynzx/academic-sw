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
import model.funcionalidad.catalogo.Diagnostico;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class EstudianteDao implements IEstudianteDao {

    private static EstudianteDao instanciaEstudiante;

    private Connection conn;

    public EstudianteDao() {
        conn = Conexion.estableceConexion();
    }

    public static EstudianteDao obtenerInstancia() {
        if (instanciaEstudiante == null) {
            instanciaEstudiante = new EstudianteDao();
        }
        return instanciaEstudiante;
    }

    @Override
    public Estudiante obtenerDatosEstudiante(int idEstudiante) {
        Estudiante estudiante = null;
        String sql = "SELECT e.id_estudiante, p.nombres, p.apellidos, p.fecha_nacimiento, "
                + "e.tipo_alergia, e.medicamentos, e.observaciones, "
                + "d.id_diagnostico, d.nombre AS diagnostico "
                + "FROM estudiante e "
                + "JOIN persona p ON e.id_persona = p.id_persona "
                + "LEFT JOIN estudiante_diagnostico ed ON e.id_estudiante = ed.id_estudiante "
                + "LEFT JOIN diagnostico d ON ed.id_diagnostico = d.id_diagnostico "
                + "WHERE e.id_estudiante = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idEstudiante);
            ResultSet rs = pst.executeQuery();

            List<Diagnostico> diagnosticos = new ArrayList<>();

            while (rs.next()) {
                if (estudiante == null) {
                    estudiante = new Estudiante(
                            rs.getInt("id_estudiante"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getDate("fecha_nacimiento"),
                            rs.getString("tipo_alergia"),
                            rs.getString("medicamentos"),
                            rs.getString("observaciones"),
                            new ArrayList<>()
                    );
                }
                Diagnostico diagnostico = new Diagnostico(rs.getInt("id_diagnostico"), rs.getString("diagnostico"));
                diagnosticos.add(diagnostico);
            }

            if (estudiante != null) {
                estudiante.setDiagnosticos(diagnosticos);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del estudiante: " + e.getMessage());
        }

        return estudiante;
    }

//    @Override
//    public List<Estudiante> obtenerEstudiantesDocente(int idDocente) {
//
//        List<Estudiante> lista = new ArrayList<>();
//        String sql = "SELECT e.id_estudiante, p.nombres, p.apellidos, "
//                + "d.id_diagnostico, d.nombre AS diagnostico "
//                + "FROM estudiante e "
//                + "JOIN persona p ON e.id_persona = p.id_persona "
//                + "JOIN matricula m ON e.id_estudiante = m.id_estudiante "
//                + "LEFT JOIN diagnostico d ON ed.id_diagnostico = d.id_diagnostico "
//                + "JOIN aula a ON m.id_aula = a.id_aula "
//                + "WHERE a.id_docente = ? "
//                + "ORDER BY p.nombres ASC";
//
//        try (PreparedStatement pst = conn.prepareStatement(sql)) {
//            pst.setInt(1, idDocente);
//            ResultSet rs = pst.executeQuery();
//            List<Diagnostico> diagnosticos = new ArrayList<>();
//            while (rs.next()) {
//
//                lista.add(new Estudiante(rs.getInt("id_estudiante"), rs.getString("nombres"), rs.getString("apellidos")));
//                Diagnostico diagnostico = new Diagnostico(rs.getInt("id_diagnostico"), rs.getString("diagnostico"));
//                diagnosticos.add(diagnostico);
//            }
//            if (lista != null) {
//                lista.setDiagnosticos(diagnosticos);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al obtener estudiantes del docente: " + e.getMessage());
//        }
//        return lista;
//    }
}
