package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class Repaso1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repaso1 frame = new Repaso1();
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
	public Repaso1() {
		setTitle("Ejercicio repaso 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		mnFichero.setMnemonic('F');
		menuBar.add(mnFichero);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setMnemonic('N');
		mnFichero.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrir.setMnemonic('A');
		mnFichero.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar.setMnemonic('G');
		mnFichero.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setMnemonic('C');
		mnFichero.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnFichero.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setMnemonic('S');
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFichero.add(mntmSalir);
		
		JMenu mnFechas = new JMenu("Fechas");
		mnFechas.setMnemonic('E');
		menuBar.add(mnFechas);
		
		JMenuItem mntmLocaldate = new JMenuItem("LocalDate");
		mntmLocaldate.setMnemonic('L');
		mnFechas.add(mntmLocaldate);
		
		JMenuItem mntmPeriod = new JMenuItem("Period");
		mntmPeriod.setMnemonic('P');
		mnFechas.add(mntmPeriod);
		
		JMenuItem mntmChronounit = new JMenuItem("ChronoUnit");
		mntmChronounit.setMnemonic('C');
		mnFechas.add(mntmChronounit);
		
		JMenuItem mntmGlobal = new JMenuItem("Global");
		mntmGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fechas fechas = new Fechas();
				fechas.setVisible(true);
			}
		});
		mnFechas.add(mntmGlobal);
		
		JMenu mnAyuda = new JMenu("Info");
		mnAyuda.setMnemonic('I');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda ayuda = Ayuda.GetInstance();
				ayuda.setVisible(true);
			}
		});
		mntmAyuda.setMnemonic('A');
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acerca = new AcercaDe();
				acerca.setVisible(true);
			}
		});
		mntmAcercaDe.setMnemonic('D');
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	
}
