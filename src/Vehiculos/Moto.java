package Vehiculos;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(int cilindraje,String ID, String marca, String yearF,float tarifaKm, String modelo){
        super(ID,marca,yearF,tarifaKm,modelo);
        this.cilindraje=cilindraje;
    }
    public Moto(){}
    public int getCilindraje(){
        return this.cilindraje;
    }
    public void setCilindraje(int cilindraje){
        this.cilindraje=cilindraje;
    }
    
}
