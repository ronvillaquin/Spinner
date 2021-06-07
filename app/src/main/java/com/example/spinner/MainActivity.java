package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1, valor2;
    private Spinner spinner1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText)findViewById(R.id.txt_valor1);
        valor2 = (EditText)findViewById(R.id.txt_valor2);
        tv1 = (TextView)findViewById(R.id.tv_resultado);
        spinner1 = (Spinner)findViewById(R.id.spinner);

        //ahora se crea u vector para agregar los valores al vector
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        // para poder mostrar el texto del vestor hay que comunicar el spinner con el vector

        // se coloca arrayAdapter y el tipo de dato con el que se trabaja string o entero
        // adapter es el tipo de objeto que se creo que se puede nombrar como deseemos
        //se crea el new array se hace referencia al mismo con this se le dice que es un spinner
        //simple ya que se modificara su grafica despues y se coloca el vector opciones
        //primero se utilizo el tipo de spinner que nos da android luego se modifico mediante un xml q se creo para darle stylo
        //
        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        // se coloca la siguiente linea de codigo en ves de la anterior haciendo referencia al nuevo xml que se creo para darle diseño al spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_seleccion, opciones);
        // ahora hay que asignar al spiner el opjeto adapter que cremos en la linea de arriba
        spinner1.setAdapter(adapter);
    }

    // se crea el metodo o clasee que tendra el boton calcular
    public void Calcular(View vista){
        //se recuperan los valores q introdujo el usuario y se pasan a string porque vienen sin tipo de dato
        String valor1_string = valor1.getText().toString();
        String valor2_string = valor2.getText().toString();
        //luego se pasan los valores a entero para poder realizar la operacion
        int valor1_int = Integer.parseInt(valor1_string);
        int valor2_int = Integer.parseInt(valor2_string);

        // ahora se recupera la opcion del spinner para saber que selecciono y se combierte a String
        String seleccion = spinner1.getSelectedItem().toString();
        // con equals comparamos cadenas de texto
        if (seleccion.equals("Sumar")){
            int suma = valor1_int + valor2_int;
            // se combierte a string para poder mostrar
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Restar")){
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Multiplicar")){
            int multiplicar = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);
        }
        if (seleccion.equals("Dividir")){
            if (valor2_int == 0){
                Toast.makeText(this, "No es divisible entre 0", Toast.LENGTH_LONG).show();
            }else {
                int dividir = valor1_int / valor2_int;
                String resultado = String.valueOf(dividir);
                tv1.setText(resultado);
            }
        }

        // se creo otro .xml para darle formato visual al spinner en tipo de letra y demas
    }
}
