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
import model.catalogo.Antecedente;
import model.catalogo.FuncionComportamiento;
import model.catalogo.TipoConducta;

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
    public List<TipoConducta> ObtenerTipoConductas() {
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
    public List<FuncionComportamiento> ObtenerFuncionComportamientos() {
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
      
    return true;
    
    }

    @Override
    public boolean guardarFichaAbc(int idEstudiante, int idAntecedente, String comportamiento, String consecuencia, int gravedad) {
     
    return true;
    }

}
