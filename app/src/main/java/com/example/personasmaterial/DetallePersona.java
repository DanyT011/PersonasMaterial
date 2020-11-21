package com.example.personasmaterial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class DetallePersona extends AppCompatActivity {
    private TextView cedula, nombre, apellido;
    private ImageView foto;
    private Intent intent;
    private Bundle bundle;
    private StorageReference storageReference;
    private Persona p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        String ced, nom, apell, id;
        foto = findViewById(R.id.imgFotoDetalle);
        cedula = findViewById(R.id.txtCedulaDetalle);
        nombre = findViewById(R.id.txtNombreDetalle);
        apellido = findViewById(R.id.txtApellidoDetalle);
        storageReference = FirebaseStorage.getInstance().getReference();

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        ced = bundle.getString("cedula");
        nom = bundle.getString("nombre");
        apell = bundle.getString("apellido");
        id = bundle.getString("id");

        storageReference.child(id).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(foto);
            }
        });

        cedula.setText(ced);
        nombre.setText(nom);
        apellido.setText(apell);

    }

    public void eliminar(View v){
        String positivo, negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar Persona");
        builder.setMessage("¿Está seguro de eliminar esta persona");
        positivo = "Si";
        negativo = "No";

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetallePersona.this, MainActivity.class);
        startActivity(intent);
    }
}