package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.PersonaController;
import model.Persona;
import utils.Utils;

import java.awt.Font;
import javax.swing.ImageIcon;

public class CreatePersonView implements ActionListener {
	PersonaController personaController;
	JDialog ventanaInsertPerson;
	JFrame framePadre;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton insertarButton;
	private JButton cancelarButton;
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JLabel lblNewLabel_2;
	private JTextField dniTextField;

	public CreatePersonView(JFrame frame) {
		//Ajuste de la ventana en el constructor
		ventanaInsertPerson = new JDialog(frame);
		personaController = new PersonaController();
		framePadre = frame;
		ventanaInsertPerson.setBounds(frame.getBounds());
		ventanaInsertPerson.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(66, 118, 64, 17);
		ventanaInsertPerson.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(66, 153, 64, 17);
		ventanaInsertPerson.getContentPane().add(lblNewLabel_1);

		insertarButton = new JButton("Insertar");
		insertarButton.setBounds(229, 205, 89, 23);
		insertarButton.addActionListener(this);

		ventanaInsertPerson.getContentPane().add(insertarButton);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setBounds(70, 205, 89, 23);
		cancelarButton.addActionListener(this);
		ventanaInsertPerson.getContentPane().add(cancelarButton);

		nombreTextField = new JTextField();
		nombreTextField.setBounds(140, 119, 206, 20);
		ventanaInsertPerson.getContentPane().add(nombreTextField);
		nombreTextField.setColumns(10);

		apellidoTextField = new JTextField();
		apellidoTextField.setColumns(10);
		apellidoTextField.setBounds(140, 150, 206, 20);
		ventanaInsertPerson.getContentPane().add(apellidoTextField);

		lblNewLabel_2 = new JLabel("Inserción de una persona");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_2.setBounds(94, 22, 252, 30);
		ventanaInsertPerson.getContentPane().add(lblNewLabel_2);
		
		dniTextField = new JTextField();
		dniTextField.setColumns(10);
		dniTextField.setBounds(140, 74, 206, 20);
		ventanaInsertPerson.getContentPane().add(dniTextField);
		
		JLabel dniLabel = new JLabel("DNI");
		dniLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dniLabel.setBounds(66, 77, 64, 17);
		ventanaInsertPerson.getContentPane().add(dniLabel);
	}

	public void initializeComponents() {

	}

	public void visualize() {
		framePadre.setVisible(false);
		ventanaInsertPerson.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == insertarButton) {
			// He pulsado el botón insertar
			String dni = dniTextField.getText();

			String nombre = nombreTextField.getText();
			String apellidos = apellidoTextField.getText();

			if (nombre == "" || apellidos == "" || nombre.length() < 2 || apellidos.length() < 2
					|| Utils.isNumeric(apellidos) || Utils.isNumeric(nombre)) {
				JOptionPane.showMessageDialog(ventanaInsertPerson,
						"ERROR: HA INTRODUCIDO MAL LOS DATOS DE LA PERSONA, POR FAVOR VUELVA A INTRODUCIRLOS",
						"Error de Inserción", JOptionPane.ERROR_MESSAGE);
				
			} else {
				Persona p = new Persona(dni, nombre, apellidos);
				this.personaController.addPersona(p);
				nombreTextField.setEditable(false);
				apellidoTextField.setEditable(false);

			}

		}
		if (e.getSource() == cancelarButton) {
			// He pulsado el botón cancelar
			ventanaInsertPerson.setVisible(false);
			framePadre.setVisible(true);
		}
	}
}
