package Alquiler;

import Vehiculos.Vehiculo;

public class RegistroAlquiler {
    private Vehiculo vehiculo;
    private float kms;
    private float costo;

    public RegistroAlquiler(Vehiculo vehiculo, float kms, float costo) {
        this.vehiculo = vehiculo;
        this.kms = kms;
        this.costo = costo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public float getKms() {
        return kms;
    }

    public float getCosto() {
        return costo;
    }

    public String toString() {
        return "- Vehículo: " + vehiculo.getID() + " | Marca: " + vehiculo.getMarca() + " | Modelo: " + vehiculo.getModelo() +
               " | Kms: " + kms + " | Costo: $" + costo;
    }
}
