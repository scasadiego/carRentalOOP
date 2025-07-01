package Vehiculos;

public class bElectrica extends Vehiculo{
    private int batteryLevel;
    private float maxAutonomy;

    //Al parecer toca poner primero el super y luego con el this en los constructores
    public bElectrica(int batteryLevel, float maxAutonomy,String ID, String marca, String yearF,float tarifaKm, String modelo){
        super(ID,marca,yearF,tarifaKm,modelo);
        this.batteryLevel=batteryLevel;this.maxAutonomy=maxAutonomy;
    }
    public bElectrica(){}
    public int getBattery(){
        return this.batteryLevel;
    }
    public void setBattery(int batteryLevel){
        this.batteryLevel=batteryLevel;
    }
    public Float getMaxAutonomy(){
        return this.maxAutonomy;
    }
    public void setMaxAutonomy(float maxAutonomy){
        this.maxAutonomy=maxAutonomy;
    }
}
