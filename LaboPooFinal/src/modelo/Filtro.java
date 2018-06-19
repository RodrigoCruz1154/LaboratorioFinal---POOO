/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String num;
    private int edad;
    private String nombrePerro;
    private String propietario;
    private String raza;
    private boolean estado;
    
    public Filtro(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombrePerro() {
        return nombrePerro;
    }

    public void setNombrePerro(String nombrePerro) {
        this.nombrePerro = nombrePerro;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Filtro(int id, String num, int edad, String nombrePerro, String propietario, String raza, boolean estado) {
        this.id = id;
        this.num = num;
        this.edad = edad;
        this.nombrePerro = nombrePerro;
        this.propietario = propietario;
        this.raza = raza;
        this.estado = estado;
    }

    public Filtro(String num, int edad, String nombrePerro, String propietario, String raza, boolean estado) {
        this.num = num;
        this.edad = edad;
        this.nombrePerro = nombrePerro;
        this.propietario = propietario;
        this.raza = raza;
        this.estado = estado;
    }

    public Filtro(String raza, boolean estado) {
        this.raza = raza;
        this.estado = estado;
    }
    
    
    
}
