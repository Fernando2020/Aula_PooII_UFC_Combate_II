package Repository;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private String Host;
	private String Usuario;
	private String Senha;
	private String Banco;

	public Conn() {
		this.Banco = "ufccombate";
		this.Host = "localhost";
		this.Usuario = "root";
		this.Senha = "";

	}

	public Connection getConexao() {
		try {
			String url = "jdbc:mysql://" + this.Host + "/" + this.Banco;
			return DriverManager.getConnection(url, this.Usuario, this.Senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
