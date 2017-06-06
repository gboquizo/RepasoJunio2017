package gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funcionalidad.ErrorAlEscribirException;
import funcionalidad.ErrorAlLeerException;
import funcionalidad.General;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Repaso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFileChooser jfilechooser = new JFileChooser();
	private JTextPane textPane;
	private boolean cambiosGuardados=false;
	private Fechas fecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repaso frame = new Repaso();
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
	public Repaso() {

	
		setResizable(false);
		setTitle("Ejercicio repaso");
		controlarSalida();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 545);
		
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		mnFichero.setForeground(Color.WHITE);
		mnFichero.setMnemonic('F');
		menuBar.add(mnFichero);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setForeground(Color.WHITE);
		mntmNuevo.setBackground(Color.DARK_GRAY);
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.setMnemonic('N');
		mnFichero.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setForeground(Color.WHITE);
		mntmAbrir.setBackground(Color.DARK_GRAY);
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmAbrir.setMnemonic('A');
		mnFichero.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setForeground(Color.WHITE);
		mntmGuardar.setBackground(Color.DARK_GRAY);
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar.setMnemonic('G');
		mnFichero.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.setForeground(Color.WHITE);
		mntmGuardarComo.setBackground(Color.DARK_GRAY);
		mntmGuardarComo.setMnemonic('C');
		mnFichero.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnFichero.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setForeground(Color.WHITE);
		mntmSalir.setBackground(Color.DARK_GRAY);
		mntmSalir.setMnemonic('S');
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				siCambiosGuardados();
			}


		});
		mnFichero.add(mntmSalir);
		
		JMenu mnFechas = new JMenu("Fechas");
		mnFechas.setForeground(Color.WHITE);
		mnFechas.setMnemonic('E');
		menuBar.add(mnFechas);
		
		JMenuItem mntmLocaldate = new JMenuItem("LocalDate");
		mntmLocaldate.setForeground(Color.WHITE);
		mntmLocaldate.setBackground(Color.DARK_GRAY);
		mntmLocaldate.setMnemonic('L');
		mnFechas.add(mntmLocaldate);
		
		JMenuItem mntmPeriod = new JMenuItem("Period");
		mntmPeriod.setForeground(Color.WHITE);
		mntmPeriod.setBackground(Color.DARK_GRAY);
		mntmPeriod.setMnemonic('P');
		mnFechas.add(mntmPeriod);
		
		JMenuItem mntmChronounit = new JMenuItem("ChronoUnit");
		mntmChronounit.setForeground(Color.WHITE);
		mntmChronounit.setBackground(Color.DARK_GRAY);
		mntmChronounit.setMnemonic('C');
		mnFechas.add(mntmChronounit);
		
		JMenuItem mntmGlobal = new JMenuItem("Global");
		mntmGlobal.setForeground(Color.WHITE);
		mntmGlobal.setBackground(Color.DARK_GRAY);
		mntmGlobal.setMnemonic('G');
		mntmGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fechas fechas = new Fechas();
				fechas.setVisible(true);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnFechas.add(separator_1);
		mnFechas.add(mntmGlobal);
		
		JMenu mnAyuda = new JMenu("Info");
		mnAyuda.setForeground(Color.WHITE);
		mnAyuda.setMnemonic('I');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setForeground(Color.WHITE);
		mntmAyuda.setBackground(Color.DARK_GRAY);
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
		mntmAcercaDe.setForeground(Color.WHITE);
		mntmAcercaDe.setBackground(Color.DARK_GRAY);
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acerca = new AcercaDe();
				acerca.setVisible(true);
			}
		});
		mntmAcercaDe.setMnemonic('D');
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(12, 54, 701, 422);
		contentPane.add(textPane);

	}

	/**
	 * Controla los cambios antes de cerrar el programa
	 */
	private void controlarSalida() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				siCambiosGuardados();
			}
		});
	}
	/**
	 * Guarda los datos en un fichero, siempre que hayan sido modificados
	 */
	void guardar(){

		if(!Fechas.isModificado()){
			int opcion =JOptionPane.showConfirmDialog(contentPane, "La fechas no han sido modificadas, ¿Quieres modificarlas?","Fecha",JOptionPane.YES_NO_OPTION);
			if(opcion == JOptionPane.YES_OPTION){
				Fechas fecha = new Fechas();
				fecha.setVisible(true);
			}
			else if(opcion == JOptionPane.NO_OPTION)
				return;
			else 
				return;	
			}

		if(jfilechooser.showSaveDialog(contentPane) != JFileChooser.APPROVE_OPTION){
			return;
		}
			File file = jfilechooser.getSelectedFile();
			General.setFile(file);
			try {
				General.guardar();
				cambiosGuardados=true;
				JOptionPane.showMessageDialog(contentPane, "Cambios guardados con éxito","Guardar",JOptionPane.INFORMATION_MESSAGE);
			} catch (ErrorAlEscribirException e) {
				JOptionPane.showMessageDialog(contentPane, e.getMessage(),"Error escritura",JOptionPane.ERROR_MESSAGE);
			}

	}
	/**
	 * Lee el fichero y vuelca su contenido en un textArea
	 */
	void abrir(){
		
		if(jfilechooser.showOpenDialog(contentPane) != JFileChooser.APPROVE_OPTION){
			return;
		}
		
		
		try {
			File file = jfilechooser.getSelectedFile();
			ArrayList<String> fecha = General.abrir(file);
			String cadena="";
			for (String string : fecha) {
				cadena+=string + "\n";
				
			}
			textPane.setText(cadena);
			
		} catch (ErrorAlLeerException  e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	

	/**
	 * Comprueba si hay cambios sin guardar antes de salir
	 */
	private void siCambiosGuardados() {
		if(Fechas.isModificado() == true && !cambiosGuardados){
			int opcion =JOptionPane.showConfirmDialog(contentPane, "Hay cambios sin guardar ¿Quieres guardarlos?","Fecha",JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION)
					guardar();
				else
					System.exit(0);
					
		}

	}
	
	/**
	 * Resetea los JSpinner a la fechas iniciales si se habian modificado
	 */
	private void nuevo(){
		if(!Fechas.isModificado()){
			JOptionPane.showMessageDialog(contentPane,"Las fechas no han sido modificadas", "Fechas", JOptionPane.ERROR_MESSAGE);
			return;
		}
		textPane.setText(null);
		Fechas.defaultSpinnerInicio();
		Fechas.defaultSpinnerFin();
		fecha = new Fechas();
		fecha.setVisible(true);
	}

	
	
}
