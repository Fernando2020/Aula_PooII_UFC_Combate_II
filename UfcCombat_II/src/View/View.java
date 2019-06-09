package View;

import java.util.Scanner;

import Controller.ReportController;
import Controller.StartController;
import Model.Fighter;

public class View {
	private Scanner scan;

	public View() {

	}

	public void Menu() {
		scan = new Scanner(System.in);
		int number = 1;
		System.out.println("_________________________________________________________");
		System.out.println("UFC-Combate");
		System.out.println("_________________________________________________________");
		System.out.println("Escolha uma Opção");
		while (true) {
			if (number == 0)
				return;
			System.out.println("[1] - Iniciar os Combates");
			System.out.println("[2] - Computar os lutadores vencedores de cada luta");
			System.out.println("[3] - Computar as lutas ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019)");
			System.out.println("[4] - Computar os pontos ganhos para cada jogador em cada luta");
			System.out.println("[5] - Número de vitórias por país");
			System.out.println("[6] - Número de vitórias por jogador");
			System.out.println("[7] - Maior vencedor por categoria");
			System.out.println("[8] - Número de lutas computadas no total");
			System.out.println("[9] - Nomes dos lutadores, categoria, país, sexo e quantidade de vitorias "
					+ "(ordenado em ordem crescente de vitórias dentro de cada categoria)");
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
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarVencedoresLuta());
			}

			else if (number == 3) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarLutaLiga());
			}

			else if (number == 4) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarPontosLutadorLuta());
			}

			else if (number == 5) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarVitoriasPais());
			}

			else if (number == 6) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarVitoriasLutador());
			}

			else if (number == 7) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarMaiorLutadorCategoria());
			}

			else if (number == 8) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarQuantidadeLutas());
			}

			else if (number == 9) {
				ReportController reportController = new ReportController();
				System.out.println(reportController.selecionarLutaCategoriaResultado());
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
