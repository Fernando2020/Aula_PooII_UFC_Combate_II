package Controller;

import Repository.ReportDAO;

import java.util.ArrayList;

import Model.ViewModelReport;

public class ReportController {

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
