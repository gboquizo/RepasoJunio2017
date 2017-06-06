package funcionalidad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Fichero {

	private static ArrayList<String> lineas = new ArrayList<String>();
	
	public static void escritura(File file,LocalDate fechaInicio,String Jlabel, LocalDate fechaFin) throws ErrorAlEscribirException{
		
		try{
		
				FileWriter out = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(out);
			
			
			
			for (String linea : lineas) {
				bw.write(linea + "\n");
			}
			
			bw.close();
			
		} catch (IOException e) {
			throw new ErrorAlEscribirException("Error de escritura");
		} 
	}

	public static void ecribirLinea(LocalDate fechaInicio, String Jlabel, LocalDate fechaFin) {
		String linea = " Fecha inicio : " + fechaInicio.toString() +" Fecha fin : " + fechaFin.toString() + Jlabel + " Autor : Jesús Mejias Leiva ";
		lineas.add(linea);
	}
	
	public static ArrayList<String> leer(File file) throws ErrorAlLeerException{
		
		FileReader in;
		BufferedReader br;
		String linea;
		ArrayList <String> lineas = new ArrayList<String>();
			try {

				in = new FileReader(file);
				br = new BufferedReader(in);
				while((linea = br.readLine()) != null){
					lineas.add(linea);
				}

				in.close();
				return lineas;
				
			} catch (IOException e) {
				throw new ErrorAlLeerException("Error de lectura");
			}
			
		}
	
		
	}


