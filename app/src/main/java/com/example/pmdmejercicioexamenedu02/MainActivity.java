package com.example.pmdmejercicioexamenedu02;

import android.content.Intent;
import android.os.Bundle;

import com.example.pmdmejercicioexamenedu02.adapters.ContactosAdapter;
import com.example.pmdmejercicioexamenedu02.modelos.ContactoMatricula;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.pmdmejercicioexamenedu02.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private List<ContactoMatricula> contactosMatriculaLista;
    private ActivityResultLauncher<Intent> crearLauncher;

    private ContactosAdapter adapter;
    private RecyclerView.LayoutManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

       contactosMatriculaLista = new ArrayList<>();

       adapter = new ContactosAdapter(contactosMatriculaLista, R.layout.contacto_view_holder, this);
       lm = new GridLayoutManager(this, 2);
       binding.contentMain.contenedor.setAdapter(adapter);
       binding.contentMain.contenedor.setLayoutManager(lm);


       crearLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
           @Override
           public void onActivityResult(ActivityResult result) {
               if(result.getResultCode()== RESULT_OK){
                   if(result.getData().getExtras() != null){
                       ContactoMatricula cm = (ContactoMatricula) result.getData().getExtras().getSerializable("CM");
                       contactosMatriculaLista.add(cm);
                       adapter.notifyItemInserted(contactosMatriculaLista.size() -1);
                   }
               }
           }
       });


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearLauncher.launch(new Intent(MainActivity.this, CrearContactoActivity.class));
            }
        });
    }

}