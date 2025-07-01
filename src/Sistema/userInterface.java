package Sistema;

import java.util.Scanner;

import Alquiler.Alquiler;
import Clientes.Cliente;
import Vehiculos.Carro;
import Vehiculos.Moto;
import Vehiculos.bElectrica;

public class userInterface {


    private Alquiler alquiler = new Alquiler(); 
    private Scanner scan= new Scanner(System.in);

    public int menu(){
        System.out.println("Bienvenido Al menu de Rental car");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar vehículo");
        System.out.println("3. Ver vehículos disponibles por tipo");
        System.out.println("4. Alquilar un vehículo");
        System.out.println("5. Devolver vehículo");
        System.out.println("6. Ver reportes básicos-");
        System.out.println("7. Salir");
        System.out.println("opcion: ");
        int opcion= scan.nextInt();
        scan.nextLine();
        return opcion;

    }
    public int menuVehiculos(){
        System.out.println("1. carro");
        System.out.println("2. moto");
        System.out.println("3. Bicicleta electrica");
        System.out.println("opcion: ");
        int opcion= scan.nextInt();
        return opcion;
    } 

    public void registrarCliente(){
        System.out.println("AGREGACION DE USUARIOS");
        System.out.println("Nombre:");
        String nombre= scan.nextLine();
        System.out.println("id: ");
        String id= scan.nextLine();
        System.out.println("Email: ");
        String email= scan.nextLine();
        alquiler.agregarCliente(new Cliente(nombre, id, email));
        System.out.println("Cliente creado exitosamente");

    }

    public void registrarCarro(){
        System.out.println("VINCULACION DE Carro");
        System.out.println("id del carro: ");
        String id= scan.nextLine();
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        System.out.println("tarifa por kilometro: ");
        float tarifa=scan.nextFloat();
        System.out.println("modelo: ");
        scan.nextLine();
        String modelo= scan.nextLine();
        System.out.println("Numero de puertas: ");
        int numPuertas= scan.nextInt();
        System.out.println("tipo de transmision: ");
        scan.nextLine();
        String transmision= scan.nextLine();

        alquiler.agregarCarro(new Carro(numPuertas,transmision,id,marca,fechaf,tarifa,modelo));
        System.out.println("Carro creado exitosamente");
    }

    public void registrarMoto(){
        System.out.println("VINCULACION DE MOTO");
        System.out.println("id de la moto: ");
        String id= scan.nextLine();
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        System.out.println("tarifa por kilometro: ");
        float tarifa=scan.nextFloat();
        System.out.println("modelo: ");
        scan.nextLine();
        String modelo= scan.nextLine();
        System.out.println("Cilindraje: ");
        int cilindraje= scan.nextInt();
        alquiler.agregarMoto(new Moto(cilindraje,id,marca,fechaf,tarifa,modelo));
        System.out.println("Moto creada exitosamente");
    }

    public void registrarBicicleta(){
        System.out.println("VINCULACION DE BICICLETA ELECTRICA");
        System.out.println("id de la bicicleta: ");
        String id= scan.nextLine();
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        System.out.println("tarifa por kilometro: ");
        float tarifa=scan.nextFloat();
        System.out.println("modelo: ");
        scan.nextLine();
        String modelo= scan.nextLine();
        System.out.println("Nivel de bateria: ");
        int bateria= scan.nextInt();
        System.out.println("Autonomia Maxima (en km): ");
        float autonomia= scan.nextInt();
        alquiler.agregarBicicleta(new bElectrica(bateria,autonomia,id,marca,fechaf,tarifa,modelo));
        System.out.println("Bicicleta Electrica creada exitosamente");
    }

    public void opcionesVehiculos(){
        System.out.println("Eliga el indicador de vehiculo que desea registrar.");
        int opcion= menuVehiculos();
        scan.nextLine();
        switch(opcion){
            case 1:
                registrarCarro();
                break;
            case 2:
                registrarMoto();
                break;
            case 3:
                registrarBicicleta();
                break;
        }
    }


    //Mostrar los vehiculos en estado disponible
    public void mostrarVehiculos(){
        System.out.println("Eliga el indicador del tipo de vehiculos que desea observar:");
        int opc= menuVehiculos();
        scan.nextLine();
        switch(opc){
            case 1: //mostrar los carros
                alquiler.carrosDisponibles();
                break;
            case 2: //mostrar las motos
                alquiler.motosDisponibles();
                break;
            case 3: //Mostrar bicicletas electricas
                alquiler.bicicletasDisponibles();
                break;
        }
    }

    //Alquilar un vehiculo.
    public void alquilarVehiculo(){
        System.out.println("Bienvenido al portal de Alquilar un vehiculo.");
        System.out.println("clientes: ");
        alquiler.mostrarClientes();
        System.out.println("ingrese el id del cliente al que va hacer el alquiler: ");
        String idCliente= scan.nextLine();
        System.out.println("Tipos de vehiculos");
        System.out.println("Eliga el indicador del tipo de vehiculo que desea alquilar: ");
        int opcion= menuVehiculos();
        scan.nextLine();
        switch(opcion){
            case 1: //mostrar los carros
                alquiler.carrosDisponibles();
                break;
            case 2: //mostrar las motos
                alquiler.motosDisponibles();
                break;
            case 3: //Mostrar bicicletas electricas
                alquiler.bicicletasDisponibles();
                break;
        }
        System.out.print("Ingrese el ID del vehículo que desea alquilar: ");
        String idVehiculo = scan.nextLine();
        System.out.print("Ingrese los kilómetros que desea recorrer: ");
        float kms = scan.nextFloat();
        scan.nextLine();
        float costo = alquiler.alquilarVehiculo(idCliente, idVehiculo, kms);
        if (costo >= 0) {
            System.out.println("Alquiler realizado con éxito.");
            System.out.println("Costo total: $" + costo);
        }
    }

    public void devolverVehiculo() {
        System.out.println("Portal de devolución de vehículo");

        System.out.println("clientes: ");
        alquiler.mostrarClientes();
        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = scan.nextLine();

        System.out.print("Ingrese el ID del vehículo: ");
        String idVehiculo = scan.nextLine();

        alquiler.devolverVehiculo(idCliente, idVehiculo);
    }



    //Historial de alquiler para cada cliente
    public void mostrarHistorialDeCliente() {
        System.out.println("Portal para verificar los alquileresde los usuarios");
        System.out.println("clientes: ");
        alquiler.mostrarClientes();
        System.out.print("Ingrese el ID del cliente: ");
        String id = scan.nextLine();
        alquiler.mostrarHistorialCliente(id);
    }

        
}
