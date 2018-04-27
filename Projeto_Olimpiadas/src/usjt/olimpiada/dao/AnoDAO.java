package usjt.olimpiada.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usjt.olimpiada.model.Ano;

public class AnoDAO {

	public void criar(Ano ano) {
		String sqlInsert = "INSERT INTO ano(ano, tipo) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, ano.getAno());
			stm.setString(2, String.valueOf(ano.getTipo()));
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					ano.setAno(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualiza(Ano ano) {
		String sqlUpdate = "UPDATE ano SET ano=?, tipo=? WHERE ano=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, ano.getAno());
			stm.setString(2, String.valueOf(ano.getTipo()));
			stm.setInt(3, ano.getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Ano ano) {
		String sqlDelete = "DELETE FROM ano WHERE ano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, ano.getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Ano carregar(int idAno) {
		Ano ano = new Ano();
		String sqlSelect = "SELECT ano, tipo FROM ano WHERE ano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idAno);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					ano.setAno(rs.getInt("ano"));
					ano.setTipo(rs.getString("tipo").charAt(0));
				} else {
					ano.setAno(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return ano;

	}
	
	public ArrayList<Ano> buscaAnos() throws IOException {
		ArrayList<Ano> anos = new ArrayList<>();
		String sqlSelect = "SELECT ano, tipo FROM ano order by ano desc";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Ano ano = new Ano();
					ano.setAno(rs.getInt("ano"));
					ano.setTipo(rs.getString("tipo").charAt(0));
					anos.add(ano);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return anos;

	}
}
