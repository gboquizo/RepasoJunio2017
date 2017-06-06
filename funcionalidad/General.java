package funcionalidad;

import java.io.File;
import java.util.ArrayList;

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
	public static ArrayList<String> abrir(File file) throws ErrorAlLeerException{
		return Fichero.leer(file);
	}
	
	/**
	 * Asigna un fichero al file principal
	 * @param fichero
	 */
	public static void setFile(File fichero){
		file=fichero;
	}
	
	/**
	 * Comprueba si el fichero existe
	 * @param file
	 * @return boolean
	 */
	public static boolean ficheroExiste(File file){
		if(file.exists())
			return true;
			return false;
	}

	/**
	 * Devuelve el fichero
	 * @return file
	 */
	public static File getFile() {
		return file;
	}
	
	
	
}
