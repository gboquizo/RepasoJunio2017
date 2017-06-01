package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import java.awt.Panel;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Fechas extends JDialog {

	private static final String TIEMPO_TRANSCURRIDO = "Tiempo transcurrido : ";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private LocalDate FECHA_ACTUAL=LocalDate.now();
	private LocalDate fechaFin;
	private JRadioButton rdbtnDias;
	private JRadioButton rdbtnMeses;
	private JRadioButton rdbtnAos;
	private JLabel lblTiempoTranscurrido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner spinnerInicio;
	private JSpinner spinnerFin;


	static {
		Locale.setDefault(new Locale("es", "ES"));//Para Mostrar los dias y meses en formato Español
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Fechas dialog = new Fechas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Fechas() {
		setModal(true);
		setTitle("Repaso fechas");


		setBounds(100, 100, 721, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		spinnerInicio = new JSpinner();
		spinnerInicio.setModel(new SpinnerDateModel(java.sql.Date.valueOf(FECHA_ACTUAL), null, null, Calendar.MONTH));
		spinnerInicio.setEditor(new JSpinner.DateEditor(spinnerInicio, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
		spinnerInicio.setBounds(47, 111, 245, 22);
		contentPanel.add(spinnerInicio);
		
		
		spinnerFin = new JSpinner();
		fechaFin = LocalDate.of(FECHA_ACTUAL.getYear() + 3, FECHA_ACTUAL.getMonth(), FECHA_ACTUAL.getDayOfMonth());
		
		spinnerFin.setModel(new SpinnerDateModel(java.sql.Date.valueOf(fechaFin), null, null, Calendar.MONTH));
		spinnerFin.setEditor(new JSpinner.DateEditor(spinnerFin, "dd 'de' MMMM 'de' yyyy', 'EEEE"));
		spinnerFin.setBounds(408, 111, 245, 22);
		contentPanel.add(spinnerFin);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(102, 71, 89, 17);
		contentPanel.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setBounds(483, 71, 89, 17);
		contentPanel.add(lblFechaFin);
		
		rdbtnDias = new JRadioButton("Dias");
		buttonGroup.add(rdbtnDias);
		rdbtnDias.setBounds(172, 232, 130, 25);
		contentPanel.add(rdbtnDias);
		
		rdbtnMeses = new JRadioButton("Meses");
		buttonGroup.add(rdbtnMeses);
		rdbtnMeses.setBounds(324, 232, 130, 25);
		contentPanel.add(rdbtnMeses);
		
		rdbtnAos = new JRadioButton("Años");
		buttonGroup.add(rdbtnAos);
		rdbtnAos.setBounds(483, 232, 130, 25);
		contentPanel.add(rdbtnAos);
		
		rdbtnAos.setSelected(true);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(429, 325, 105, 27);
		contentPanel.add(btnSalir);
		
		lblTiempoTranscurrido = new JLabel(TIEMPO_TRANSCURRIDO);
		lblTiempoTranscurrido.setBounds(271, 12, 229, 17);
		contentPanel.add(lblTiempoTranscurrido);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		comprobarRadioButtons(spinnerInicio, spinnerFin);
		
		JButton btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarRadioButtons(spinnerInicio, spinnerFin);
			}
		});
		btnComprobar.setBounds(208, 325, 105, 27);
		contentPanel.add(btnComprobar);

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
	 * @param localdate2
	 * @return distancia en meses
	 */
	private String obtenerTiempoMeses(LocalDate localdate1, LocalDate localdate2){
		Period period = Period.between(localdate1, localdate2);
		return period.getMonths() + " meses";
		}
	
	/**
	 * Calcula la distancia que hay entre 2 fechas, en dias
	 * @param localdate1
	 * @param localdate2
	 * @return distancia en dias
	 */
	private String obtenerTiempoDias(LocalDate localdate1, LocalDate localdate2){
		Period period = Period.between(localdate1, localdate2);
		return period.getDays() + " dias";
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
		if(getFechaSpinner(spinnerFin).getYear() < getFechaSpinner(spinnerInicio).getYear()){
			JOptionPane.showMessageDialog(null, "fE","",JOptionPane.ERROR_MESSAGE);
		}
	}
	


}
