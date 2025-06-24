package Alquiler;
import Vehiculo.vehiculo;
import Vehiculo.carro;
import Vehiculo.moto;
import Vehiculo.bElectrica;

public class Alquiler {
    private vehiculo vehiculo;
    private int precio;
    public Alquiler(int precio){
        this.precio=precio;
    }
    public Alquiler(){} 

    public int getPrecioAlquiler(){
        return this.vehiculo.getTarifa();
    }
    public void marcarDisponible(){
        this.vehiculo.setEstado(true);
    }
    public void marcarOcupado(){
        this.vehiculo.setEstado(false);
    }

}
