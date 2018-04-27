package usjt.olimpiada.service;

import java.util.ArrayList;

import usjt.olimpiada.dao.PaisDAO;
import usjt.olimpiada.model.Pais;

public class PaisService {

	PaisDAO paisDAO = new PaisDAO();
	
	public boolean criar(Pais pais) {
		return paisDAO.criar(pais);
	}
	
	public boolean atualizar(Pais pais) {
		return paisDAO.atualiza(pais);
	}

	public boolean excluir(int idPais) {
		return paisDAO.excluir(idPais);
	}

	public Pais carregar(int idPais) {
		return paisDAO.carregar(idPais);
	}
	
	public ArrayList<Pais> buscaPaises() {
		return paisDAO.buscaPaises();
	}
	
	public Pais paisMaiorPopulacao() {
		return paisDAO.paisMaiorPopulacao();
	}
	
	public Pais paisMenorArea() {
		return paisDAO.paisMenorArea();
	}
	
	public ArrayList<Pais> retornaTresPaises() {
		return paisDAO.retornaTresPaises();
	}
}
