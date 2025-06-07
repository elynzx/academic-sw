/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import java.util.Map;
import model.catalogo.CategoriaConducta;

/**
 *
 * @author rpasc
 */
public interface ISeguimiento {
    
    List<CategoriaConducta> ObtenerCategoriaConductas();
    boolean guardarSeguimiento(int idEstudiante, int idCategoria, String descripcion, int frecuencia, String observaciones);
    List<Map<String, Object>> obtenerPromedioFrecuencia(int idEstudiante);
    
}
