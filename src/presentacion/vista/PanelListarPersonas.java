package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Persona;

import javax.swing.border.BevelBorder;

public class PanelListarPersonas extends JPanel {
	private JTable table;
	private static DefaultTableModel dlmodel_persona;
	private String[] nombreColumnas= {"Nombre", "Apellido", "Dni"};


	/**
	 * Create the panel.
	 */
	
	
	public PanelListarPersonas() {
		setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
        spPersonas.setBounds(15, 30, 383, 126);
        add(spPersonas);
        
        dlmodel_persona = new DefaultTableModel(null, nombreColumnas);
		
		table = new JTable(dlmodel_persona);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(60, 83, 286, 59);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setResizable(false);
        
        add(table);
        
        spPersonas.setViewportView(table);
        
        
	}
	

	public void llenarTabla(List<Persona> personasEnTabla) {
        this.getDlmodel_persona().setRowCount(0);
        this.getDlmodel_persona().setColumnCount(0);
        this.getDlmodel_persona().setColumnIdentifiers(this.getNombreColumnas());

        for (Persona p : personasEnTabla)
        {
            String nombre = p.getNombre();
            String apellido = p.getApellido();
            String dni = p.getDni();
            Object[] fila = {nombre, apellido, dni};
            this.getDlmodel_persona().addRow(fila);
        }
    }
	
	public static DefaultTableModel getDlmodel_persona() {
		return dlmodel_persona;
	}

	public static void setDlmodel_persona(DefaultTableModel dlmodel_persona) {
		PanelListarPersonas.dlmodel_persona = dlmodel_persona;
	}


	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}
	
	
}
