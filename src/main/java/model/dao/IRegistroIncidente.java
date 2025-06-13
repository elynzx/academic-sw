/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

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
public interface IRegistroIncidente {

    List<TipoConducta> obtenerTipoConductas();

    List<FuncionComportamiento> obtenerFuncionComportamientos();

    List<Antecedente> obtenerAntecedentes();

    boolean guardarConductaProblematica(int idEstudiante, int idConducta, int idFuncionComportamiento, int gravedad, String descripcion);

    boolean guardarFichaAbc(int idEstudiante, int idAntecedente, String comportamiento, String consecuencia, int gravedad);

    List<ConductaProblematica> obtenerConductasPorEstudiante(int idEstudiante);
    
    List<FichaAbc> obtenerFichasPorEstudiante(int idEstudiante);
}
