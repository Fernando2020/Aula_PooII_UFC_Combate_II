package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.ViewModelReport;

/**
 * Classe DAO para cominucação com o sgbd o tipo Report, onde serão contidos,
 * valores e métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira.
 * @version 1.0.
 */
public class ReportDAO {

	/**
	 * Método responsável por receber o relatório do sgbd - Computar os lutadores
	 * vencedores de cada luta.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarVencedoresLuta() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, combat.name as combat, combat.category from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idwinner;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetCombat().SetName(result.getString("combat"));
				viewModelReport.GetCombat().SetCategory(result.getString("category"));
				viewModelReport.GetCombat().SetNameWinner(result.getString("fighter"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar as lutas.
	 * ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019) - Lutadores vencedores
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarLutaLigaWinner() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select combat.name as combat, combat.category, championship.ano, fighter.name as fighter from combat\r\n"
							+ "inner join championship on combat.idchampionship = championship.id\r\n"
							+ "inner join fighter on combat.idwinner = fighter.id\r\n"
							+ "where championship.ano>='2015';")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetCombat().SetName(result.getString("combat"));
				viewModelReport.GetCombat().SetCategory(result.getString("category"));
				viewModelReport.GetChampionship().SetAno(result.getString("ano"));
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar as lutas
	 * ocorridas em cada liga (2015, 2016, 2017, 2018 e 2019) - Lutadores
	 * perdedores.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarLutaLigaLoser() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select combat.name as combat, combat.category, championship.ano, fighter.name as fighter from combat\r\n"
							+ "inner join championship on combat.idchampionship = championship.id\r\n"
							+ "inner join fighter on combat.idloser = fighter.id\r\n"
							+ "where championship.ano>='2015';")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetCombat().SetName(result.getString("combat"));
				viewModelReport.GetCombat().SetCategory(result.getString("category"));
				viewModelReport.GetChampionship().SetAno(result.getString("ano"));
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar os pontos
	 * ganhos para cada jogador em cada luta - Lutadores vencedores.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarPontosLutadorLutaWinner() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, combat.name as combat, combat.pointwinner from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idwinner;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				viewModelReport.GetCombat().SetName(result.getString("combat"));
				viewModelReport.GetCombat().SetPointWinner(result.getInt("pointwinner"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Computar os pontos
	 * ganhos para cada jogador em cada luta - Lutadores perdedores.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarPontosLutadorLutaLoser() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, combat.name as combat, combat.pointloser from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idloser;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				viewModelReport.GetCombat().SetName(result.getString("combat"));
				viewModelReport.GetCombat().SetPointLoser(result.getInt("pointloser"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de vitórias por
	 * país.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarVitoriasPais() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao
					.prepareStatement("	select fighter.parents, count(fighter.id) as numberwinner from fighter\r\n"
							+ "	inner join combat on fighter.id = combat.idwinner\r\n" + "	group by fighter.parents;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetParents(result.getString("parents"));
				viewModelReport.SetCountAux(result.getInt("numberwinner"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de vitórias por
	 * jogador.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarVitoriasLutador() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, count(fighter.id) as numberwinner from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idwinner\r\n" + "group by fighter.name;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				viewModelReport.SetCountAux(result.getInt("numberwinner"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Maior vencedor por
	 * categoria.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarMaiorLutadorCategoria() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, fighter.category as category, count(fighter.id) as numberwinner from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idwinner\r\n"
							+ "group by fighter.name, fighter.category\r\n"
							+ "order by fighter.category, numberwinner desc, fighter.name;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				viewModelReport.GetFighter().SetCategory(result.getString("category"));
				viewModelReport.SetCountAux(result.getInt("numberwinner"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Número de lutas
	 * computadas no total.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarQuantidadeLutas() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement("select count(combat.id) numbercombat from combat\r\n"
					+ "inner join championship on combat.idchampionship = championship.id;").executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.SetCountAux(result.getInt("numbercombat"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

	/**
	 * Método responsável por receber o relatório do sgbd - Nomes dos lutadores,
	 * categoria, país, sexo e quantidade de vitorias (ordenado em ordem crescente
	 * de vitórias dentro de cada categoria).
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - Retorno de uma lista do tipo
	 *         ViewModelReport.
	 */
	public ArrayList<ViewModelReport> selecionarLutaCategoriaResultado() {
		ArrayList<ViewModelReport> listEntity = new ArrayList<ViewModelReport>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement(
					"select fighter.name as fighter, fighter.category as category, fighter.parents, fighter.sex, count(fighter.id) as numberwinner from fighter\r\n"
							+ "inner join combat on fighter.id = combat.idwinner\r\n"
							+ "group by fighter.name, fighter.category\r\n"
							+ "order by fighter.category, numberwinner asc, fighter.name;")
					.executeQuery();

			ViewModelReport viewModelReport;

			while (result.next()) {
				viewModelReport = new ViewModelReport();
				viewModelReport.GetFighter().SetName(result.getString("fighter"));
				viewModelReport.GetFighter().SetCategory(result.getString("category"));
				viewModelReport.GetFighter().SetParents(result.getString("parents"));
				viewModelReport.GetFighter().SetSex(result.getString("sex"));
				viewModelReport.SetCountAux(result.getInt("numberwinner"));
				listEntity.add(viewModelReport);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEntity;
	}

}
