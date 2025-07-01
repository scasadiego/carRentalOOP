package Clientes;
import Vehiculos.Vehiculo;

import java.util.ArrayList;

import Alquiler.RegistroAlquiler;

public class Cliente {
    private String nombre;
    private String ID;
    private boolean estado=true;
    private ArrayList<RegistroAlquiler> alquilados = new ArrayList<>();
    private String email;

    public Cliente(String nombre, String ID, String email){
        this.nombre=nombre;this.ID=ID;this.email=email;
    }

    public Cliente(){}

    public boolean getEstado(){
        return this.estado;
    }

    public void setEstado(boolean estado){
        this.estado=estado;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getID(){
        return this.ID;
    }
    public void setID(String ID){
        this.ID=ID;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void agregarAlquiler(Vehiculo vehiculo, float kms, float costo) {
        alquilados.add(new RegistroAlquiler(vehiculo, kms, costo));
    }


    public ArrayList<RegistroAlquiler> getAlquilados(){
        return this.alquilados;
    }

    public void mostrarHistorialAlquileres() {
    if (alquilados.isEmpty()) {
        System.out.println("No tiene historial de alquileres.");
        return;
    }

    System.out.println("Historial de alquileres del cliente:");
    for (RegistroAlquiler registro : alquilados) {
        System.out.println(registro.toString());
    }
}

}
