package funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class Fichero {

	
	public static void escritura(File file,LocalDate fechaInicio,String Jlabel, LocalDate fechaFin) throws ErrorAlEscribirException{
		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			out.writeUTF("Fecha inicio : " + fechaInicio.toString() + "\n"
						+"Fecha fin : " + fechaFin.toString()+ "\n"
						+ Jlabel + "\n"
						+ "Autor : Jesús Mejias Leiva" );
		} catch (IOException e) {
			throw new ErrorAlEscribirException("Error de escritura");
		} 
	}
	
	public static String leer(File file) throws ErrorAlLeerException{
		try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
			return in.readUTF();
		} catch (IOException e) {
			throw new ErrorAlLeerException("Error de lectura");
		} 
	}

}
