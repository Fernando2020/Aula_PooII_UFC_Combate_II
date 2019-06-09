package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Fighter;

public class FighterDAO {

	public ArrayList<Fighter> selecionarTodos() {
		ArrayList<Fighter> listFighter = new ArrayList<Fighter>();
		try {
			Connection conexao = new Conn().getConexao();

			ResultSet result = conexao.prepareStatement("select * from Fighter;").executeQuery();

			Fighter entity;
			while (result.next()) {
				entity = new Fighter(result.getInt("Id"), result.getString("Name"), result.getString("Category"),
						result.getString("Parents"), result.getString("Sex"));
				listFighter.add(entity);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFighter;
	}

	public Fighter selecionar(Fighter args) {
		Fighter entity;
		try {
			Connection conexao = new Conn().getConexao();
			ResultSet result = conexao.prepareStatement("select * from Fighter where Id" + args.GetId()).executeQuery();

			while (result.next()) {
				entity = new Fighter(result.getInt("Id"), result.getString("Name"), result.getString("Category"),
						result.getString("Parents"), result.getString("Sex"));
				return entity;
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Fighter();
	}

	public boolean inserir(Fighter args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();

			PreparedStatement result = conexao
					.prepareStatement("insert into Fighter (Id, Name, Category,Parents,Sex) values (?,?,?,?,?);");

			result.setInt(1, args.GetId());
			result.setString(2, args.GetName());
			result.setString(3, args.GetCategory());
			result.setString(4, args.GetParents());
			result.setString(5, args.GetSex());

			valor = result.executeUpdate();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (valor == 1)
			return true;
		else
			return false;
	}

	public void deletar(Fighter args) {
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao.prepareStatement("delete from Fighter where Id = ?;");

			result.setInt(1, args.GetId());
			result.executeUpdate();
			conexao.close();
		} catch (Exception e) {

		}

	}

	public boolean update(Fighter args) {
		int valor = 0;
		try {
			Connection conexao = new Conn().getConexao();
			PreparedStatement result = conexao
					.prepareStatement("update Fighter Name=?, Category=?,Parents=?,Sex=? WHERE Id = ?");

			result.setString(1, args.GetName());
			result.setString(2, args.GetCategory());
			result.setString(3, args.GetParents());
			result.setString(4, args.GetSex());
			result.setInt(5, args.GetId());

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
