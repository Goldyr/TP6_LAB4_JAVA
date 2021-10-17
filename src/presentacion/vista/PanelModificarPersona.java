package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import entidades.Persona;

import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class PanelModificarPersona extends JPanel {
	private JTextField txfNombre;
	private JTextField txfApellido;
	private JTextField txfDni;
	private JList<Persona> listaPersonas;

	private JButton btnModificarPersona;
	public JTextField getTxfNombre() {
		return txfNombre;
	}

	public void setTxfNombre(JTextField txfNombre) {
		this.txfNombre = txfNombre;
	}

	public JTextField getTxfApellido() {
		return txfApellido;
	}

	public void setTxfApellido(JTextField txfApellido) {
		this.txfApellido = txfApellido;
	}

	public JTextField getTxfDni() {
		return txfDni;
	}

	public void setTxfDni(JTextField txfDni) {
		this.txfDni = txfDni;
	}

	public JList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(JList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public JButton getBtnModificarPersona() {
		return btnModificarPersona;
	}

	public void setBtnModificarPersona(JButton btnModificarPersona) {
		this.btnModificarPersona = btnModificarPersona;
	}

	public DefaultListModel<Persona> getDlModel() {
		return dlModel;
	}

	public void setDlModel(DefaultListModel<Persona> dlModel) {
		this.dlModel = dlModel;
	}

	private DefaultListModel <Persona> dlModel;

	public PanelModificarPersona() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 7, 430, 24);
		add(panel);
		
		JLabel lblPanelMod = new JLabel("Selecciona la pesea que desea modificar");
		panel.add(lblPanelMod);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 37, 430, 237);
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{113, 108, 1, 0, 0};
		gbl_panel_1.rowHeights = new int[]{1, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		listaPersonas = new JList<Persona>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 5;
		gbc_list.gridwidth = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		panel_1.add(listaPersonas, gbc_list);
		
		txfNombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 5;
		panel_1.add(txfNombre, gbc_textField);
		txfNombre.setColumns(10);
		
		txfApellido = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panel_1.add(txfApellido, gbc_textField_1);
		txfApellido.setColumns(10);
		
		txfDni = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		panel_1.add(txfDni, gbc_textField_2);
		txfDni.setColumns(10);
		
		btnModificarPersona = new JButton("Modificar");
	
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 5;
		
		panel_1.add(btnModificarPersona, gbc_btnNewButton);

	}
}
