package View;

import java.util.Scanner;
import Controller.StartController;
import Repository.ReportDAO;
import Model.Fighter;

public class View {
	public void Menu() {
		Scanner scan = new Scanner(System.in);
		int number = 1;
		System.out.println("_________________________________________________________");
		System.out.println("UFC-Combate");
		System.out.println("_________________________________________________________");
		System.out.println("Escolha uma Op��o");
		while (true) {
			if (number == 0)
				return;
			System.out.println("[1] - Iniciar os Combates");
			System.out.println("[2] - Computar os lutadores vencedores de cada luta");
			System.out.println("[3] - Computar as lutas ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019)");
			System.out.println("[4] - Computar os pontos ganhos para cada jogador em cada luta");
			System.out.println("[5] - N�mero de vit�rias por pa�s");
			System.out.println("[6] - N�mero de vit�rias por jogador");
			System.out.println("[7] - Maior vencedor por categoria");
			System.out.println("[8] - N�mero de lutas computadas no total");
			System.out.println(
					"[9] - Nomes dos lutadores, categoria, pa�s, sexo e quantidade de vitorias (ordenado em ordem crescente de vit�rias dentro de cada categoria)");
			System.out.println("[0] - Sair");
			number = scan.nextInt();

			if (number == 1) {
				StartController starController = new StartController();
				System.out.println("Aguarde...");
				if (starController.Go()) {
					System.out.println("Sucesso");
					System.out.println("_________________________________________________________");
				}
			}

			else if (number == 2) {

			}
			
			else {
				return;
			}
		}
	}

	public static void ExecucaoChampionship(int id, String name, String ano) {
		System.out.println("_________________________________________________________");
		System.out.println("Combate: " + id + " - " + name + " | " + ano);
		System.out.println("_________________________________________________________");
		return;
	}

	public static void ExecucaoLutadores(Fighter winner, Fighter loser) {
		System.out.println("Ganhador: " + winner.GetName());
		System.out.println("Perdedor: " + loser.GetName());
		System.out.println("***");
		return;
	}
}
