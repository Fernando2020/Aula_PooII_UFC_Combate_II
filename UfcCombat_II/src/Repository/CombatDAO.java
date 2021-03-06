package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Combat;

/**
 * Classe DAO para cominuca��o com o sgbd o tipo Combat, onde ser�o contidos,
 * valores e m�todos para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class CombatDAO {

	/**
	 * M�todo selecionar uma lista do tipo Combat.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - lista Combat.
	 */
	public ArrayList<Combat> selecionarTodos() {
		ArrayList<Combat> listCombat = new ArrayList<Combat>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement("select * from Combat;").executeQuery();

			Combat entity;
			while (result.next()) {
				entity = new Combat(result.getInt("Id"), result.getString("Name"), result.getString("Category"),
						result.getInt("IdChampionship"), result.getInt("IdFirst"), result.getInt("IdSecond"),
						result.getInt("IdWinner"), result.getInt("IdLoser"), result.getBoolean("KO"),
						result.getInt("PointWinner"), result.getInt("PointLoser"));

				listCombat.add(entity);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCombat;
	}

	/**
	 * M�todo selecionar uma entidade do tipo Combat
	 * 
	 * @author Fernando G. Nogueira
	 * @param args Combat - Entidade de refer�ncia
	 * @return Combat - entidade do tipo Combat
	 */
	public Combat selecionar(Combat args) {
		Combat entity;
		try {
			Connection conexao = new Conn().getConexao();
			ResultSet result = conexao.prepareStatement("select * from Combat where Id" + args.GetId()).executeQuery();

			while (result.next()) {
				entity = new Combat(result.getInt("Id"), result.getString("Name"), result.getString("Category"),
						result.getInt("IdChampionship"), result.getInt("IdFirst"), result.getInt("IdSecond"),
						result.getInt("IdWinner"), result.getInt("IdLoser"), result.getBoolean("KO"),
						result.getInt("PointWinner"), result.getInt("PointLoser"));
				return entity;
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Combat();
	}

	/**
	 * M�todo respons�vel por inserir uma entidade do tipo Combat
	 * 
	 * @author Fernando G. Nogueira
	 * @param args Combat - Entidade de refer�ncia
	 * @return Boolean - true-Secesso/false-Falha
	 */
	public boolean inserir(Combat args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();

			PreparedStatement result = conexao.prepareStatement(
					"insert into Combat (Name, Category, IdChampionship, IdFirst, IdSecond, IdWinner,\r\n"
							+ "			IdLoser, KO, PointWinner, PointLoser) values (?,?,?,?,?,?,?,?,?,?);");

			result.setString(1, args.GetName());
			result.setString(2, args.GetCategory());
			result.setInt(3, args.GetIdChampionship());
			result.setInt(4, args.GetIdFirst());
			result.setInt(5, args.GetIdSecond());
			result.setInt(6, args.GetIdWinner());
			result.setInt(7, args.GetIdLoser());
			result.setBoolean(8, args.IsKO());
			result.setInt(9, args.GetPointWinner());
			result.setInt(10, args.GetPointLoser());

			valor = result.executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			return false;
		}
		if (valor == 1)
			return true;
		else
			return false;
	}

	/**
	 * M�todo respons�vel por deletar uma entidade do tipo Combat
	 * 
	 * @author Fernando G. Nogueira
	 * @param args Combat - Entidade de refer�ncia
	 */
	public void deletar(Combat args) {
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement("delete from Combat where Id = ?;");

			result.setInt(1, args.GetId());
			result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

	}

	/**
	 * M�todo respons�vel por atualizar uma entidade do tipo Combat
	 * 
	 * @author Fernando G. Nogueira
	 * @param args Combat - Entidade de refer�ncia
	 * @return Boolean - true-Secesso/false-Falha
	 */
	public boolean update(Combat args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement(
					"update Combat Name=?, Category=?, NameChampionship=?, NameFirst=?, NameSecond=?, NameWinner=?,NameLoser=?, KO=?, PointWinner=?, PointLoser=? WHERE Id = ?");

			result.setString(1, args.GetName());
			result.setString(2, args.GetCategory());
			result.setInt(3, args.GetIdChampionship());
			result.setInt(4, args.GetIdFirst());
			result.setInt(5, args.GetIdSecond());
			result.setInt(6, args.GetIdWinner());
			result.setInt(7, args.GetIdLoser());
			result.setBoolean(8, args.IsKO());
			result.setInt(9, args.GetPointWinner());
			result.setInt(10, args.GetPointLoser());
			result.setInt(11, args.GetId());

			valor = result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

		if (valor == 1)
			return true;
		else
			return false;

	}
}
