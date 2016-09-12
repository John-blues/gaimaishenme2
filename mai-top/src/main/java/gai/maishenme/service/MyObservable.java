package gai.maishenme.service;

import java.util.Observable;

import android.content.Context;

public class MyObservable extends Observable{
    
    public void showDialog(Context context){
        setChanged();
        notifyObservers(context);
    }
}
