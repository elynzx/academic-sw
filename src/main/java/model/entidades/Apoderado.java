/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entidades;

import java.sql.Date;

public class Apoderado extends Persona {

    private int idApoderado;
    private String parentesco;

    public Apoderado() {

    }

    
    public Apoderado(int idApoderado, String parentesco, int id, String nombres, String apellidos, String dni, String celular, String correo, String direccion, Date fechaNacimiento, String genero) {
        super(id, nombres, apellidos, dni, celular, correo, direccion, fechaNacimiento, genero);
        this.idApoderado = idApoderado;
        this.parentesco = parentesco;
    }

    public int getIdApoderado() {
        return idApoderado;
    }

    public void setIdApoderado(int idApoderado) {
        this.idApoderado = idApoderado;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

}
