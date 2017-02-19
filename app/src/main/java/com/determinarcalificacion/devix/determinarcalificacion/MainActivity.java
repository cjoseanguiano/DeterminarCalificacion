package com.determinarcalificacion.devix.determinarcalificacion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    Desarrollar una aplicación que determine la calificación de un estudiante universitario
    de acuerdo a la siguiente condición: de 0 hasta 5 será Malo; más de 5 hasta 7
    será Regular; más de 7 hasta 8 será Bueno; de 9 hasta 10 será Excelente.
    Se debe considerar que hay que validar la nota ingresada ya que esta no puede ser menor
    que 0 (cero) o mayor que 20.
     */
    private TextView textViewA;
    private EditText editTextA;
    private EditText editTextB;
    private Button buttonA;
    private Button buttonB;

    String alumno;
    String calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewA = (TextView) findViewById(R.id.txtA);
        editTextA = (EditText) findViewById(R.id.edtA);
        editTextB = (EditText) findViewById(R.id.edtB);
        buttonA = (Button) findViewById(R.id.btnA);
        buttonB = (Button) findViewById(R.id.btnB);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean edtA = editTextA.getText().toString().trim().equals("");//Vacio
                boolean edtB = editTextB.getText().toString().trim().equals("");//Vacio

                alumno = editTextA.getText().toString();
                calificacion = editTextB.getText().toString();

                if (edtA == false && edtB == false) {

                    double cal = Double.parseDouble(calificacion);
                    thisCalificacion(cal);
                    if (cal > 0 && cal <= 10) {
                        textViewA.setText("El alumno: " + alumno + " Es " + calificacion);

                    } else {
                        textViewA.setText("");
                        Toast.makeText(getApplicationContext(), "No cumple", Toast.LENGTH_SHORT).show();

                    }
                } else {

                    Toast.makeText(getApplicationContext(), "NO Tiene Datos", Toast.LENGTH_SHORT).show();

                }

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    public void limpiar() {
        textViewA.setText("");
        editTextA.setText("");
        editTextB.setText("");
        editTextA.requestFocus();
    }

    public void thisCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {

            if (calificacion >= 0 && calificacion <= 5) {
                Toast.makeText(getApplicationContext(), "Estudiando con promedio MALO", Toast.LENGTH_SHORT).show();

            } else if (calificacion > 5 && calificacion <= 7) {
                Toast.makeText(getApplicationContext(), "Estudiando con promedio REGULAR", Toast.LENGTH_SHORT).show();
            } else if (calificacion > 7 && calificacion <= 8) {
                Toast.makeText(getApplicationContext(), "Estudiando con promedio BUENO", Toast.LENGTH_SHORT).show();
            } else if (calificacion == 9 || calificacion == 10) {
                Toast.makeText(getApplicationContext(), "Estudiando con promedio EXCELENTE", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
