/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.funcionalidad;

import model.funcionalidad.catalogo.TipoConducta;
import model.funcionalidad.catalogo.EstrategiaIntervencion;
import model.funcionalidad.catalogo.FuncionComportamiento;
import java.sql.Date;
import model.entidades.Estudiante;

/**
 *
 * @author rpasc
 */
public class PlanIntervencion {

    private int id;
    private Estudiante estudiante;
    private Date fechaInicio;
    private TipoConducta tipoConducta;
    private FuncionComportamiento funcion;
    private String objetivo;
    private EstrategiaIntervencion estrategia;
    private boolean aplicadoAntes;
    private String observaciones;

    public PlanIntervencion(int id, Estudiante estudiante, Date fechaInicio, TipoConducta tipoConducta, FuncionComportamiento funcion, String objetivo, EstrategiaIntervencion estrategia, boolean aplicadoAntes, String observaciones) {
        this.id = id;
        this.estudiante = estudiante;
        this.fechaInicio = fechaInicio;
        this.tipoConducta = tipoConducta;
        this.funcion = funcion;
        this.objetivo = objetivo;
        this.estrategia = estrategia;
        this.aplicadoAntes = aplicadoAntes;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public TipoConducta getTipoConducta() {
        return tipoConducta;
    }

    public void setTipoConducta(TipoConducta tipoConducta) {
        this.tipoConducta = tipoConducta;
    }

    public FuncionComportamiento getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionComportamiento funcion) {
        this.funcion = funcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public EstrategiaIntervencion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaIntervencion estrategia) {
        this.estrategia = estrategia;
    }

    public boolean isAplicadoAntes() {
        return aplicadoAntes;
    }

    public void setAplicadoAntes(boolean aplicadoAntes) {
        this.aplicadoAntes = aplicadoAntes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    

}
