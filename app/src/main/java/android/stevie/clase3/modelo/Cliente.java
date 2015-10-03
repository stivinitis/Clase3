package android.stevie.clase3.modelo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Clientes")
public class Cliente extends Model{
    //Foreign key
    @Column(name = "persona")
    public Personas persona;

    @Column

    public String email;

    public Cliente(){

    }
}
