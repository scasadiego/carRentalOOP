package Sistema;

import Alquiler.Alquiler;
import Clientes.Cliente;
import Vehiculos.Carro;
import Vehiculos.Moto;
import Vehiculos.bElectrica;
import java.util.Scanner;

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
        System.out.println("6. Ver reportes básicos");
        System.out.println("7. Mostrar alquileres activos por cliente");
        System.out.println("8. Salir");
        System.out.println("opcion: ");
        int opcion= scan.nextInt();
        scan.nextLine();
        return opcion;

    }
    public int menuVehiculos(){
        int opcion;
        do{
        System.out.println("1. carro");
        System.out.println("2. moto");
        System.out.println("3. Bicicleta electrica");
        System.out.println("opcion: ");
        opcion= scan.nextInt();
        }while(opcion<1 || opcion>3);
        return opcion;
    } 


    public void registrarCliente(){
        System.out.println("AGREGACION DE USUARIOS");
        System.out.println("Nombre:");
        String nombre= scan.nextLine();
        String id;
        do{
            System.out.println("id: ");
            id= scan.nextLine();
        }while(!alquiler.compararID(id));
        System.out.println("Email: ");
        String email= scan.nextLine();
        alquiler.agregarCliente(new Cliente(nombre, id, email));
        System.out.println("Cliente creado exitosamente");

    }

    public void registrarCarro(){
        System.out.println("VINCULACION DE Carro");
        String id;
        do{
            System.out.println("id del carro: ");
            id= scan.nextLine();
        }while(!alquiler.compararIDc(id));
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        float tarifa;
        do{
            System.out.println("tarifa por kilometro: ");
            tarifa=scan.nextFloat();
            if(tarifa<0){
                System.out.println("Ingrese un numero positivo");
            }
        }while(tarifa<0);
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
        String id;
        do{
            System.out.println("id de la moto: ");
            id= scan.nextLine();
        }while(alquiler.compararIDm(id));
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        float tarifa;
         do{
            System.out.println("tarifa por kilometro: ");
            tarifa=scan.nextFloat();
            if(tarifa<0){
                System.out.println("Ingrese un numero positivo");
            }
        }while(tarifa<0);
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
        String id;
        do{
            System.out.println("id de la bicicleta: ");
            id= scan.nextLine();
        }while(alquiler.compararIDb(id));
        System.out.println("marca: ");
        String marca=scan.nextLine();
        System.out.println("Año de Fabricacion: ");
        String fechaf=scan.nextLine();
        float tarifa;
         do{
            System.out.println("tarifa por kilometro: ");
            tarifa=scan.nextFloat();
            if(tarifa<0){
                System.out.println("Ingrese un numero positivo");
            }
        }while(tarifa<0);
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
        int opcion;
        System.out.println("Eliga el indicador de vehiculo que desea registrar.");
        opcion= menuVehiculos();
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
        if(alquiler.clientes.isEmpty()){
            System.out.println("No hay clientes para alquilar vehiculos");
            return;
        }
        else{
            System.out.println("ingrese el id del cliente al que va hacer el alquiler: ");
            String idCliente= scan.nextLine();
            System.out.println("Tipos de vehiculos");
            int opcion;
            System.out.println("Eliga el indicador del tipo de vehiculo que desea alquilar: ");
            opcion= menuVehiculos();
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
            
    }

        public void devolverVehiculo() {
            System.out.println("Portal de devolución de vehículo");
            System.out.println("clientes: ");
            alquiler.mostrarClientes();
            if(alquiler.clientes.isEmpty()){
                System.out.println("No hay clientes registrados para hacer devoluciones");
                return;
            }
            else{
                System.out.print("Ingrese el ID del cliente: ");
                String idCliente = scan.nextLine();

                System.out.print("Ingrese el ID del vehículo: ");
                String idVehiculo = scan.nextLine();

                alquiler.devolverVehiculo(idCliente, idVehiculo);
            }
           
        }



        //Historial de alquiler para cada cliente
        public void mostrarHistorialDeCliente() {
            System.out.println("Portal para verificar los alquileres de los usuarios");
            System.out.println("clientes: ");
            alquiler.mostrarClientes();
            if(alquiler.clientes.isEmpty()){
                System.out.println("No hay clientes registrados en el sistema");
                return;
            }
            else{
                System.out.print("Ingrese el ID del cliente: ");
                String id = scan.nextLine();
                alquiler.mostrarHistorialCliente(id);
            }
        }
        
        public void verAlquileresPorCliente(){
            System.out.println("Portal para verificar los alquileres activos por cliente");
            System.out.println("Clientes: ");
            alquiler.mostrarClientes();
            if(alquiler.clientes.isEmpty()){
                System.out.println("No hay clientes registrados en el sistema");
                return;
            }
            else{
                System.out.print("Ingrese el ID del cliente: ");
                String id = scan.nextLine();
                alquiler.mostrarAlquileresActivosPorCliente(id);
            }

        }

        
}
