package Alquiler;
import Vehiculos.Vehiculo;
import Vehiculos.bElectrica;
import Vehiculos.Carro;
import Vehiculos.Moto;

import java.util.ArrayList;

import Clientes.Cliente;

public class Alquiler {
    public Vehiculo vehiculo;
    public int precio;
    public ArrayList<Carro> carros= new ArrayList<>();
    public ArrayList<Moto> motos= new ArrayList<>();
    public ArrayList<bElectrica> bicicletas= new ArrayList<>();
    public ArrayList<Cliente> clientes= new ArrayList<>();


    public Alquiler(int precio){
        this.precio=precio;
    }
    public Alquiler(){} 

    public float getPrecioAlquiler(){
        return this.vehiculo.getTarifa();
    }
    public void marcarDisponible(){
        this.vehiculo.setEstado(true);
    }
    public void marcarOcupado(){
        this.vehiculo.setEstado(false);
    }

    public void agregarCarro(Carro carro){
        this.carros.add(carro);
    }

    public void agregarMoto(Moto moto){
        this.motos.add(moto);
    }
    public void agregarBicicleta(bElectrica bicicleta){
        this.bicicletas.add(bicicleta);
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public ArrayList<Moto> getMotos() {
        return motos;
    }

    public ArrayList<bElectrica> getBicicletas() {
        return bicicletas;
    }
    //mostrar los carros disponibles
    public void carrosDisponibles(){
        ArrayList<Carro> carros = getCarros();
        if (carros.isEmpty()) {
            System.out.println("No hay Carros registrados.");
            return;
        }
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getEstado()) {
                System.out.println("- id:" + carros.get(i).getID()+" - Marca:"+ carros.get(i).getMarca()+" - Modelo: "+ carros.get(i).getModelo()+" - Tarifa x Km: "+ carros.get(i).getTarifa()+" - Numero de puertas: "+ carros.get(i).getNumPuertas()+" - Tipo Transmision: "+ carros.get(i).getTransmisionTipo());
            }
        }
    }
    //mostrar la motos dispnbles
    public void motosDisponibles(){
        ArrayList<Moto> motos = getMotos();
        if (motos.isEmpty()) {
            System.out.println("No hay motos registradas.");
            return;
        }
        for (int i = 0; i < motos.size(); i++) {
            if (motos.get(i).getEstado()) {
                System.out.println("- id:" + motos.get(i).getID()+" - Marca:"+ motos.get(i).getMarca()+" - Modelo: "+ motos.get(i).getModelo()+" - Tarifa x Km: "+ motos.get(i).getTarifa()+" - Cilindraje: "+ motos.get(i).getCilindraje());
            }
        }
    }
    //mostrar la bicicletas disponibles
    public void bicicletasDisponibles(){
        ArrayList<bElectrica> bicicletas = getBicicletas();
        if (bicicletas.isEmpty()) {
            System.out.println("No hay Bicicletas electricas registradas.");
            return;
        }
        for (int i = 0; i < bicicletas.size(); i++) {
            if (bicicletas.get(i).getEstado()) {
                System.out.println("- id:" + bicicletas.get(i).getID()+" - Marca:"+ bicicletas.get(i).getMarca()+" - Modelo: "+ bicicletas.get(i).getModelo()+" - Tarifa x Km: "+ bicicletas.get(i).getTarifa()+" - Nivel de bateria : "+ bicicletas.get(i).getBattery()+" - Autonomia Maxima: "+ bicicletas.get(i).getMaxAutonomy());
            }
        }
    }

    //Mostrar clientes
    public void mostrarClientes(){
        ArrayList<Cliente> clientes = getClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getEstado()) {
                System.out.println("- id:" + clientes.get(i).getID()+" - Nombre:"+ clientes.get(i).getNombre()+" - Email: "+ clientes.get(i).getEmail());
            }
        }
    }

    //Alquilar un vehiculo (esta es la)
    public float alquilarVehiculo(String idCliente, String idVehiculo, float kms) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getID().equals(idCliente)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return -1;
        }
        if (!cliente.getEstado()) {
            System.out.println("El cliente ya tiene un vehículo alquilado.");
            return -1;
        }

        Vehiculo vehiculo = null;

        for (Carro c : carros) {
            if (c.getID().equals(idVehiculo) && c.getEstado()) {
                vehiculo = c;
                break;
            }
        }
        if (vehiculo == null) {
            for (Moto m : motos) {
                if (m.getID().equals(idVehiculo) && m.getEstado()) {
                    vehiculo = m;
                    break;
                }
            }
        }
        if (vehiculo == null) {
            for (bElectrica b : bicicletas) {
                if (b.getID().equals(idVehiculo) && b.getEstado()) {
                    vehiculo = b;
                    break;
                }
            }
        }

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado o no disponible.");
            return -1;
        }

        float tarifaBase = vehiculo.getTarifa();
        float costoTotal = tarifaBase * kms;

        vehiculo.setEstado(false);
        cliente.setEstado(false);
        cliente.agregarAlquiler(vehiculo, kms, costoTotal);


        System.out.println("Vehículo alquilado con éxito.");
        return costoTotal;
    }


    //devolver vehiculo
    public void devolverVehiculo(String idCliente, String idVehiculo) {
        Cliente cliente = null;

        // Buscar cliente por ID
        for (Cliente c : clientes) {
            if (c.getID().equals(idCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        if (cliente.getEstado()) {
            System.out.println("Este cliente no tiene un vehículo alquilado actualmente.");
            return;
        }

        Vehiculo vehiculo = null;

        // Buscar en carros
        for (Carro c : carros) {
            if (c.getID().equals(idVehiculo)) {
                vehiculo = c;
                break;
            }
        }

        // Buscar en motos
        if (vehiculo == null) {
            for (Moto m : motos) {
                if (m.getID().equals(idVehiculo)) {
                    vehiculo = m;
                    break;
                }
            }
        }

        // Buscar en bicicletas
        if (vehiculo == null) {
            for (bElectrica b : bicicletas) {
                if (b.getID().equals(idVehiculo)) {
                    vehiculo = b;
                    break;
                }
            }
        }

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        // Cambiar estados
        cliente.setEstado(true);
        vehiculo.setEstado(true);

        System.out.println("El vehículo ha sido devuelto exitosamente.");
    }


    //mOSTRAR LAS RENTAS DE CADA CLIENTE, RECIBE EL CLIENTE
    public void mostrarHistorialCliente(String idCliente) {
        for (Cliente c : clientes) {
            if (c.getID().equals(idCliente)) {
                c.mostrarHistorialAlquileres();
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }


}
