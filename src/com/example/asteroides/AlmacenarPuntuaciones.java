package com.example.asteroides;

import java.util.Vector;

public interface AlmacenarPuntuaciones {
	
	public void guardarPuntuacion(int puntos, String nombre, long fecha);
	
	public Vector<String> listaPuntuaciones(int cantidad);

}
