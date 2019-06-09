package Repository;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com o sgbd, onde serão contidos, valores e métodos para o
 * mesmo.
 * 
 * @author Fernando G. Nogueira.
 * @version 1.0.
 */
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

	/**
	 * Método pela conexao com o sgbd.
	 * 
	 * @author Fernando G. Nogueira.
	 * @return Entidade de conexão
	 */
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
