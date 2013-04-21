package com.example.asteroides;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Juego extends Activity {
	private VistaJuego vistaJuego;
	private MediaPlayer mp;
	
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);
		vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
		
		mp = MediaPlayer.create(this, R.raw.audio);
		mp.start();
		
		vistaJuego.setPadre(this);
	}
	
	@Override protected void onPause() {
		super.onPause();
		vistaJuego.getThread().pausar();
	}

	@Override protected void onResume() {
		super.onResume();
		vistaJuego.getThread().reanudar();
	}

	@Override protected void onDestroy() {
		vistaJuego.getThread().detener();
		super.onDestroy();
		mp.pause();
	}
	
	protected void onSaveInstanceState(Bundle estadoGuardado) {
		super.onSaveInstanceState(estadoGuardado);
		if (mp != null) {
			int pos = mp.getCurrentPosition();
			estadoGuardado.putInt("posicion", pos);
		}
	}
	
	protected void onRestoreInstanceState(Bundle estadoGuardado) {
		super.onRestoreInstanceState(estadoGuardado);
		if (estadoGuardado != null && mp != null) {
			int pos = estadoGuardado.getInt("posicion");
			mp.seekTo(pos);
		}
	}
}
