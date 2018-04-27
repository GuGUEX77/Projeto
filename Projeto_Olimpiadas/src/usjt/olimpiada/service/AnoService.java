package usjt.olimpiada.service;

import java.io.IOException;
import java.util.ArrayList;

import usjt.olimpiada.dao.AnoDAO;
import usjt.olimpiada.model.Ano;

public class AnoService {

	AnoDAO dao = new AnoDAO();
	
	public void criar(Ano ano) {
		dao.criar(ano);
	}
	
	public void atualizar(Ano ano) {
		dao.atualiza(ano);
	}

	public void excluir(Ano ano) {
		dao.excluir(ano);
	}

	public Ano carregar(int idAno) {
		return dao.carregar(idAno);
	}
	
	public ArrayList<Ano> buscaAnos() throws IOException {
		return dao.buscaAnos();
	}
	
	public ArrayList<Ano> testeAno(){
		
		ArrayList<Ano> anos = new ArrayList<>();
		
		for (int i = 2002; i <= 2018; i += 2) {
			Ano ano = new Ano();
			ano.setAno(i);
			ano.setTipo("V".charAt(0));
			anos.add(ano);
		}
		
		return anos;
	}
}
