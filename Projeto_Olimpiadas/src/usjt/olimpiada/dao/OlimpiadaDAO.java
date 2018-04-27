package usjt.olimpiada.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usjt.olimpiada.model.Ano;
import usjt.olimpiada.model.Modalidade;
import usjt.olimpiada.model.Olimpiada;
import usjt.olimpiada.model.Pais;

public class OlimpiadaDAO {

	public boolean criar(Olimpiada olimpiada) {
		boolean gravado = false;
		String sqlInsert = "INSERT INTO olimpiada( ouro, prata, bronze, tipo, idPais, idAno, idModalidade) VALUES (?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, olimpiada.getOuro());
			stm.setInt(2, olimpiada.getPrata());
			stm.setInt(3, olimpiada.getBronze());
			stm.setString(4, String.valueOf(olimpiada.getAno().getTipo()));
			stm.setInt(5, olimpiada.getPais().getId());
			stm.setInt(6, olimpiada.getAno().getAno());
			stm.setInt(7, olimpiada.getModalidade().getId());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId(rs.getInt(1));
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

	public boolean atualiza(Olimpiada olimpiada) {
		boolean gravado = false;
		String sqlUpdate = "UPDATE olimpiada SET ouro=?, prata=?, bronze=?, tipo=? "
						 + "WHERE idPais=? AND idAno=? AND idModalidade=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, olimpiada.getOuro());
			stm.setInt(2, olimpiada.getPrata());
			stm.setInt(3, olimpiada.getBronze());
			stm.setString(4, String.valueOf(olimpiada.getTipo()));
			stm.setInt(5, olimpiada.getPais().getId());
			stm.setInt(6, olimpiada.getAno().getAno());
			stm.setInt(7, olimpiada.getModalidade().getId());
			stm.execute();
			
			gravado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return gravado;
	}

	public boolean excluir(Olimpiada olimpiada) {
		boolean exclude = false;
		String sqlDelete = "DELETE FROM olimpiada "
						+ "WHERE idPais=? AND idAno=? AND idModalidade=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, olimpiada.getPais().getId());
			stm.setInt(2, olimpiada.getAno().getAno());
			stm.setInt(3, olimpiada.getModalidade().getId());
			stm.execute();
			
			exclude = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exclude;
	}

	public Olimpiada carregar(Olimpiada olimpiadaSelecionada) {
		Olimpiada olimpiada = new Olimpiada();
		String sqlSelect = "SELECT id_olimpiada, ouro, prata, bronze, tipo FROM olimpiada "
						 + "WHERE idPais=? AND idAno=? AND idModalidade=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, olimpiadaSelecionada.getPais().getId());
			stm.setInt(2, olimpiadaSelecionada.getAno().getAno());
			stm.setInt(3, olimpiadaSelecionada.getModalidade().getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId(rs.getInt("id_olimpiada"));
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
					olimpiada.setTipo(rs.getString("tipo").charAt(0));
					
					Pais pais = new Pais();
					pais.setId(olimpiadaSelecionada.getPais().getId());
					
					Modalidade modalidade = new Modalidade();
					modalidade.setId(olimpiadaSelecionada.getModalidade().getId());
					
					Ano ano = new Ano();
					ano.setAno(olimpiadaSelecionada.getAno().getAno());
					
					olimpiada.setPais(pais);
					olimpiada.setModalidade(modalidade);
					olimpiada.setAno(ano);
					
				} else {
					olimpiada.setId(-1);
					olimpiada.setOuro(0);
					olimpiada.setPrata(0);
					olimpiada.setBronze(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return olimpiada;

	}
	
	
	/**
	 * Criar queries para buscar vários tipos de dados:
	 * Listagem de todas as olimpiadas por ordem decrescente de cadastro(
	 * 
	 * ********Maiores Medalhistas********
	 * Count(ouro),Count(prata),Count(bronze), total(soma das tres)
	 * @return
	 * @throws IOException
	 */
	
	public ArrayList<Olimpiada> listaQuadro() throws IOException {
		ArrayList<Olimpiada> olimpiadas = new ArrayList<>();
		String sqlSelect = "SELECT o.ouro, o.prata, o.bronze, o.tipo, p.id_pais, p.nome, o.idAno, o.idPais, o.idModalidade "
						 + "FROM olimpiada o "
						 + "INNER JOIN pais p ON o.idPais = p.id_pais";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Olimpiada olimpiada = new Olimpiada();
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
					olimpiada.setTipo(rs.getString("tipo").charAt(0));
					
					Pais pais = new Pais();
					pais.setId(rs.getInt("id_pais"));
					pais.setNome(rs.getString("nome"));
					olimpiada.setPais(pais);
					
					Ano ano = new Ano();
					ano.setAno(rs.getInt("idAno"));
					ano.setTipo(rs.getString("tipo").charAt(0));
					olimpiada.setAno(ano);
					
					Modalidade modalidade = new Modalidade();
					modalidade.setId(rs.getInt("idModalidade"));
					olimpiada.setModalidade(modalidade);
					
					olimpiadas.add(olimpiada);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return olimpiadas;

	}
	
	public ArrayList<Olimpiada> maioresMedalhistasTotal() throws IOException {
		ArrayList<Olimpiada> olimpiadas = new ArrayList<>();
		String sqlSelect = "SELECT ol.id_olimpiada, SUM(ol.ouro) as ouro, SUM(ol.prata) as prata, SUM(ol.bronze) as bronze, "
						 + "ol.tipo, ol.idPais, ol.idAno "
						 + "p.id_pais, p.nome "
						 + "	FROM olimpiada ol "
						 + "INNER JOIN pais p ON ol.idPais = p.id_pais"
						 + "group by ol.idPais";
		
		//calcular o total com jstl na jsp durante o forEach:
		/*
		 * Exemplo:
			<c:forEach var="article" items="${list}">
			    <c:set var="total" value="${total + article.price}" />
			</c:forEach>
		 */
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Olimpiada olimpiada = new Olimpiada();
					olimpiada.setId(rs.getInt("id_olimpiada"));
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
					
					Pais pais = new Pais();
					pais.setId(rs.getInt("idPais"));
					pais.setNome(rs.getString("nome"));
					olimpiada.setPais(pais);
					
					Ano ano = new Ano();
					ano.setAno(rs.getInt("idAno"));
					
					olimpiadas.add(olimpiada);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return olimpiadas;

	}
}
