package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JScrollPane;

public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Ayuda ayuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private Ayuda() {
		setModal(true);
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 770, 479);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 7, 770, 444);
		contentPanel.add(scrollPane);
		
		TextArea textArea = new TextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setText("1) Identifica con su objeto en la API de Java: VentanaPrincipal, Barra de menú, menú, elemento de menú, controles...\n\nVentana principal ----- https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html\nBarra Menu ------https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenuBar.html\nMenu ------ https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenu.html\nElementos Menu ------- https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenuItem.html\nControles ----- (JButton) https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html\n\t\t    -----(JLabel) https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html\n\t\t    -----(JSeparator) https://docs.oracle.com/javase/8/docs/api/javax/swing/JSeparator.html\n 2) Identifica los paquetes utilizados.\nHemos necesitado los paquetes javax.swing y java.awt\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nd\n\nd\n\n\n\nd\n\n");
	}
	
	public static Ayuda GetInstance(){
		if(ayuda == null){
			ayuda = new Ayuda();
		}
		return ayuda;
	}
}
