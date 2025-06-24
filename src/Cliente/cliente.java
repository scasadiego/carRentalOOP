package Cliente;
import Alquiler.Alquiler;
import java.util.ArrayList;

public class cliente {
    private String nombre;
    private int ID;
    private ArrayList<Alquiler> alquilerActivos;
    private String email;
    public cliente(String nombre, int ID, String email){
        this.nombre=nombre;this.ID=ID;this.email=email;
    }
    public cliente(){}
    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getID(){
        return this.ID;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
