package usjt.olimpiada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usjt.olimpiada.model.Pais;

public class PaisDAO {
	
	public boolean criar(Pais pais) {
		boolean gravado = false;
		
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
				
				gravado = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gravado;
	}

	public boolean atualiza(Pais pais) {
		boolean gravado = false;
		
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id_pais=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.execute();
			
			gravado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gravado;
	}

	public boolean excluir(int idPais) {
		boolean exclude = false;
		String sqlDelete = "DELETE FROM pais WHERE id_pais = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idPais);
			stm.execute();
			
			exclude = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exclude;
	}

	public Pais carregar(int idPais) {
		Pais pais = new Pais();
		String sqlSelect = "SELECT nome, populacao, area, id_pais FROM pais WHERE id_pais = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, idPais);
			try (ResultSet rs = stm.executeQuery();) {
				
				if (rs.next()) {
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(0);
					pais.setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return pais;

	}
	
	public Pais vetorPaises(Pais pais){
		String sqlSelect = "SELECT nome , populacao, area, id_pais FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		ArrayList<Pais> paisLista = new ArrayList<Pais>();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				
				Pais p;
				for(int i=0;i<3;i++){
				
					
				if (rs.next()) {
					p = new Pais(rs.getInt("id_pais"), rs.getString("nome"), rs.getLong("populacao"),
							rs.getDouble("area"));
					
					paisLista.add(p);
				} else {
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(0);
					pais.setArea(0);
				}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}

	public ArrayList<Pais> buscaPaises() {
		ArrayList<Pais> paises = new ArrayList<>();
		String sqlSelect = "SELECT id_pais, nome, populacao, area FROM pais ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					Pais pais = new Pais();
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					paises.add(pais);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return paises;
	}
	
	public Pais paisMaiorPopulacao() {
		Pais pais = new Pais();
		String sqlSelect = "SELECT id_pais, nome, populacao, area FROM pais order by populacao desc ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if (rs.next()) {
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return pais;
	}
	
	public Pais paisMenorArea() {
		Pais pais = new Pais();
		String sqlSelect = "SELECT id_pais, nome, populacao, area FROM pais order by area asc ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				
				if (rs.next()) {
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return pais;
	}
	
	public ArrayList<Pais> retornaTresPaises() {
		ArrayList<Pais> paises = new ArrayList<>();
		String sqlSelect = "SELECT id_pais, nome, populacao, area "
						 + "FROM pais "
						 + "LIMIT 3";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					Pais pais = new Pais();
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					paises.add(pais);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return paises;
	}

}