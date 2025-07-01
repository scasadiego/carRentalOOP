package Vehiculos;

public class Vehiculo {
    private String id;
    private String marca;
    private String yearF;
    private boolean estado;
    private float tarifaKm;
    private String modelo;
    public Vehiculo(String id, String marca, String yearF, float tarifaKm, String modelo){
        this.id=id;this.marca=marca;this.yearF=yearF;this.tarifaKm=tarifaKm;this.estado=true;this.modelo=modelo;
    }
    
    
    public Vehiculo(){}
    public String getID(){
        return this.id;
    }
    public void setID(String ID){
        this.id=ID;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public String getYear(){
        return this.yearF;
    }
    public void setYear(String yearF){
        this.yearF=yearF;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    public float getTarifa(){
        return this.tarifaKm;
    }
    public void setTarifa(float tarifaKm){
        this.tarifaKm=tarifaKm;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
}
