package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CreateFilmView implements ActionListener {
	//CONTROLADOR (PARA PODER INSERTAR PELIS)
	
	//COMPONENTES GRÁFICOS
	JFrame ventanaPrincipalApp;
	JDialog ventanaCreacionPeli;
	private JTextField tituloPeliTextField;
	private JTextField generoPeliTextField;
	private JTextField fechaPeliculaTextField;
	private JButton insertButton;
	private JButton cancelButton;

	/**
	 * @wbp.parser.entryPoint
	 */
	public CreateFilmView(JFrame frame) {
		this.ventanaPrincipalApp = frame;
		ventanaCreacionPeli = new JDialog(frame);
		ventanaCreacionPeli.getContentPane().setLayout(null);

		JLabel insertFilmHeadLabel = new JLabel("Inserción de Peli");
		insertFilmHeadLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		insertFilmHeadLabel.setBounds(250, 46, 139, 38);
		ventanaCreacionPeli.getContentPane().add(insertFilmHeadLabel);

		tituloPeliTextField = new JTextField();
		tituloPeliTextField.setBounds(197, 95, 268, 38);
		ventanaCreacionPeli.getContentPane().add(tituloPeliTextField);
		tituloPeliTextField.setColumns(10);

		generoPeliTextField = new JTextField();
		generoPeliTextField.setColumns(10);
		generoPeliTextField.setBounds(197, 160, 268, 38);
		ventanaCreacionPeli.getContentPane().add(generoPeliTextField);

		fechaPeliculaTextField = new JTextField();
		fechaPeliculaTextField.setColumns(10);
		fechaPeliculaTextField.setBounds(197, 239, 268, 38);
		ventanaCreacionPeli.getContentPane().add(fechaPeliculaTextField);

		JLabel tituloPeliLabel = new JLabel("TITULO PELICULA");
		tituloPeliLabel.setBounds(83, 107, 104, 14);
		ventanaCreacionPeli.getContentPane().add(tituloPeliLabel);

		JLabel generoPeliculaLabel = new JLabel("GENERO PELICULA");
		generoPeliculaLabel.setBounds(83, 172, 104, 14);
		ventanaCreacionPeli.getContentPane().add(generoPeliculaLabel);

		JLabel fechaPeliLabel = new JLabel("FECHA PELICULA");
		fechaPeliLabel.setBounds(83, 251, 104, 14);
		ventanaCreacionPeli.getContentPane().add(fechaPeliLabel);

		insertButton = new JButton("Insertar");
		insertButton.setBounds(376, 314, 89, 23);
		ventanaCreacionPeli.getContentPane().add(insertButton);

		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(95, 314, 89, 23);
		ventanaCreacionPeli.getContentPane().add(cancelButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cancelButton) {
			ventanaCreacionPeli.setVisible(false);
			ventanaPrincipalApp.setVisible(true);
		}
		if(e.getSource() == insertButton) {
			//Aquí tendremos que hacer la inserción con JDBC (esta inserción se hará en el controller)
			
		}
	}
}
