package com.example.pmdmejercicioexamenedu02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmdmejercicioexamenedu02.databinding.ActivityCrearContactoBinding;
import com.example.pmdmejercicioexamenedu02.modelos.ContactoMatricula;

public class CrearContactoActivity extends AppCompatActivity {

    private ActivityCrearContactoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearContactoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCrearCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.txtNombreCrear.getText().toString();
                String telefono = binding.txtTelefonoCrear.getText().toString();

                if(!nombre.isEmpty() && !telefono.isEmpty() && binding.spCicloCrear.getSelectedItemPosition() != 0){
                    ContactoMatricula cm = new ContactoMatricula(nombre, (String) binding.spCicloCrear.getSelectedItem(), telefono);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("CM", cm);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });

    }
}