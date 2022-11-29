package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton=findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Se crea el diálogo y se muestra
                DialogoAlerta dAlerta = new DialogoAlerta();
                // "Alerta" es un TAG único que identifica el diálogo
                dAlerta.show(getSupportFragmentManager(), "Alerta");
            }
        });

    }
}