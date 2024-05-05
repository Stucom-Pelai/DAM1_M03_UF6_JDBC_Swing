package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MainWindow implements ActionListener, KeyListener{

	private JFrame frame;
	private JButton insertPerson;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	public static int num_veces_pulsado = 0;
	public static int letras_anadidas = 0;

	private JTextField textField;
	private JButton showPersonButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 100, 745, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		insertPerson = new JButton("Insertar Nueva Persona");
		insertPerson.setBounds(107, 93, 179, 45);
		insertPerson.addActionListener(this);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(insertPerson);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(344, 16, 0, 0);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Pulse aquí 2");
		btnNewButton_1.setBounds(349, 5, 91, 23);
		btnNewButton_1.addActionListener(this);
		frame.getContentPane().add(btnNewButton_1);

		
		textField = new JTextField();
		textField.setBounds(445, 6, 96, 20);
		textField.setColumns(10);
		textField.addActionListener(this);
		textField.addKeyListener(this);
		frame.getContentPane().add(textField);
		
		showPersonButton = new JButton("MOSTRAR PERSONAS");
		showPersonButton.setBounds(108, 193, 167, 45);
		showPersonButton.addActionListener(this);
		frame.getContentPane().add(showPersonButton);


	}
	
    public void actionPerformed(ActionEvent e) {
    	//Comprobamos si seleccionamos que queremos visualizar las personas de la BBDD
    	if(e.getSource() == showPersonButton) {
    		SelectPersonView spv = new SelectPersonView(frame);
    		spv.visualize();
    	}
    	if(e.getSource() == insertPerson) {
    		//Indica si se ha pulsado este botón en ESPECÍFICO
    		num_veces_pulsado++;
    		int optionSelected = JOptionPane.showConfirmDialog(frame, "¿Está seguro de pulsar el botón de insertar?");
//    		//pane.setVisible(true);
    		if(optionSelected == 0) {
    			CreatePersonView createView = new CreatePersonView(frame);
    			//createView.initializeComponents();
    			createView.visualize();
        		lblNewLabel.setText("Se ha pulsado "+ num_veces_pulsado + " veces y se ha usado la opción YES");
    		}
    		
    	}
    	if(e.getSource() == textField) {
    		lblNewLabel.setText("Se están escribiendo palabras...");
    	}
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		letras_anadidas++;
		lblNewLabel.setText("Se están escribiendo " + letras_anadidas + " letras...");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
