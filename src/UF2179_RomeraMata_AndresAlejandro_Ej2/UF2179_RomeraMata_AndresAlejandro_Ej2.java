package UF2179_RomeraMata_AndresAlejandro_Ej2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;

public class UF2179_RomeraMata_AndresAlejandro_Ej2 extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textKm;
	private JTextField textModelo;
	private ArrayList<Autocar>autobus;
	private JComboBox comboBox;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UF2179_RomeraMata_AndresAlejandro_Ej2 frame = new UF2179_RomeraMata_AndresAlejandro_Ej2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UF2179_RomeraMata_AndresAlejandro_Ej2() {
		this.autobus=new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Gestión autocares");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel, "cell 0 0 4 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Matricula");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textMatricula = new JTextField();
		contentPane.add(textMatricula, "cell 1 1,growx");
		textMatricula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Marca");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textMarca = new JTextField();
		contentPane.add(textMarca, "cell 1 2,growx");
		textMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		contentPane.add(lblModelo, "cell 2 2,alignx left");
		
		textModelo = new JTextField();
		contentPane.add(textModelo, "cell 3 2,growx");
		textModelo.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Kilometros");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		textKm = new JTextField();
		contentPane.add(textKm, "cell 1 3,growx");
		textKm.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Plazas");
		contentPane.add(lblNewLabel_5, "cell 2 3,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80"}));
		comboBox.setSelectedIndex(29);
		contentPane.add(comboBox, "cell 3 3,growx");
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autocar a=new Autocar();
				if (validarCampos()) {
					autobus=insertarDatos(a);
				}
			}
		});
		contentPane.add(btnInsertar, "cell 1 4,alignx right");
		
		JButton btnMostrar = new JButton("Mostrar Datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
		contentPane.add(btnMostrar, "cell 2 4 2 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 4 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Matricula", "Marca", "Modelo", "Plazas", "Kilometros"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}



	protected boolean validarCampos() {
		if(textKm.getText()==null || textKm.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca unos Kilometros validos", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textMarca.getText()==null || textMarca.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca una marca valida", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textMatricula.getText()==null || textMatricula.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca una matricula valida", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textModelo.getText()==null || textModelo.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca un modelo valido", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else return true;
	}
	
	protected ArrayList<Autocar> insertarDatos(Autocar au) {
		ArrayList<Autocar>autobus = null;
		au.matricula=textMatricula.getText();
		au.marca=textMarca.getText();
		au.modelo=textModelo.getText();
		au.kilometros=Integer.parseInt(textKm.getText());
		au.num_plazas=Integer.parseInt((String)comboBox.getSelectedItem());
		
		this.autobus.add(au);
		return autobus;
	}
	protected void mostrarDatos() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		
		for (Autocar autocar : autobus) {
			Object fila[]= {
					autocar.getMatricula(),
					autocar.getMarca(),
					autocar.getModelo(),
					autocar.getNum_plazas(),
					autocar.getKilometros()
			};
			modelo.addRow(fila);
		}
		
	}
}
