package usjt.olimpiada.service;

import java.io.IOException;
import java.util.ArrayList;

import usjt.olimpiada.dao.OlimpiadaDAO;
import usjt.olimpiada.model.Olimpiada;

public class OlimpiadaService {

	OlimpiadaDAO dao = new OlimpiadaDAO();
	
	public boolean criar(Olimpiada olimpiada) {
		olimpiada.setTipo(olimpiada.getAno().getTipo());
		return dao.criar(olimpiada);
	}
	
	public boolean atualizar(Olimpiada olimpiada) {
		return dao.atualiza(olimpiada);
	}

	public boolean excluir(Olimpiada olimpiada) {
		return dao.excluir(olimpiada);
	}

	public Olimpiada carregar(Olimpiada olimpiada) {
		return dao.carregar(olimpiada);
	}
	
	public ArrayList<Olimpiada> listaQuadro() throws IOException {
		return dao.listaQuadro();
	}
	
}
