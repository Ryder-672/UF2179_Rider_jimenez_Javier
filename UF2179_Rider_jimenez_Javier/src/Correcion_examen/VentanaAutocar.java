package Correcion_examen;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;



import Ejercicio2.Autocar;

public class VentanaAutocar extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textKm;
	private JTextField textModelo;
	private JTextField textPlazas;

	
	private JTextArea textAreaResultado;
	private JTable tablaAutocar;
	// Creas la lista, pero no la incializas
	private List<Autocar> listaAutocares;
	private JButton btnInsertar;
	private JButton btnMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocar frame = new VentanaAutocar();
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
	@SuppressWarnings("serial")
	public VentanaAutocar() {
		
		
		
		this.listaAutocares = new ArrayList<Autocar>();
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][92.00,grow][grow][][49.00][]", "[][][][][][30.00][][43.00][grow][][][122.00]"));
		
		JLabel lblNewLabel = new JLabel("Gestion autocares");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel, "cell 0 0 3 1");
		
		JLabel lblNewLabel_1 = new JLabel("Matricula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		textMatricula = new JTextField();
		textMatricula.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(textMatricula, "cell 2 1,growx");
		textMatricula.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marca");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_1, "cell 1 2,alignx trailing");
		
		textMarca = new JTextField();
		textMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		textMarca.setColumns(10);
		contentPane.add(textMarca, "cell 2 2,growx");
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Modelo");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_1, "cell 3 2,alignx trailing");
		
		textModelo = new JTextField();
		textModelo.setHorizontalAlignment(SwingConstants.TRAILING);
		textModelo.setColumns(10);
		contentPane.add(textModelo, "cell 4 2 2 1,growx");
		
		JLabel lblNewLabel_1_2 = new JLabel("Kilometros");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2, "cell 1 3,alignx trailing");
		
		textKm = new JTextField();
		textKm.setHorizontalAlignment(SwingConstants.TRAILING);
		textKm.setColumns(10);
		contentPane.add(textKm, "cell 2 3,growx");
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Plazas");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_2_2, "cell 3 3,alignx trailing");
		
		textPlazas = new JTextField();
		textPlazas.setText("30");
		textPlazas.setHorizontalAlignment(SwingConstants.TRAILING);
		textPlazas.setColumns(10);
		contentPane.add(textPlazas, "cell 4 3,growx");
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		contentPane.add(btnInsertar, "cell 2 4,alignx center");
		
		btnMostrar = new JButton("Mostrar datos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
				
			}
		});
		contentPane.add(btnMostrar, "cell 3 4");
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 8 6 1,grow");
		
		tablaAutocar = new JTable();
		scrollPane.setViewportView(tablaAutocar);
		tablaAutocar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "Marca", "Kilometros", "Modelo", "plazas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, int.class, int.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaAutocar.getColumnModel().getColumn(2).setPreferredWidth(153);
	}

	protected void insertar() {
	
		// no haces ninguna validación de datos
		String matricula = textMatricula.getText();
		String marca = textMarca.getText();
		String modelo = textModelo.getText();
		
		// no controlas que los números sean correcto o estén limitados a 80 por ejemplo
		int km = Integer.parseInt(textKm.getText());
		int num_plazas = Integer.parseInt(textPlazas.getText());

		
		Autocar a = new Autocar(matricula, marca , modelo, km, num_plazas);
		
		// no funciona porque la lista no está inicilizada
		if (!listaAutocares.contains(a)) {
			listaAutocares.add(a);
		}
		

		//mostrarDatos();

	}


protected void mostrarDatos() {

	DefaultTableModel listaAutocar  = (DefaultTableModel) 					tablaAutocar.getModel();
	// no funciona porque la lista no está incializada
	listaAutocar.setRowCount(0);
	for (Autocar autocar : listaAutocares ) {

		Object fila [] = {
				autocar.getMatricula(), autocar.getModelo(), 
				autocar.getmarca(), autocar.getKilometros(),
				autocar.getNum_plazas()
		};
		listaAutocar.addRow(fila);
	}

}
	

}
