package conexao;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			new Conexao();
		}
		return connection;
	}

	private Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/oi", "root", "");
		} catch (Exception e) {
			System.out.println("Nao foi possivel conectar ao banco!");
		}
	}
}