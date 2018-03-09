package ex_ProgApli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Olimpiada {
	private String tipo;
	private int ano;

	@Override
	public String toString() {
		return "Olimpiada [tipo=" + tipo + ", ano=" + ano + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiada other = (Olimpiada) obj;
		if (ano != other.ano)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public Olimpiada(String tipo, int ano) {
		super();
		this.tipo = tipo;
		this.ano = ano;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Olimpiada() {
	}

	

	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/bd?user=root&password=alunos");
	}

	public void criar() {
		String sqlInsert = "INSERT INTO olimpiada(nome, tipo,) VALUES (?, ?,)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getTipo());
			stm.setInt(2, getAno());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					setAno(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		String sqlUpdate = "UPDATE olimpiada SET ano=?, tipo=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, getAno());
			stm.setString(2, getTipo());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {
		String sqlDelete = "DELETE FROM olimpiada WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar() {
		String sqlSelect = "SELECT ano, tipo FROM modalidade WHERE olimpiada.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getAno());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setTipo(rs.getString("tipo"));
					setAno(rs.getInt("ano"));
				} else {
					setAno(-1);
					setTipo(null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
}
