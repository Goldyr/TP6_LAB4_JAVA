package presentacion.vista;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{56, 103, 33, 167, 0};
		gridBagLayout.rowHeights = new int[]{14, 20, 33, 20, 33, 20, 33, 26, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
				   	JOptionPane.showMessageDialog(null, "No ingreses numeros", "Error de formato", JOptionPane.WARNING_MESSAGE);
				   	txtNombre.setText("");
		        } 
			}
		});
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 1;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 3;
		add(lblApellido, gbc_lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
				   	JOptionPane.showMessageDialog(null, "No ingreses numeros", "Error de formato", JOptionPane.WARNING_MESSAGE);
				   	txtApellido.setText("");
		        } 
			}
		});
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.anchor = GridBagConstraints.NORTH;
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellido.gridx = 3;
		gbc_txtApellido.gridy = 3;
		add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 5;
		add(lblDni, gbc_lblDni);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
				   	JOptionPane.showMessageDialog(null, "Ingresa solo valores numericos", "Error de formato", JOptionPane.WARNING_MESSAGE);
				   	txtDni.setText("");
		        } 
			}
		});
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.anchor = GridBagConstraints.NORTH;
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 0);
		gbc_txtDni.gridx = 3;
		gbc_txtDni.gridy = 5;
		add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		
		btnAgregarPersona = new JButton("Aceptar");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAgregarPersona = new GridBagConstraints();
		gbc_btnAgregarPersona.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarPersona.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregarPersona.gridx = 1;
		gbc_btnAgregarPersona.gridy = 7;
		add(btnAgregarPersona, gbc_btnAgregarPersona);

	}
	
	public void limpiarTextFields() {
		this.txtApellido.setText("");
		this.txtDni.setText("");
		this.txtNombre.setText("");
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

}

