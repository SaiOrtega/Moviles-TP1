package com.simonsoft.mypractico1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.simonsoft.mypractico1.databinding.ActivityMain2Binding;
import com.simonsoft.mypractico1.databinding.ActivityMainBinding;
import com.simonsoft.mypractico1.modelo.Dato;

public class MainActivityTraductor extends AppCompatActivity {
    private MainActivityViewModelTraductor tm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tm=ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModelTraductor.class);
        Intent intent = getIntent();
        String p=(String) intent.getStringExtra("palabra");
        tm.getDatoM().observe(this, new Observer<Dato>() {
            @Override
            public void onChanged(Dato dato) {
                binding.edTraducido.setText(dato.getEng());
                binding.imageView.setImageResource(dato.getFoto());
            }
        });
        tm.traducir(p);
    }
}
