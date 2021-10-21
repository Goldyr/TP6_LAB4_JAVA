package presentacion.vista;

import javax.swing.JPanel;

import entidades.Persona;
import presentacion.controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JList;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminarPersonas extends JPanel {
	
	private JButton btnEliminar;
	private JList <Persona> List_Eliminar;
	private static DefaultListModel <Persona> dlmodel_pers;
	
	public PanelEliminarPersonas(ArrayList <Persona> Persona_Eliminar ) {
		setLayout(null);
		
		JLabel lblPanelElim = new JLabel("Eliminar Usuario");
		lblPanelElim.setBounds(107, 29, 105, 14);
		add(lblPanelElim);
		
		List_Eliminar = new JList <Persona> ();
		List_Eliminar.setBounds(107, 54, 238, 185);
		add(List_Eliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(157, 250, 134, 28);
		add(btnEliminar);
		
		dlmodel_pers = new DefaultListModel <Persona> (); 
		
		CargarList(Persona_Eliminar);
		
	}
	
	public void CargarList(ArrayList <Persona> Persona_Eliminar) {
		
		dlmodel_pers.clear();
		
		for(Persona a : Persona_Eliminar) {
			dlmodel_pers.addElement(a);
		}
		
		List_Eliminar.setModel(dlmodel_pers);
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JList getList_Eliminar() {
		return List_Eliminar;
	}

	public void setList_Eliminar(JList list_Eliminar) {
		List_Eliminar = list_Eliminar;
	}
	

}
