package UF2179_RomeraMata_AndresAlejandro_Ej1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UF2179_RomeraMata_AndresAlejandro_Ej1 extends JFrame {

	private JPanel contentPane;
	private JTextField textOrigen;
	private JTextField textDestino;
	private JTextField textPeso;
	private final ButtonGroup Origen = new ButtonGroup();
	private final ButtonGroup Destino = new ButtonGroup();
	private JRadioButton rdbtnNacionalDestino;
	private JRadioButton rdbtnNacionalOrigen;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UF2179_RomeraMata_AndresAlejandro_Ej1 frame = new UF2179_RomeraMata_AndresAlejandro_Ej1();
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
	public UF2179_RomeraMata_AndresAlejandro_Ej1() {
		
		setTitle("Calculadora de envios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][]", "[][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Calculadora de Envíos");
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel, "cell 0 0 3 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Origen: ");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx left");
		
		textOrigen = new JTextField();
		contentPane.add(textOrigen, "cell 1 1 2 1,growx");
		textOrigen.setColumns(10);
		
		rdbtnNacionalOrigen = new JRadioButton("Nacional");
		rdbtnNacionalOrigen.setSelected(true);
		Origen.add(rdbtnNacionalOrigen);
		contentPane.add(rdbtnNacionalOrigen, "cell 1 2");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Extranjero");
		Origen.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1, "cell 2 2");
		
		JLabel lblNewLabel_2 = new JLabel("Ciudad Destino: ");
		contentPane.add(lblNewLabel_2, "cell 0 3,alignx left");
		
		textDestino = new JTextField();
		contentPane.add(textDestino, "cell 1 3 2 1,growx");
		textDestino.setColumns(10);
		
		rdbtnNacionalDestino = new JRadioButton("Nacional");
		rdbtnNacionalDestino.setSelected(true);
		Destino.add(rdbtnNacionalDestino);
		contentPane.add(rdbtnNacionalDestino, "cell 1 4");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Extranjero");
		Destino.add(rdbtnNewRadioButton_3);
		contentPane.add(rdbtnNewRadioButton_3, "cell 2 4");
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de envío: ");
		contentPane.add(lblNewLabel_3, "cell 0 5,alignx left");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10h", "Paq 14 - Antes de las 14h", "Paq24 - Al día siguiente"}));
		contentPane.add(comboBox, "cell 1 5 2 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Peso: ");
		contentPane.add(lblNewLabel_4, "cell 0 6");
		
		textPeso = new JTextField();
		contentPane.add(textPeso, "cell 1 6 2 1,growx");
		textPeso.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular Precio");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario formulario=new Formulario();
				if(validarCampos()) {
				formulario=recogerDatos();
				tiket(formulario);
				}
			}
		});
		contentPane.add(btnCalcular, "cell 1 7");
	}




	protected boolean validarCampos() {
		if(textOrigen.getText()==null || textOrigen.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca un lugar de origen valido", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textDestino.getText()==null || textDestino.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca un lugar de destino valido", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textPeso.getText()==null || textPeso.getText().isBlank()) {
			JOptionPane.showMessageDialog(contentPane, "Introduzca un lugar de peso valido", "ERROR", JOptionPane.WARNING_MESSAGE);
			return false;
		} else return true;
	}
	
	protected Formulario recogerDatos() {
		Formulario f = new Formulario();
		
		f.origen=textOrigen.getText();
		f.nacDes=rdbtnNacionalOrigen.getText();
		f.destino=textDestino.getText();
		f.nacDes=rdbtnNacionalDestino.getText();
		f.envio=(String) comboBox.getSelectedItem();
		f.peso=Double.parseDouble((String) textPeso.getText());
		
		return f;
	}

	protected double calculoImporte() {
		double total=0;
		double impBase;
		double tarifa;
		int recargo;
		if (rdbtnNacionalOrigen.isSelected() && rdbtnNacionalDestino.isSelected()) {
			impBase=4;
		} else impBase=7;
		
		if (comboBox.getSelectedIndex()==0) {
			tarifa=5;
		} else if(comboBox.getSelectedIndex()==1) {
			tarifa=2;
		}else tarifa=0;
		
		int peso=Integer.parseInt(textPeso.getText());
		recargo =peso/10;
		
		total=impBase+tarifa+recargo;
		
		return total;
	}
	protected void tiket(Formulario formulario) {
		JOptionPane.showMessageDialog(contentPane, formulario.toString()+"Importe: "+calculoImporte(),"Cálculo",JOptionPane.INFORMATION_MESSAGE);
		
	}
}
