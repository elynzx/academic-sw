/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.funcionalidad.PlanIntervencion;
import model.funcionalidad.ResumenIncidentes;
import model.funcionalidad.catalogo.EstrategiaIntervencion;
import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;

/**
 *
 * @author rpasc
 */
public interface IPlanIndividual {

    List<PlanIntervencion> obtenerHistorialPlanes(int idEstudiante);

    List<ResumenIncidentes> obtenerResumenIncidentes(int idEstudiante);

    List<TipoConducta> obtenerTipoConductasEstudiante(int idEstudiante);

    FuncionComportamiento obtenerUltimaFuncionComportamiento(int idEstudiante, int idTipoConducta);

    List<EstrategiaIntervencion> obtenerEstrategiasIntervencion();

    boolean verificarPlanExistente(int idEstudiante, int idTipoConducta, int idEstrategia
    );

    boolean registrarPlanIntervencion(int idEstudiante, int idTipoConducta, int idFuncionComportamiento,
            String objetivo,
            int idEstrategia, boolean aplicadoAntes, String observaciones
    );
}
