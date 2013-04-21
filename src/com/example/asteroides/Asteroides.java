package com.example.asteroides;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Asteroides extends Activity {
	
	public static AlmacenPuntuacionesPreferencias almacen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        almacen = new AlmacenPuntuacionesPreferencias(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.acercaDe:
    		lanzarAcercaDe(null);
    		break;
    	case R.id.config:
    		lanzarPreferencias(null);
    		break;
    	}
    	return true;
    }
    
	public void lanzarAcercaDe(View view) {
		Intent i = new Intent(this, AcercaDe.class);
		startActivity(i);
	}
	
	public void lanzarPreferencias(View view) {
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}
	
	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}
	
	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivityForResult(i, 1234);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1234 & resultCode==RESULT_OK & data!=null) {
			int puntuacion = data.getExtras().getInt("puntuacion");
			String nombre = "Yo";
			// Mejor leerlo desde un Dialog o una nueva actividad                       //AlertDialog.Builder
			almacen.guardarPuntuacion(puntuacion, nombre,
					System.currentTimeMillis());
			lanzarPuntuaciones(null);
		}
	}
	
	public void exit(View view) {
		finish();
	}
    
}
