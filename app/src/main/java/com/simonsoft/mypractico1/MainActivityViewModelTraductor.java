package com.simonsoft.mypractico1;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simonsoft.mypractico1.modelo.Dato;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModelTraductor extends AndroidViewModel {
private Context context;
private MutableLiveData<Dato> datoMutableLiveData;
private List<Dato> diccionario = new ArrayList<>();

    public MainActivityViewModelTraductor(@NonNull Application application) {

        super(application);
        cargarPalabras();
        this.context=getApplication().getApplicationContext();
    }

    public LiveData<Dato> getDatoM(){
        if (datoMutableLiveData == null){
            datoMutableLiveData = new MutableLiveData<Dato>();
        }
        return datoMutableLiveData;
    }

    public void cargarPalabras(){
        diccionario.add(new Dato("triangulo","triangle",R.drawable.triangulo));
        diccionario.add(new Dato("ovalo","oval",R.drawable.ovalo));
        diccionario.add(new Dato("pentágono","pentagon",R.drawable.pentagono));
        diccionario.add(new Dato("semicirculo","semicircle",R.drawable.semicirculo));
        diccionario.add(new Dato("trapecio","trapeze",R.drawable.trapecio));
    }
    public void traducir(String texto){
        int e=0;Dato encontrado= null;

        for(Dato palabra: diccionario){
            if (palabra.getEsp().equalsIgnoreCase(texto)){
               e++;
               encontrado= palabra;
                break;
            }
        }
        if (e !=0){
            datoMutableLiveData.setValue(encontrado);
        } else{
            Toast.makeText(context, "La palabra no se encuentra", Toast.LENGTH_LONG).show();
        }
    }

}
