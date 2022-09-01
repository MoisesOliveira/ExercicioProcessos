package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController processKiller = new KillController();

		int opc = escolheMetodo();
		
		if(opc == 1) processKiller.listaProcessos();
		
		if(opc == 2) {
			int PID = escolhePID();
			processKiller.mataPID(PID);
		}
		
		if(opc == 3) {
			String nome = escolheNome();
			processKiller.mataNome(nome);
		}
	}

	private static int escolheMetodo() {
		int opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n 1 - Lista processos "
				+ "\n 2 - Mata processo por PID \n 3 - Mata processo por nome"));
		return opc;
	}
	
	private static int escolhePID() {
		int PID = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID"));
		return PID;
	}
	
	private static String escolheNome() {
		String nome = JOptionPane.showInputDialog("Digite o nome do processo");
		return nome;
	}
}
