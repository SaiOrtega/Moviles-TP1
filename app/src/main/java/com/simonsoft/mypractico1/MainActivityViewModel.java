package com.simonsoft.mypractico1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
    public void traducir(String palabra){

        if (palabra.equals("")){
            Toast.makeText(context, "Debe ingresar una palabra", Toast.LENGTH_LONG).show();
        }else {
            Intent intent= new Intent(context, MainActivityTraductor.class);
            intent.putExtra("palabra",palabra);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
