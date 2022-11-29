package com.example.a05_exercise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    Intent intentResult;
    Pelicula pelicula = new Pelicula("", "", 0, null, "", 0, 0);
    int age = 0;
    String sala = "Gran Via";

    EditText txtTitulo;
    EditText txtDirector;
    EditText txtDuracion;
    CalendarView calendarView;
    Calendar fechaC = Calendar.getInstance();
    Date fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtTitulo = findViewById(R.id.txtTituloActAdd);
        txtDirector = findViewById(R.id.txtDirectorActAdd);
        txtDuracion = findViewById(R.id.txtDuracionActAdd);
        calendarView = findViewById(R.id.calendarView);

        ArrayList<String> salas = new ArrayList<>(Arrays.asList("Gran Via", "Plaza Elíptica", "Travesia"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, salas);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sala = salas.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        intentResult = new Intent(AddActivity.this, MainActivity.class);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                fechaC.set(i, i1, i2);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                String format= format.format(fecha.getTime());
                fecha = fechaC.getTime();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuAceptar:
                pelicula.setTitulo(txtTitulo.getText().toString());
                pelicula.setDirector(txtDirector.getText().toString());
                pelicula.setDuracion(Integer.parseInt(txtDuracion.getText().toString()));
                pelicula.setFecha(new Date(calendarView.getDate()));
                pelicula.setSala(sala);
                pelicula.setClasi(age);
                pelicula.setPortada(R.drawable.sincara);
                intentResult.putExtra("pelicula", pelicula);
                setResult(RESULT_OK, intentResult);
                finish();

                break;
            case R.id.mnuCancelar:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            switch (view.getId()) {
                case R.id.rdb1:
                    age = 1;
                    break;
                case R.id.rdb2:
                    age = 2;
                    break;
                case R.id.rdb3:
                    age = 3;
                    break;
                case R.id.rdb4:
                    age = 4;
                    break;
                case R.id.rdb5:
                    age = 5;
                    break;
            }
        }
    }


}