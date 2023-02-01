package Correcion_examen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UF2179_Rider_jimenez_Javier_EJ1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private final ButtonGroup Origen = new ButtonGroup();
	private final ButtonGroup Destino = new ButtonGroup();
	private JTextField textFieldPeso;
	private JButton btnCalcular;
	private JRadioButton rdbtnNacionalOri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UF2179_Rider_jimenez_Javier_EJ1 frame = new UF2179_Rider_jimenez_Javier_EJ1();
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
	public UF2179_Rider_jimenez_Javier_EJ1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][grow][]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Calculadora de Envios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel, "cell 0 0 5 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Ciudad Origen:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 1");
		
		textFieldOrigen = new JTextField();
		contentPane.add(textFieldOrigen, "cell 2 1 2 1,growx");
		textFieldOrigen.setColumns(10);
		
		rdbtnNacionalOri = new JRadioButton("Nacional");
		Origen.add(rdbtnNacionalOri);
		contentPane.add(rdbtnNacionalOri, "cell 2 2");
		
		JRadioButton rdbtnExtrangeroOri = new JRadioButton("Extrangero");
		Origen.add(rdbtnExtrangeroOri);
		contentPane.add(rdbtnExtrangeroOri, "cell 3 2");
		
		JLabel lblNewLabel_1_1 = new JLabel("Ciudad Desino:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1, "cell 1 3,alignx trailing");
		
		textFieldDestino = new JTextField();
		textFieldDestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldDestino.setColumns(10);
		contentPane.add(textFieldDestino, "cell 2 3 2 1,growx");
		
		JRadioButton rdbtnNacionalDesti = new JRadioButton("Nacional");
		Destino.add(rdbtnNacionalDesti);
		contentPane.add(rdbtnNacionalDesti, "cell 2 4");
		
		JRadioButton rdbtnExtrangeroDesti = new JRadioButton("Extrangero");
		Destino.add(rdbtnExtrangeroDesti);
		contentPane.add(rdbtnExtrangeroDesti, "cell 3 4");
		
		JLabel lblNewLabel_1_2 = new JLabel("Tipo de envio:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_2, "cell 1 5,alignx trailing");
		
		// No has marcado por defecto la opción de Nacional en ambos JRadioButtons
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Antes de las 10h", "Paq 14 - Antes de las 14h", "Paq 24 - Al dia siguiente"}));
		contentPane.add(comboBox, "cell 2 5 2 1,growx");
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Peso:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_2_1, "cell 1 6,alignx trailing");
		
		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPeso.setColumns(10);
		contentPane.add(textFieldPeso, "cell 2 6,growx");
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Kg");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_2_1_1, "cell 3 6");
		
		btnCalcular = new JButton("Calcular Precio");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int peso = Integer.parseInt(textFieldPeso.getText());
				// ciudadOri y ciudadDesti contienen representaciones del objeto JRadioButton
				// no su nombre, no te sirven.
				String ciudadOri = Origen.getSelection().toString();
				String ciudadDesti = Destino.getSelection().toString();
				double importe = 0.0;
				
				
				
				// Recoges bien los datos de las ciudades, pero no validas si vienen vacíos, tampoco validas el 
				// peso
				String origen = textFieldOrigen.getText();
				String destino = textFieldDestino.getText();

				
				String paq = (String) comboBox.getSelectedItem();
				
				// esto no es correcto, porque estás comparando sus representaciones toString, además lo que deberías 
				// comprobar es que los dos botones son Nacional, no que sean iguales
				if (ciudadOri.equals(ciudadDesti)){
					
					switch (paq) {
					case "Paq 10 - Antes de las 10h": importe = importe + 5; break;
					case "Paq 14 - Antes de las 14h": importe = importe + 2; break;
					case "Paq 24 - Al dia siguiente": ; break; // si no vas a hacer nada en este case, no lo pongas
					}
					
					// lo mismo con este if no haces nada aquí, y es código espageti. Si te hubiese pedido llegar hasta 
					// 8700 kg esarías todavía escribiendo código. Además, no funciona, si es mayor de 10 (20, 30 o lo que sea
					// siempre entra por el primer if y tienes un caso repetido
					if (peso<10 && peso>0) {
						
					}else if (peso>=10) {
						importe = importe + 3.5;
					}else if (peso>=20) {
						importe = importe + 7 ;
					}else if (peso>=30) {
						importe = importe + 10.5 ;
					}else if (peso>=30) {
						importe = importe + 14 ;
					}else {
						JOptionPane.showMessageDialog(null, "Peso no acceptado");
					}
					
					importe = importe + 4;
					
					// El mensaje no muestra los datos correctamente, ni el calculo correcto
					JOptionPane.showMessageDialog(null, "Origen: " + ciudadOri + " Destino: " + ciudadDesti + 
							" Tipo: " + paq + "  Peso: " + peso + " Importe: " + importe +"€") ;
					
				}else {
					// repetición de código innecesaria para sumar sólo 7 en lugar de 4 y con los mismos problemas 
					// que la anterior
					switch (paq) {
					case "Paq 10 - Antes de las 10h": importe = importe + 5; break;
					case "Paq 14 - Antes de las 14h": importe = importe + 2; break;
					case "Paq 24 - Al dia siguiente": ; break;
					}
					if (peso<10 && peso>0) {
						
					}else if (peso>=10) {
						importe = importe + 3.5;
					}else if (peso>=20) {
						importe = importe + 7 ;
					}else if (peso>=30) {
						importe = importe + 10.5 ;
					}else if (peso>=30) {
						importe = importe + 14 ;
					}else {
						JOptionPane.showMessageDialog(null, "Peso no acceptado");
					}
					
					importe = importe + 7;
					
					JOptionPane.showMessageDialog(null, "Origen: " + ciudadOri + " Destino: " + ciudadDesti + 
							" Tipo: " + paq + "  Peso: " + peso + " Importe: " + importe +"€") ;
				}
				
				
			}
		});
		contentPane.add(btnCalcular, "cell 1 8 3 1,alignx center");
	}

}
