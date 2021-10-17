package main;

import daoImpl.Conexion;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal main_win = new VentanaPrincipal();
		PersonaNegocio pNegocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(main_win, pNegocio);
		controlador.cambiarVisibilidad(true);
		Conexion cn = new Conexion();
	
	}

}
