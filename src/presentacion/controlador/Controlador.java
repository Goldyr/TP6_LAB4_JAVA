package presentacion.controlador;

import presentacion.vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;


import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import entidades.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;


public class Controlador implements ActionListener, KeyListener{


	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersona pnlModificarPersona;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	
	private PersonaNegocio pNegocio;
	private ArrayList<Persona> tablaPersonas;
	private KeyEvent s;
	//private static DefaultListModel<Persona> dlmodel;
	
	
	public Controlador(VentanaPrincipal win, PersonaNegocio pNegocio)
	{
		
	this.ventanaPrincipal = win;	
	this.pNegocio = pNegocio;
	
	this.pnlAgregarPersonas = new PanelAgregarPersonas();
	this.pnlModificarPersona = new PanelModificarPersona();//(ArrayList<Persona>) pNegocio.readAll()
	this.pnlEliminarPersonas = new PanelEliminarPersonas();//(ArrayList<Persona>) pNegocio.readAll()
	this.pnlListarPersonas = new PanelListarPersonas();
	
	//Eventos menu del Frame principal llamado Ventana
	this.ventanaPrincipal.getMnAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
	this.ventanaPrincipal.getMnModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
	this.ventanaPrincipal.getMnEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
	this.ventanaPrincipal.getMnListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersonas(a));
	
	//Eventos PanelAgregarPersonas
	
	this.pnlAgregarPersonas.getBtnAgregarPersona().addActionListener(a-> EventoClick_AgregarPersonas(a));
	
	//Eventos PanelModificarPersona
	this.pnlModificarPersona.getListaPersonas().addListSelectionListener(a -> EventoSeleccionarPersona(a));
	this.pnlModificarPersona.getBtnModificarPersona().addActionListener(s -> EventoClick_ModificarPersona(s));
	//this.pnlModificarPersona.getTxfApellido().addKeyListener(null);
	//Eventos PanelEliminarPersonas
	this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPersona(s));
	
	//Eventos PanelListarPersonas
	
	}
	

	
	private void EventoClick_ModificarPersona(ActionEvent actEvent) {
		
		
		Persona mod_persona = new Persona();
		mod_persona.setDni(pnlModificarPersona.getTxfDni().getText());
		mod_persona.setApellido(pnlModificarPersona.getTxfApellido().getText());
		mod_persona.setNombre(pnlModificarPersona.getTxfNombre().getText());
		int devuelve = pNegocio.update(mod_persona);
		if(devuelve == 1) {
			JOptionPane.showMessageDialog(null, "Se modifico correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			pnlModificarPersona.setTxfNombre("");
			pnlModificarPersona.setTxfApellido("");
			pnlModificarPersona.setTxfDni("");
			//pnlModificarPersona.getListaPersonas().clearSelection();
			actualizarTabla_Modificar();
			
		}else if(devuelve == -1) {
			JOptionPane.showMessageDialog(null, "No pudo modificarse", "Error", JOptionPane.WARNING_MESSAGE);
		}else JOptionPane.showMessageDialog(null, "Los campos ingresados son incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
		
	}
	
	private void EventoSeleccionarPersona(ListSelectionEvent actEvent) {
		int valor = pnlModificarPersona.getListaPersonas().getSelectedIndex();
		Persona mod_persona = new Persona();
		mod_persona = pnlModificarPersona.getListaPersonas().getModel().getElementAt(valor);
		
		pnlModificarPersona.setTxfNombre(mod_persona.getNombre());
		pnlModificarPersona.setTxfApellido(mod_persona.getApellido());
		pnlModificarPersona.setTxfDni(mod_persona.getDni());
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
		}else mensajeOutput = "Error al agregar la persona";
	
		// Se muestra el mensaje
		this.pnlAgregarPersonas.mostrarMensaje(mensajeOutput);
		this.actualizarTabla_Eliminar();
		
	}
	
	private void EventoClickBoton_BorrarPersona(ActionEvent act) {

		int valor = pnlEliminarPersonas.getList_Eliminar().getSelectedIndex();
		if(valor >= 0) {
			if(!pNegocio.delete((Persona)pnlEliminarPersonas.getList_Eliminar().getModel().getElementAt(valor))) {
				JOptionPane.showMessageDialog(null, "No pudo eliminarse", "Error", JOptionPane.WARNING_MESSAGE);
			}
			this.actualizarTabla_Eliminar();
			JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		pnlModificarPersona.setTxfNombre("");
		pnlModificarPersona.setTxfApellido("");
		pnlModificarPersona.setTxfDni("");
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		this.actualizarTabla_Modificar();
	}
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		
		ventanaPrincipal.getContentPane().repaint();
		
		ventanaPrincipal.getContentPane().revalidate();
		this.actualizarTabla_Eliminar();
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


	private void actualizarTabla_Eliminar() {
		
		this.tablaPersonas = (ArrayList<Persona>) pNegocio.readAll();
		this.pnlEliminarPersonas.CargarList(tablaPersonas);
	}
	
	private void actualizarTabla_Modificar() {
		
		this.tablaPersonas = (ArrayList<Persona>) pNegocio.readAll();
		try {
		this.pnlModificarPersona.CargarList(tablaPersonas);
		
		}catch(Exception e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}
	
}
