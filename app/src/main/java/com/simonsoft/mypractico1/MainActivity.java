package com.simonsoft.mypractico1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.simonsoft.mypractico1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bindig=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindig.getRoot());
        tm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        bindig.btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tm.traducir(bindig.etEntra.getText().toString());
            }
        });
    }
}