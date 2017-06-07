package gui;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

import java.io.File;
import java.io.Serializable;

import javax.swing.event.ChangeListener;


import funcionalidad.Fichero;
import funcionalidad.General;

import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;


public class Fechas extends JDialog implements Serializable {

	private static final String TIEMPO_TRANSCURRIDO = "Tiempo transcurrido : ";
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static LocalDate FECHA_ACTUAL=LocalDate.now();
	private static LocalDate fechaFin;
	private JRadioButton rdbtnDias;
	private JRadioButton rdbtnMeses;
	private JRadioButton rdbtnAos;
	private static JLabel lblTiempoTranscurrido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JSpinner spinnerInicio;
	private static JSpinner spinnerFin;
	private static boolean modificado=false;


	static {
		Locale.setDefault(new Locale("es", "ES"));//Para Mostrar los dias y meses en formato Español
	}


	/**
	 * Create the dialog.
	 */
	public Fechas() {
		setModal(true);
		setTitle("Repaso fechas");


		setBounds(100, 100, 721, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		spinnerInicio = new JSpinner();
		spinnerInicio.setForeground(Color.WHITE);
		spinnerInicio.setBackground(Color.DARK_GRAY);
		spinnerInicio.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fechaValida();
				modificado=true;
				comprobarRadioButtons(spinnerInicio, spinnerFin);
			}
		});

		defaultSpinnerInicio();
		spinnerInicio.setBounds(112, 111, 245, 22);
		contentPanel.add(spinnerInicio);
		
		
		spinnerFin = new JSpinner();
		spinnerFin.setForeground(Color.WHITE);
		spinnerFin.setBackground(Color.DARK_GRAY);
		spinnerFin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				fechaValida();
				modificado=true;
				comprobarRadioButtons(spinnerInicio, spinnerFin);
			}
		});
		defaultSpinnerFin();
		spinnerFin.setBounds(394, 111, 245, 22);
		contentPanel.add(spinnerFin);
		
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setForeground(Color.WHITE);
		lblFechaInicio.setBounds(195, 82, 89, 17);
		contentPanel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setForeground(Color.WHITE);
		lblFechaFin.setBounds(471, 82, 89, 17);
		contentPanel.add(lblFechaFin);
		
		rdbtnDias = new JRadioButton("Dias");
		rdbtnDias.setForeground(Color.WHITE);
		rdbtnDias.setBackground(Color.DARK_GRAY);
		rdbtnDias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarRadioButtons(spinnerInicio, spinnerFin);
				modificado=true;
			}
		});
		buttonGroup.add(rdbtnDias);
		rdbtnDias.setBounds(172, 232, 130, 25);
		contentPanel.add(rdbtnDias);
		
		rdbtnMeses = new JRadioButton("Meses");
		rdbtnMeses.setForeground(Color.WHITE);
		rdbtnMeses.setBackground(Color.DARK_GRAY);
		rdbtnMeses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarRadioButtons(spinnerInicio, spinnerFin);
				modificado=true;
			}
		});
		buttonGroup.add(rdbtnMeses);
		rdbtnMeses.setBounds(324, 232, 130, 25);
		contentPanel.add(rdbtnMeses);
		
		rdbtnAos = new JRadioButton("Años");;
		rdbtnAos.setForeground(Color.WHITE);
		rdbtnAos.setBackground(Color.DARK_GRAY);
		rdbtnAos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarRadioButtons(spinnerInicio, spinnerFin);
				modificado=true;
			}
		});
		buttonGroup.add(rdbtnAos);
		rdbtnAos.setBounds(483, 232, 130, 25);
		contentPanel.add(rdbtnAos);
		
		rdbtnAos.setSelected(true);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fichero.escribirLinea(getFechaSpinnerInicio(), lblTiempoTranscurrido.getText(), getFechaSpinnerFin());
				JOptionPane.showMessageDialog(null, "Linea añadida correctamente");
				modificado=true;
				File file = new File("SinNombre.txt");
				General.setFile(file);
				
				dispose();
			}
		});
		btnSalir.setBounds(324, 340, 105, 27);
		contentPanel.add(btnSalir);
		
		lblTiempoTranscurrido = new JLabel(TIEMPO_TRANSCURRIDO);
		lblTiempoTranscurrido.setForeground(Color.WHITE);
		lblTiempoTranscurrido.setBounds(267, 30, 229, 17);
		contentPanel.add(lblTiempoTranscurrido);

		comprobarRadioButtons(spinnerInicio, spinnerFin);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Filtrar por : ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(115, 202, 538, 103);
		contentPanel.add(panel);
	}

	public static void defaultSpinnerFin() {
		fechaFin = LocalDate.of(FECHA_ACTUAL.getYear() + 3, FECHA_ACTUAL.getMonth(), FECHA_ACTUAL.getDayOfMonth());
		spinnerFin.setModel(new SpinnerDateModel(java.sql.Date.valueOf(fechaFin), null, null, Calendar.MONTH));
		spinnerFin.setEditor(new JSpinner.DateEditor(spinnerFin, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
		
	}

	public static void defaultSpinnerInicio() {			
		spinnerInicio.setModel(new SpinnerDateModel(java.sql.Date.valueOf(FECHA_ACTUAL), null, null, Calendar.MONTH));
		spinnerInicio.setEditor(new JSpinner.DateEditor(spinnerInicio, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
	}

	/**
	 * Comprueba la selección de los radioButtons
	 * @param spinnerInicio
	 * @param spinnerFin
	 */
	private void comprobarRadioButtons(JSpinner spinnerInicio, JSpinner spinnerFin) {
		if(rdbtnMeses.isSelected())
			lblTiempoTranscurrido.setText(TIEMPO_TRANSCURRIDO + " " + obtenerTiempoMeses(getFechaSpinner(spinnerInicio), getFechaSpinner(spinnerFin)));
		else if(rdbtnDias.isSelected())
			lblTiempoTranscurrido.setText(TIEMPO_TRANSCURRIDO + " " + obtenerTiempoDias( getFechaSpinner(spinnerInicio), getFechaSpinner(spinnerFin)));
		else 
			lblTiempoTranscurrido.setText(TIEMPO_TRANSCURRIDO + " " + obtenerTiempoAnnos( getFechaSpinner(spinnerInicio), getFechaSpinner(spinnerFin)));
	}
	
	/**
	 * Calcula la distancia que hay entre 2 fechas, en meses
	 * @param localdate1
	 * @param localdate2			while(Fechas.){
	 * @return distancia en meses
	 */
	private String obtenerTiempoMeses(LocalDate localdate1, LocalDate localdate2){
		long meses = ChronoUnit.MONTHS.between(localdate1, localdate2);
		return meses + " meses";
		}
	
	/**
	 * Calcula la distancia que hay entre 2 fechas, en dias
	 * @param localdate1
	 * @param localdate2
	 * @return distancia en dias
	 */
	private String obtenerTiempoDias(LocalDate localdate1, LocalDate localdate2){

		long dias = ChronoUnit.DAYS.between(localdate1, localdate2);
		return dias + " dias";
		}
	
	/**
	 * Calcula la distancia que hay entre 2 fechas, en años
	 * @param localdate1
	 * @param localdate2
	 * @return distancia en años
	 */
	private String obtenerTiempoAnnos(LocalDate localdate1, LocalDate localdate2){
		Period period = Period.between(localdate1, localdate2);
		return period.getYears() + " años";
		}
	
	/**
	 * Obtiene la fecha de un JSpinner
	 * @param jspinner
	 * @return LocalDate con la fecha del JSpinner
	 */
	private LocalDate getFechaSpinner(JSpinner jspinner){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) jspinner.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}
	
	/**
	 * Comprueba que la fecha de fin no sea menor que la de inicio
	 */
	private void fechaValida(){
		if(getFechaSpinner(spinnerFin).isBefore(getFechaSpinner(spinnerInicio))){
			JOptionPane.showMessageDialog(null, "Fecha no válida","Error en la fecha",JOptionPane.ERROR_MESSAGE);
			defaultSpinnerInicio();
			defaultSpinnerFin();
		}
	}
	
	public static LocalDate getFechaSpinnerInicio(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) spinnerInicio.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}
	
	public static LocalDate getFechaSpinnerFin(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime((Date) spinnerFin.getModel().getValue());
		LocalDate fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		return fecha;
	}
	
	public static String getDistancia(){
		return lblTiempoTranscurrido.getText();
	}
	
	public static boolean isModificado(){
		return modificado;
	}
	

	public static void setModificado(boolean modificado) {
		Fechas.modificado = modificado;
	}


	
	
	

}
