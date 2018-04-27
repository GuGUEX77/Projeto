package usjt.olimpiada.service;

import java.io.IOException;
import java.util.ArrayList;

import usjt.olimpiada.dao.ModalidadeDAO;
import usjt.olimpiada.model.Modalidade;

public class ModalidadeService {

	ModalidadeDAO dao = new ModalidadeDAO();
	
	public boolean criar(Modalidade modalidade) {
		return dao.criar(modalidade);
	}
	
	public boolean atualizar(Modalidade modalidade) {
		return dao.atualiza(modalidade);
	}

	public boolean excluir(int idModalidade) {
		return dao.excluir(idModalidade);
	}

	public Modalidade carregar(int idModalidade) {
		return dao.carregar(idModalidade);
	}
	
	public ArrayList<Modalidade> buscaModalidades() throws IOException{
		return dao.buscaModalidades();
	}
}
