package Vehiculo;

public class carro extends vehiculo {
    private int numPuertas;
    private String transmisionTipo;

    //Al parecer toca poner primero el super y luego con el this en los constructores
    public carro(int numPuertas, String transmisionTipo,int ID, String marca, int yearF,int tarifaKm, String modelo){
        super(ID,marca,yearF,tarifaKm,modelo);
        this.numPuertas=numPuertas;this.transmisionTipo=transmisionTipo;
    }
    public carro(){}
    int getNumPuertas(){
        return this.numPuertas;
    }
    void setNumPuertas(int numPuertas){
        this.numPuertas=numPuertas;
    }
    String getTransmisionTipo(){
        return this.transmisionTipo;
    }
    void setTransmisionTipo(String transmisionTipo){
        this.transmisionTipo=transmisionTipo;
    }
}

