/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.catalogo.Antecedente;
import model.catalogo.FuncionComportamiento;
import model.catalogo.TipoConducta;

/**
 *
 * @author rpasc
 */
public interface IRegistroIncidente {
    
      List<TipoConducta> ObtenerTipoConductas();
      List<FuncionComportamiento> ObtenerFuncionComportamientos();
      List<Antecedente> obtenerAntecedentes();
      boolean guardarConductaProblematica(int idEstudiante, int idConducta, int idFuncionComportamiento, int gravedad, String descripcion);
      boolean guardarFichaAbc(int idEstudiante, int idAntecedente, String comportamiento, String consecuencia, int gravedad);
      
}
