package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PersonaController;
import model.Persona;
import utils.Utils;
import javax.swing.JComboBox;
import java.awt.Color;

public class SelectPersonView implements ActionListener {
	PersonaController personaController;
	JDialog ventanaSelectPerson;
	JFrame framePadre;
	private JButton cancelarButton;
	private JComboBox selectPersonsList;
	private JLabel dniShowLabel;
	private JLabel nombreShowLabel;
	private JLabel apellidoShowLabel;
	private JLabel dniFixedLabel;
	private JLabel lblNombre;
	private JLabel lblApellido;
	public SelectPersonView(JFrame frame) {
		// Ajuste de la ventana en el constructor
		ventanaSelectPerson = new JDialog(frame);
		personaController = new PersonaController();
		framePadre = frame;
		ventanaSelectPerson.setBounds(frame.getBounds());
		ventanaSelectPerson.getContentPane().setLayout(null);

		cancelarButton = new JButton("Volver");
		cancelarButton.setBounds(170, 218, 89, 23);
		cancelarButton.addActionListener(this);
		ventanaSelectPerson.getContentPane().add(cancelarButton);
		String[] personasTextoComboBox = loadPersonFromDB();
		System.out.println(Arrays.toString(personasTextoComboBox));
		selectPersonsList = new JComboBox(personasTextoComboBox);
		selectPersonsList.setBounds(92, 53, 234, 22);
		selectPersonsList.addActionListener(this);
		ventanaSelectPerson.getContentPane().add(selectPersonsList);
		
		JLabel personSelectHeadLabel = new JLabel("Seleccione la persona...");
		personSelectHeadLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		personSelectHeadLabel.setBounds(99, 0, 268, 48);
		ventanaSelectPerson.getContentPane().add(personSelectHeadLabel);
		
		dniShowLabel = new JLabel("New label");
		dniShowLabel.setVisible(false);
		dniShowLabel.setBounds(170, 103, 76, 23);
		ventanaSelectPerson.getContentPane().add(dniShowLabel);
		
		nombreShowLabel = new JLabel("New label");
		nombreShowLabel.setVisible(false);
		nombreShowLabel.setBounds(170, 123, 129, 48);
		ventanaSelectPerson.getContentPane().add(nombreShowLabel);
		
		apellidoShowLabel = new JLabel("New label");
		apellidoShowLabel.setVisible(false);
		apellidoShowLabel.setBounds(170, 170, 89, 23);
		ventanaSelectPerson.getContentPane().add(apellidoShowLabel);
		
		dniFixedLabel = new JLabel("DNI:");
		dniFixedLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		dniFixedLabel.setForeground(new Color(128, 0, 255));
		dniFixedLabel.setBounds(92, 107, 38, 19);
		ventanaSelectPerson.getContentPane().add(dniFixedLabel);
		
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setForeground(new Color(128, 0, 255));
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNombre.setBounds(92, 140, 66, 19);
		ventanaSelectPerson.getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("APELLIDO:");
		lblApellido.setForeground(new Color(128, 0, 255));
		lblApellido.setFont(new Font("Calibri", Font.BOLD, 14));
		lblApellido.setBounds(92, 174, 68, 19);
		ventanaSelectPerson.getContentPane().add(lblApellido);
	}

	public void initializeComponents() {

	}
	/**
	 * Cargar las personas en un array estático (que será lo que lleve el Combobox). Formato ( DNI - NOMBRE APELLIDO )
	 * */
	private String[] loadPersonFromDB() {
		ArrayList<Persona> personas = personaController.getPersonas();
		String[] dniNombreApellidos = new String[personas.size()];
		for(int i=0; i<dniNombreApellidos.length; i++) {
			dniNombreApellidos[i] =  personas.get(i).getNombre() + " " + personas.get(i).getApellido();
		}
		return dniNombreApellidos;
	}
	public void visualize() {
		framePadre.setVisible(false);
		ventanaSelectPerson.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelarButton) {
			// He pulsado el botón cancelar
			ventanaSelectPerson.setVisible(false);
			framePadre.setVisible(true);
		}
		
		
		//String personaSelecccionada = (String) selectPersonsList.getSelectedItem();
		int indiceSeleccionado = selectPersonsList.getSelectedIndex();
		//Seleccionamos la persona
		Persona personaSelecccionada = personaController.getPersona(indiceSeleccionado);
		dniShowLabel.setText(personaSelecccionada.getDni());
		dniShowLabel.setVisible(true);
		
		nombreShowLabel.setText(personaSelecccionada.getNombre());
		nombreShowLabel.setVisible(true);
		
		apellidoShowLabel.setText(personaSelecccionada.getApellido());
		apellidoShowLabel.setVisible(true);
		System.out.println("Persona "+personaSelecccionada + " SELECCIONADA!!!");
	}
}
