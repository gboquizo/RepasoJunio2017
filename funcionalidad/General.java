package funcionalidad;

import java.io.File;

import gui.Fechas;

public class General {

	static File file = new File("SinNombre.txt");
	
	/**
	 * Guarda los datos en un fichero
	 * @throws ErrorAlEscribirException
	 */
	public static void guardar() throws ErrorAlEscribirException{
			Fichero.escritura(file, Fechas.getFechaSpinnerInicio(), Fechas.getDistancia(), Fechas.getFechaSpinnerFin());
	}
	
	/**
	 * Devuelve los datos leido de un fichero
	 * @param file
	 * @return
	 * @throws ErrorAlLeerException
	 */
	public static String abrir(File file) throws ErrorAlLeerException{
		return Fichero.leer(file);
	}
	
	/**
	 * Asigna un fichero al file principal
	 * @param fichero
	 */
	public static void setFile(File fichero){
		file=fichero;
	}
	
	
}
