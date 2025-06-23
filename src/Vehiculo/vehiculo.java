package Vehiculo;
public class vehiculo {
    private int ID;
    private String marca;
    private int yearF;
    private boolean estado;
    private int tarifaKm;
    private String modelo;
    public vehiculo(int id, String marca, int yearF, int tarifaKm, String modelo){
        this.ID=id;this.marca=marca;this.yearF=yearF;this.tarifaKm=tarifaKm;this.estado=true;this.modelo=modelo;
    }
    public vehiculo(){}
    int getID(){
        return this.ID;
    }
    void setID(int ID){
        this.ID=ID;
    }
    String getMarca(){
        return this.marca;
    }
    void setMarca(String marca){
        this.marca=marca;
    }
    int getYear(){
        return this.yearF;
    }
    void setYear(int yearF){
        this.yearF=yearF;
    }
    boolean getEstado(){
        return this.estado;
    }
    void setEstado(boolean estado){
        this.estado=estado;
    }
    int getTarifa(){
        return this.tarifaKm;
    }
    void setTarifa(int tarifaKm){
        this.tarifaKm=tarifaKm;
    }
    String getModelo(){
        return this.modelo;
    }
    void setModelo(String modelo){
        this.modelo=modelo;
    }
}
