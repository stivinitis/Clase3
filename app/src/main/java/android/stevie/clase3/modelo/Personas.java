package android.stevie.clase3.modelo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Personas")
public class Personas extends Model{

    @Column(name = "nombre")
    public String Nombre;
    @Column(name = "apellido")
    public String Apellido;
    @Column(name = "dni")
    public String DNI;
    @Column(name = "edad")
    public int Edad;

    public Personas(){

    }

    public Personas(String nombre, String apellido, String DNI, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        this.DNI = DNI;
        Edad = edad;
    }
}
