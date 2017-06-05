package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>\n<p align=\"center\"><b>Jesus Mejias Leiva</b></p><br></br>\n\t\t\t\t\t\t\t     <br></br>\n<p align=\"center\"><b>31, Mayo, 2017</b></p><br></br>\n\t\t\t\t\t\t\t     <br></br>\n<p align=\"center\"><b>1DAW</b></p>\n</html>");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(162, 41, 161, 175);
		contentPanel.add(lblNewLabel);
	}
}
