package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Championship;

public class ChampionshipDAO {
	public ArrayList<Championship> selecionarTodos() {
		ArrayList<Championship> listChampionship = new ArrayList<Championship>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement("select * from Championship;").executeQuery();

			Championship entity;
			while (result.next()) {
				entity = new Championship(result.getInt("Id"), result.getString("Name"), result.getString("Ano"));
				listChampionship.add(entity);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listChampionship;
	}

	public Championship selecionar(Championship args) {
		Championship entity;
		try {
			Connection conexao = new Conn().getConexao();
			ResultSet result = conexao.prepareStatement("select * from Championship where Id" + args.GetId())
					.executeQuery();

			while (result.next()) {
				entity = new Championship(result.getInt("Id"), result.getString("Name"), result.getString("Ano"));
				return entity;
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Championship();
	}

	public boolean inserir(Championship args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("insert into Championship (Id, Name, Ano) values (?,?,?);");

			result.setInt(1, args.GetId());
			result.setString(2, args.GetName());
			result.setString(3, args.GetAno());

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

	public void deletar(Championship args) {
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement("delete from Championship where Id = ?;");

			result.setInt(1, args.GetId());
			result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

	}

	public boolean update(Championship args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement("update Championship Name=?, Ano=? WHERE Id = ?");

			result.setString(1, args.GetName());
			result.setString(2, args.GetAno());
			result.setInt(3, args.GetId());

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
