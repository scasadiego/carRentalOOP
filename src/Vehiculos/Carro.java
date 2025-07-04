package Vehiculos;

public class Carro extends Vehiculo {
    private int numPuertas;
    private String transmisionTipo;

    public Carro(int numPuertas, String transmisionTipo,String ID, String marca, String yearF,float tarifaKm, String modelo){
        super(ID,marca,yearF,tarifaKm,modelo);
        this.numPuertas=numPuertas;this.transmisionTipo=transmisionTipo;
    }
    public Carro(){}
    public int getNumPuertas(){
        return this.numPuertas;
    }
    public void setNumPuertas(int numPuertas){
        this.numPuertas=numPuertas;
    }
    public String getTransmisionTipo(){
        return this.transmisionTipo;
    }
    public void setTransmisionTipo(String transmisionTipo){
        this.transmisionTipo=transmisionTipo;
    }
}

