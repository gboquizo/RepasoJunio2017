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
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			for (String linea : lineas) {
				bw.write(linea + "\n");
			}

		}catch (IOException e) {
			throw new ErrorAlEscribirException("Error de escritura");
		} 
	}

	public static void escribirLinea(LocalDate fechaInicio, String Jlabel, LocalDate fechaFin) {
		String linea = " Fecha inicio: " + fechaInicio.toString() +"\t Fecha fin: " + fechaFin.toString() + Jlabel + "\t Autor : Jesús Mejias Leiva ";
		lineas.add(linea + "\n");
	}
	
	public static ArrayList<String> leer(File file) throws ErrorAlLeerException{
		
		String linea;
		ArrayList <String> lineas = new ArrayList<String>();
			try (BufferedReader br = new BufferedReader(new FileReader(file))){
				while((linea = br.readLine()) != null){
					lineas.add(linea);
				}

				return lineas;
				
			} catch (IOException e) {
				throw new ErrorAlLeerException("Error de lectura");
			}
			
		}
	
		
	}


