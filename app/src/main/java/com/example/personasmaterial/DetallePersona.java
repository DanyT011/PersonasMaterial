package com.example.personasmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView cedula, nombre, apellido;
    private ImageView foto;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        String ced, nom, apell;
        foto = findViewById(R.id.imgFotoDetalle);
        cedula = findViewById(R.id.txtCedulaDetalle);
        nombre = findViewById(R.id.txtNombreDetalle);
        apellido = findViewById(R.id.txtApellidoDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        ced = bundle.getString("cedula");
        nom = bundle.getString("nombre");
        apell = bundle.getString("apellido");

        cedula.setText(ced);
        nombre.setText(nom);
        apellido.setText(apell);


    }
}