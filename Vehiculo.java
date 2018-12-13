package project.classes;

import java.io.Serializable;

public class Vehiculo implements Serializable {

    private String modelo;
    private String marca;
    private String color;
    private String tipoDeCombustible;
    private int añoFabricacion;
    private boolean usado = true;
    private int km;
    private double precio;
    private double descuento;
    private String tipoDeVehiculo;
    private long id;



    public Vehiculo(String modelo, String marca, String color, int tipoDeCombustible, int añoFabricacion, int km, double precio, double descuento, int tipoDeVehiculo, long id) {
        if(km==0){
            this.usado = false;
        }

        switch (tipoDeCombustible){
            case 0: this.tipoDeCombustible = "Nafta";break;
            case 1: this.tipoDeCombustible = "Diesel";break;
            case 2: this.tipoDeCombustible = "GNC";break;
            case 3: this.tipoDeCombustible = "Electrico";break;
        }
        switch (tipoDeVehiculo){
            case 0: this.tipoDeVehiculo = "Auto";break;
            case 1: this.tipoDeVehiculo = "Moto";break;
            case 2: this.tipoDeVehiculo = "Camion";break;
            case 3: this.tipoDeVehiculo = "Camioneta";break;
        }
        this.km = km;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.añoFabricacion = añoFabricacion;
        this.precio = precio;
        this.descuento = descuento;
        this.id = id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public boolean isUsado() {
        return usado;
    }

    public int getKm() {
        return km;
    }

    public double getPrecio() {
        return precio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getTipoDeCombustible() {
        return tipoDeCombustible;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipoDeCombustible(String tipoDeCombustible) {
        this.tipoDeCombustible = tipoDeCombustible;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.marca+" "+this.modelo+"\n"+"Color: "+this.color+"\n"+"Tipo de combustible: "+this.tipoDeCombustible+"\n"+"Año de fabricacion: "+this.añoFabricacion+"\n"+
                "Kilometraje: "+this.km+"\n"+"Precio: "+this.precio+"\n"+"ID: "+this.id;

    }

    public String specificToString(){
        return this.marca+" "+this.modelo+"\n";
    }
}
