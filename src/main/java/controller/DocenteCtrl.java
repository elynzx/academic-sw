/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.dao.IDocenteDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class DocenteCtrl {

    private IDocenteDao docenteDao;

    public DocenteCtrl(IDocenteDao docenteDao) {
        this.docenteDao = docenteDao;
    }

    public DefaultTableModel obtenerModeloTablaEstudiantes(int idDocente) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");

        try {
            List<Estudiante> listaEstudiantes = docenteDao.obtenerListaEstudiantes(idDocente);
            modelo.setRowCount(0);

            for (Estudiante estudiante : listaEstudiantes) {
                modelo.addRow(new Object[]{
                    estudiante.getIdEstudiante(),
                    estudiante.getNombres(),
                    estudiante.getApellidos()
                });
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de estudiantes: " + e.getMessage());
        }

        return modelo;
    }
    
    
    
    

}
