package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		// TODO Auto-generated constructor stub
	}
	
	private String os() {
		return System.getProperty("os.name");
	}

	
	private void executaLista(String processo) {
		Process process;
		InputStream stream;
		InputStreamReader reader;
		BufferedReader bufferReader;
		String line;
		
		try {
			process = Runtime.getRuntime().exec(processo);
			stream = process.getInputStream();
			reader = new InputStreamReader(stream);
			bufferReader = new BufferedReader(reader);
			line = bufferReader.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = bufferReader.readLine();
			}
			
	} catch (Exception e) {
		System.out.println(e);
		}
	}
	
	public void listaProcessos() {
		String os = os();
		
		
		if(os.contains("Windows")) {
				executaLista("TASKLIST /FO TABLE");
			}
		else {
			executaLista("ps -ef");
			}
		}
	
	public void mataPID(int ID){ 
		
		String os = os();
		Process process;
		String PID = String.valueOf(ID);
		StringBuffer buffer = new StringBuffer();
		
		if(os.contains("Windows")) {
			try {
				buffer.append("TASKKILL /PID ");
//				buffer.append(" ");
				buffer.append(PID);
			} 
			
			catch (Exception e) {
				System.err.println("PID inválido");
			}
			
			executaLista(buffer.toString());

			
		}
		
		else {
			try {
				buffer.append("kill -9 ");
				buffer.append(PID);
			} 
			
			catch (Exception e) {
				System.err.println("PID Invalido");
			}
			
			executaLista(buffer.toString());
		}
		
	}
	
	public void mataNome(String nome) {
		
		String os = os();
		StringBuffer buffer = new StringBuffer();
		
		if(os.contains("Window")) {
			try {
				buffer.append("TASKKILL /IM ");
				buffer.append(nome);
			} catch (Exception e) {
				System.out.println(e);
			}
			executaLista(buffer.toString());
		}
	}
		
}
	

