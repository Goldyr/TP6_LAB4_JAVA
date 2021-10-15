package presentacion.vista;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JButton btnAgregarPersona;


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}


	public void setBtnAgregarPersona(JButton btnAgregarPersona) {
		this.btnAgregarPersona = btnAgregarPersona;
	}


	public PanelAgregarPersonas() {
		

		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(39, 41, 61, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(167, 38, 162, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(39, 94, 61, 14);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(167, 91, 162, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(39, 147, 42, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(167, 144, 162, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAgregarPersona = new JButton("Aceptar");
		btnAgregarPersona.setBounds(63, 197, 71, 23);
		add(btnAgregarPersona);

	}
	


}
