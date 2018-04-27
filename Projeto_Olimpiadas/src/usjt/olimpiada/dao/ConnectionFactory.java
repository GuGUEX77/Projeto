package usjt.olimpiada.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e){
				throw new RuntimeException(e);
			}
		}
		
		// Gerencia a conexão com o banco de dados
		public static Connection obtemConexao() throws SQLException {
			return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jogosOlimpicos?user=alunos&password=alunos&useSSL=false");
	}
}
