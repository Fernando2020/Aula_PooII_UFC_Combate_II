package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.FighterChampionship;

public class FighterChampionshipDAO {

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
