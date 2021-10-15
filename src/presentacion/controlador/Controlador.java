package presentacion.controlador;

import presentacion.vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;


public class Controlador implements ActionListener{

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersona pnlModificarPersona;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	
	
	public Controlador(VentanaPrincipal win)
	{
		
	this.ventanaPrincipal = win;	
	
	this.pnlAgregarPersonas = new PanelAgregarPersonas();
	this.pnlModificarPersona = new PanelModificarPersona();
	this.pnlEliminarPersonas = new PanelEliminarPersonas();
	this.pnlListarPersonas = new PanelListarPersonas();
	
	//Eventos menu del Frame principal llamado Ventana
	this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	this.ventanaPrincipal.getMnModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
	this.ventanaPrincipal.getMnEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
	this.ventanaPrincipal.getMnListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));

	}
	
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	public void EventoClickMenu_AbrirPanel_ListarPersonas(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	
	public void cambiarVisibilidad(boolean bool)
	{
		this.ventanaPrincipal.setVisible(bool);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
