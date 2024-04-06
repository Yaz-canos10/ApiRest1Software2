package com.apiRest.ApiRest.modelo;

public class Vehiculo {

    
    private String marca;
    private String modelo;
    private int lanzamiento;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int lanzamiento, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.lanzamiento = lanzamiento;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}