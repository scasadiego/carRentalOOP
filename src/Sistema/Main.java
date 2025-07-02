package Sistema;
public class Main{
    public static void main(String Args[]){
        userInterface ui= new userInterface();
        int opcion=0;
        do{
            opcion= ui.menu();
            switch(opcion){
                case 1:
                    ui.registrarCliente();
                    break;
                case 2: 
                    ui.opcionesVehiculos();
                    break;
                case 3:
                    ui.mostrarVehiculos();
                    break;
                case 4:
                    ui.alquilarVehiculo();
                    break;
                case 5: 
                    ui.devolverVehiculo();
                    break;
                case 6:
                    ui.mostrarHistorialDeCliente();
                    break;
                case 7: 
                    ui.verAlquileresPorCliente();
                    break;
                 
            }

        }while(opcion !=8);

    }
}