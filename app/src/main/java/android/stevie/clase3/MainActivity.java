package android.stevie.clase3;

import android.app.Activity;

import android.os.Bundle;
import android.stevie.clase3.modelo.Personas;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;


public class MainActivity extends Activity {

    Button btnAceptar, btnMostrar, btnBaja, btnAlta, btnModificar, btnConsultar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnAlta = (Button) findViewById(R.id.btnAltaCliente);
        btnBaja = (Button) findViewById(R.id.btnBajaCliente);
        btnModificar = (Button) findViewById(R.id.btnModificarCliente);
        btnConsultar = (Button) findViewById(R.id.btnConsultarCliente);

        Alta();
        Baja();
        Modificar();
        Consultar();

        resultado = (TextView) findViewById(R.id.lblResultado);

        Personas personas = new Personas("jess", "muy", "50", 20);
        //insert into "personas" where apellido = "muy" and
        //nombre= "jess" and
        //dni = "50" and
        //edad = 20)
        personas.save();

        btnAceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Personas personasMartin = new Personas();
                personasMartin.Nombre = "Martin";
                personasMartin.Apellido = "Martinez";
                personasMartin.DNI = "8515674";
                personasMartin.Edad = 20;

                personasMartin.save();

            }
        });


        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personas persona = new Select().from(Personas.class).where("Id = ?", 1).executeSingle();
                resultado.setText(persona.Apellido + " " + persona.Nombre + " " + persona.DNI + " " + persona.Edad);
            }
        });
    }

    private void Modificar() {

    }

    private void Baja() {
        btnBaja.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                new Delete().from(Personas.class).where("DN = ?", "8515674").execute();

                Personas.delete(Personas.class, 1);
            }
    });
    }


    private void Alta() {

    }

    private void Consultar(){
            Personas persona = new Select().from(Personas.class).where("dni = ?", "8515674").executeSingle();
        Toast.makeText(getApplicationContext(), persona.Apellido + " " + persona.DNI, Toast.LENGTH_LONG).show();
        }
    }

