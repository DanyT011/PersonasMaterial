package com.example.personasmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class CrearPersona extends AppCompatActivity {
    private EditText cedula, nombre, apellido;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
    }

    public void guardar(View v){
        String ced, nom, apell, id;
        Persona p;
        InputMethodManager imp;

        ced = cedula.getText().toString();
        nom = nombre.getText().toString();
        apell = apellido.getText().toString();
        imp = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        p = new Persona(ced, nom, apell, "");
        p.guardar();

        imp.hideSoftInputFromWindow(cedula.getWindowToken(),0);
        limpiar();
        Snackbar.make(v, R.string.persona_guardada,Snackbar.LENGTH_LONG).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearPersona.this, MainActivity.class);
        startActivity(i);
    }
}