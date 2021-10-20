package presentacion.controlador;

import presentacion.vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidades.Persona;
import negocio.PersonaNegocio;
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
	
	private PersonaNegocio pNegocio;
	private ArrayList<Persona> tablaPersonas;
	//private static DefaultListModel<Persona> dlmodel;
	
	
	public Controlador(VentanaPrincipal win, PersonaNegocio pNegocio)
	{
		
	this.ventanaPrincipal = win;	
	this.pNegocio = pNegocio;
	
	this.pnlAgregarPersonas = new PanelAgregarPersonas();
	this.pnlModificarPersona = new PanelModificarPersona();
	this.pnlEliminarPersonas = new PanelEliminarPersonas((ArrayList<Persona>) pNegocio.readAll());
	this.pnlListarPersonas = new PanelListarPersonas();
	
	//Eventos menu del Frame principal llamado Ventana
	this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	this.ventanaPrincipal.getMnModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
	this.ventanaPrincipal.getMnEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
	this.ventanaPrincipal.getMnListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	
	//Eventos PanelAgregarPersonas
	
	this.pnlAgregarPersonas.getBtnAgregarPersona().addActionListener(a-> EventoClick_AgregarPersonas(a));
	
	//Eventos PanelModificarPersona
	
	//Eventos PanelEliminarPersonas
	this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPersona(s));
	
	//Eventos PanelListarPersonas
	
	}
	
	private void EventoClick_AgregarPersonas(ActionEvent actEvent) {
		
		String dniPersona = this.pnlAgregarPersonas.getTxtDni().getText();
		String nombrePersona = this.pnlAgregarPersonas.getTxtNombre().getText();
		String apellidoPersona = this.pnlAgregarPersonas.getTxtApellido().getText();
		
		Persona nuevaPersona = new Persona(dniPersona, nombrePersona, apellidoPersona);
		
		int estadoInsert = pNegocio.insert(nuevaPersona);
		String mensajeOutput = "La persona se agrego a la base de datos correctamente";
		
		if(estadoInsert == 1) {
			pnlAgregarPersonas.limpiarTextFields();
		}
		else if (estadoInsert == 0){
			mensajeOutput = "Error al agregar la persona, verifique los campos";
		}
		else if (estadoInsert == -1){
			mensajeOutput = "El DNI ya se encuentra registrado";
		}
	
		// Se muestra el mensaje
		this.pnlAgregarPersonas.mostrarMensaje(mensajeOutput);
		this.actualizarTabla();
		
	}
	
	private void EventoClickBoton_BorrarPersona(ActionEvent act) {

		int valor = pnlEliminarPersonas.getList_Eliminar().getSelectedIndex();
		if(valor >= 0) {
			if(!pNegocio.delete((Persona)pnlEliminarPersonas.getList_Eliminar().getModel().getElementAt(valor))) {
				JOptionPane.showMessageDialog(null, "No pudo eliminarse", "Error", JOptionPane.WARNING_MESSAGE);
			}
			this.actualizarTabla();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Aviso", JOptionPane.WARNING_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "No pudo eliminarse", "Error", JOptionPane.WARNING_MESSAGE);
		}
			
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
		this.actualizarTabla();
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


	private void actualizarTabla() {
		
		this.tablaPersonas = (ArrayList<Persona>) pNegocio.readAll();
		this.pnlEliminarPersonas.CargarList(tablaPersonas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
