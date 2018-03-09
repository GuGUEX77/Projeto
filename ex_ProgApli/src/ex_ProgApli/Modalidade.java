package ex_ProgApli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modalidade {
	private String nome;
	private int ouro, prata, bronze, id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOuro() {
		return ouro;
	}

	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	public int getPrata() {
		return prata;
	}

	public void setPrata(int prata) {
		this.prata = prata;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

	@Override
	public String toString() {
		return "Modalidade [nome=" + nome + ", id=" + id + ", ouro=" + ouro + ", prata=" + prata + ", bronze=" + bronze
				+ "]";
	}@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bronze;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ouro;
		result = prime * result + prata;
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
		Modalidade other = (Modalidade) obj;
		if (bronze != other.bronze)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ouro != other.ouro)
			return false;
		if (prata != other.prata)
			return false;
		return true;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Modalidade() {
	}

	public Modalidade(String nome, int id, int ouro, int prata, int bronze) {
		this.nome = nome;
		this.id = id;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;

	}

	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/vendas?user=root&password=alunos");
	}

	public void criar() {
		String sqlInsert = "INSERT INTO modalidade(nome, ouro, prata, bronze) VALUES (?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setInt(2, getOuro());
			stm.setInt(3, getPrata());
			stm.setInt(4, getBronze());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		String sqlUpdate = "UPDATE modalidade SET nome=?, ouro=?, prata=?, bronze=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, getNome());
			stm.setInt(2, getOuro());
			stm.setInt(3, getPrata());
			stm.setInt(4, getBronze());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {
		String sqlDelete = "DELETE FROM modalidade WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregar() {
		String sqlSelect = "SELECT nome, ouro, prata, bronze FROM modalidade WHERE modalidade.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setOuro(rs.getInt("ouro"));
					setPrata(rs.getInt("prata"));
					setBronze(rs.getInt("bronze"));
				} else {
					setId(-1);
					setNome(null);
					setOuro(0);
					setPrata(0);
					setBronze(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
}
