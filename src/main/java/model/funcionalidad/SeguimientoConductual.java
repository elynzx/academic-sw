/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.funcionalidad;

import model.catalogo.CategoriaConducta;
import java.sql.Date;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class SeguimientoConductual {

    private int id;
    private Estudiante estudiante;
    private Date fecha;
    private CategoriaConducta categoria;
    private String descripcionConducta;
    private int frecuencia;
    private String observaciones;

    public SeguimientoConductual(int id, Estudiante estudiante, Date fecha, CategoriaConducta categoria, String descripcionConducta, int frecuencia, String observaciones) {
        this.id = id;
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcionConducta = descripcionConducta;
        this.frecuencia = frecuencia;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CategoriaConducta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaConducta categoria) {
        this.categoria = categoria;
    }

    public String getDescripcionConducta() {
        return descripcionConducta;
    }

    public void setDescripcionConducta(String descripcionConducta) {
        this.descripcionConducta = descripcionConducta;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
