package dao;

import configuration.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.catalogo.Diagnostico;
import model.catalogo.NivelFuncional;
import model.entidades.Aula;
import model.entidades.Estudiante;

public class DocenteDao implements IDocenteDao {

    private Connection conn;

    public DocenteDao() {
        conn = Conexion.estableceConexion();
    }

    @Override
    public Aula obtenerDatosAula(int idDocente) {
        String sql = "SELECT a.id_aula, a.nombre, nf.id_nivel, nf.nombre AS nivel_funcional, "
                + "d.id_diagnostico, d.nombre AS diagnostico, a.vacantes_totales, a.vacantes_disponibles "
                + "FROM aula a "
                + "JOIN nivel_funcional nf ON a.id_nivel_funcional = nf.id_nivel "
                + "JOIN diagnostico d ON a.id_diagnostico_referente = d.id_diagnostico "
                + "WHERE a.id_docente = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idDocente);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                NivelFuncional nivel = new NivelFuncional(rs.getInt("id_nivel"), rs.getString("nivel_funcional"));
                Diagnostico diagnostico = new Diagnostico(rs.getInt("id_diagnostico"), rs.getString("diagnostico"));

                return new Aula(rs.getInt("id_aula"), rs.getString("nombre"), nivel, diagnostico,
                        rs.getInt("vacantes_totales"), rs.getInt("vacantes_disponibles"), null);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del aula: " + e.getMessage());
        }
        return null;
    }

    @Override
    public int obtenerIdDocenteporPersona(int idPersona) {
        String sql = "SELECT id_docente FROM docente WHERE id_persona = ?";
        int idDocente = -1;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idPersona);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idDocente = rs.getInt("id_docente");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener idDocente: " + e.getMessage());
        }
        return idDocente;
    }

    @Override
    public List<Estudiante> obtenerListaEstudiantes(int idDocente) {
        List<Estudiante> listaEstdudiantes = new ArrayList<>();
        String sql = "SELECT e.id_estudiante, p.nombres, p.apellidos "
                + "FROM estudiante e "
                + "JOIN persona p ON e.id_persona = p.id_persona "
                + "JOIN matricula m ON e.id_estudiante = m.id_estudiante "
                + "JOIN aula a ON m.id_aula = a.id_aula "
                + "WHERE a.id_docente = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idDocente);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante(
                        rs.getInt("id_estudiante"),
                        rs.getString("nombres"),
                        rs.getString("apellidos")
                );
                listaEstdudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de estudiantes: : " + e.getMessage());
        }
        return listaEstdudiantes;
    }

}
