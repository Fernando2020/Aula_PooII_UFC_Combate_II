package Controller;

import Repository.ReportDAO;

import java.util.ArrayList;

import Model.ViewModelReport;

/**
 * Classe para Controle do tipo Report, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class ReportController {

	/**
	 * Método responsável por receber o relatório do sgbd - Computar os lutadores
	 * vencedores de cada luta
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarVencedoresLuta() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarVencedoresLuta();

		for (ViewModelReport viewModelReport : listReport) {
			retorno += "Combate: " + viewModelReport.GetCombat().GetName() + "\n" + "Categoria: "
					+ viewModelReport.GetCombat().GetCategory() + "\n" + "Vencedor: "
					+ viewModelReport.GetCombat().GetNameWinner() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar as lutas
	 * ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019)
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarLutaLiga() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReportWinner = new ArrayList<ViewModelReport>();
		ArrayList<ViewModelReport> listReportLoser = new ArrayList<ViewModelReport>();
		listReportWinner = reportDao.selecionarLutaLigaWinner();
		listReportLoser = reportDao.selecionarLutaLigaLoser();

		for (int i = 0; i < listReportWinner.size(); i++) {
			retorno += "Combate: " + listReportWinner.get(i).GetCombat().GetName() + "\n" + "Categoria: "
					+ listReportWinner.get(i).GetCombat().GetCategory() + "\n" + "Ano: "
					+ listReportWinner.get(i).GetChampionship().GetAno() + "\n" + "Lutador 01: "
					+ listReportWinner.get(i).GetFighter().GetName() + "\n" + "Lutador 02: "
					+ listReportLoser.get(i).GetFighter().GetName() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar os pontos
	 * ganhos para cada jogador em cada luta
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarPontosLutadorLuta() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReportWinner = new ArrayList<ViewModelReport>();
		ArrayList<ViewModelReport> listReportLoser = new ArrayList<ViewModelReport>();
		listReportWinner = reportDao.selecionarPontosLutadorLutaWinner();
		listReportLoser = reportDao.selecionarPontosLutadorLutaLoser();

		for (int i = 0; i < listReportWinner.size(); i++) {
			retorno += "Combate: " + listReportWinner.get(i).GetCombat().GetName() + "\n" + "Lutador 01: "
					+ listReportWinner.get(i).GetFighter().GetName() + " - " + "Pontos: "
					+ listReportWinner.get(i).GetCombat().GetPointWinner() + "\n" + "Lutador 02: "
					+ listReportLoser.get(i).GetFighter().GetName() + " - " + "Pontos: "
					+ listReportLoser.get(i).GetCombat().GetPointLoser() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de vitórias por
	 * país
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarVitoriasPais() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarVitoriasPais();
		for (ViewModelReport viewModelReport : listReport) {
			retorno += "País: " + viewModelReport.GetFighter().GetParents() + " - " + " Vitorias: "
					+ viewModelReport.GetCountAux() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de vitórias por
	 * jogador
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarVitoriasLutador() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarVitoriasLutador();
		for (ViewModelReport viewModelReport : listReport) {
			retorno += "Lutador: " + viewModelReport.GetFighter().GetName() + " - " + "Vitorias: "
					+ viewModelReport.GetCountAux() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Maior vencedor por
	 * categoria
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarMaiorLutadorCategoria() {
		String retorno = "";
		String aux = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarMaiorLutadorCategoria();
		for (ViewModelReport viewModelReport : listReport) {
			if (!aux.toString().equals(viewModelReport.GetFighter().GetCategory().toString())) {
				retorno += "Lutador: " + viewModelReport.GetFighter().GetName() + "\n" + "Categoria: "
						+ viewModelReport.GetFighter().GetCategory() + "\n" + "Vitorias: "
						+ viewModelReport.GetCountAux() + "\n***\n";
			}
			aux = viewModelReport.GetFighter().GetCategory();
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de lutas
	 * computadas no total
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarQuantidadeLutas() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarQuantidadeLutas();
		for (ViewModelReport viewModelReport : listReport) {
			retorno += "Quantidade de lutas computadas: " + viewModelReport.GetCountAux() + "\n***\n";
		}
		return retorno;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Nomes dos lutadores,
	 * categoria, país, sexo e quantidade de vitorias (ordenado em ordem crescente
	 * de vitórias dentro de cada categoria)
	 * 
	 * @author Fernando G. Nogueira
	 * @return String - Retorno do relatório do sgdb
	 */
	public String selecionarLutaCategoriaResultado() {
		String retorno = "";
		ReportDAO reportDao = new ReportDAO();
		ArrayList<ViewModelReport> listReport = new ArrayList<ViewModelReport>();
		listReport = reportDao.selecionarLutaCategoriaResultado();
		for (ViewModelReport viewModelReport : listReport) {
			retorno += "Lutador: " + viewModelReport.GetFighter().GetName() + "\n" + "Categoria: "
					+ viewModelReport.GetFighter().GetCategory() + "\n" + "Pais: "
					+ viewModelReport.GetFighter().GetParents() + "\n" + "Sexo: "
					+ viewModelReport.GetFighter().GetSex() + "\n" + "Vitorias: " + viewModelReport.GetCountAux()
					+ "\n***\n";
		}
		return retorno;
	}
}
