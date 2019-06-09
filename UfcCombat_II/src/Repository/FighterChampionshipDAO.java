package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.FighterChampionship;

/**
 * Classe DAO para cominucação com o sgbd o tipo FighterChampionship, onde serão
 * contidos, valores e métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira.
 * @version 1.0.
 */
public class FighterChampionshipDAO {

	/**
	 * Método selecionar uma lista do tipo FighterChampionship.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return ArrayList - lista FighterChampionship.
	 */
	public ArrayList<FighterChampionship> selecionarTodos() {
		ArrayList<FighterChampionship> listFighterChampionship = new ArrayList<FighterChampionship>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement("select * from FighterChampionship;").executeQuery();

			FighterChampionship entity;
			while (result.next()) {
				entity = new FighterChampionship(result.getInt("Id"), result.getInt("IdFighter"),
						result.getInt("IdChampionship"));
				listFighterChampionship.add(entity);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFighterChampionship;
	}

	/**
	 * Método selecionar uma entidade do tipo FighterChampionship.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param args FighterChampionship - Entidade de referência.
	 * @return FighterChampionship - entidade do tipo FighterChampionship.
	 */
	public FighterChampionship selecionar(FighterChampionship args) {
		FighterChampionship entity;
		try {
			Connection conexao = new Conn().getConexao();
			ResultSet result = conexao.prepareStatement("select * from FighterChampionship where Id" + args.GetId())
					.executeQuery();

			while (result.next()) {
				entity = new FighterChampionship(result.getInt("Id"), result.getInt("IdFighter"),
						result.getInt("IdChampionship"));
				return entity;
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new FighterChampionship();
	}

	/**
	 * Método responsável por inserir uma entidade do tipo FighterChampionship.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param args FighterChampionship - Entidade de referência.
	 * @return Boolean - true-Secesso/false-Falha.
	 */
	public boolean inserir(FighterChampionship args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("insert into FighterChampionship (IdFighter, IdChampionship) values (?,?);");

			result.setInt(1, args.GetIdFighter());
			result.setInt(2, args.GetIdChampionship());

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
	 * Método responsável por deletar uma entidade do tipo FighterChampionship.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param args FighterChampionship - Entidade de referência.
	 */
	public void deletar(FighterChampionship args) {
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement("delete from FighterChampionship where Id = ?;");

			result.setInt(1, args.GetId());
			result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

	}
}
