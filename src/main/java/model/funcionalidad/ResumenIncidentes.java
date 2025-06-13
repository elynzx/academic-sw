/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.funcionalidad;

import model.funcionalidad.catalogo.FuncionComportamiento;
import model.funcionalidad.catalogo.TipoConducta;

/**
 *
 * @author rpasc
 */
public class ResumenIncidentes {

    private TipoConducta tipoConducta;
    private int frecuencia;
    private double gravedadPromedio;
    private FuncionComportamiento ultComportamiento;

    public ResumenIncidentes(TipoConducta tipoConducta, int frecuencia, double gravedadPromedio, FuncionComportamiento ultComportamiento) {
        this.tipoConducta = tipoConducta;
        this.frecuencia = frecuencia;
        this.gravedadPromedio = gravedadPromedio;
        this.ultComportamiento = ultComportamiento;
    }

    public TipoConducta getTipoConducta() {
        return tipoConducta;
    }

    public void setTipoConducta(TipoConducta tipoConducta) {
        this.tipoConducta = tipoConducta;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getGravedadPromedio() {
        return gravedadPromedio;
    }

    public void setGravedadPromedio(double gravedadPromedio) {
        this.gravedadPromedio = gravedadPromedio;
    }

    public FuncionComportamiento getUltComportamiento() {
        return ultComportamiento;
    }

    public void setUltComportamiento(FuncionComportamiento ultComportamiento) {
        this.ultComportamiento = ultComportamiento;
    }
    
}
