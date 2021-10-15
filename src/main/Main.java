package main;

import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal main_win = new VentanaPrincipal();
		Controlador controlador = new Controlador(main_win);
		controlador.cambiarVisibilidad(true);
		
	}

}
