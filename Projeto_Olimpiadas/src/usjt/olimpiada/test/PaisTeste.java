package usjt.olimpiada.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import usjt.olimpiada.model.Pais;
import usjt.olimpiada.service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTeste {
	Pais pais, copia;
	ArrayList<Pais> paisesMock;
	static int id = 1;
	PaisService paisService; 
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tambem que sobrecarregou o equals na classe
	 * Pais. 
	 * Certifique-se que a fixture pais1 foi criada no banco.
	 * Alem disso, a ordem de execucao dos testes eh importante; por
	 * isso a anotacao FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		
		paisService = new PaisService ();
		
		System.out.println("setup");
		pais = new Pais(id, "China", 1379302771, 9596961 );
		copia = new Pais(id, "China", 1379302771, 9596961 );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
		
		paisesMock = criaArrayMockPais();
		
	}
	
	public ArrayList<Pais> criaArrayMockPais(){
		ArrayList<Pais> paisesMock = new ArrayList<>();
		
		for (int i = 1; i <= 3; i++) {
			Pais pais = paisService.carregar(i);
			System.out.println(pais);
			paisesMock.add(pais);
		}
		
		return paisesMock;
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais novo = new Pais(1, "China", 1379302771, 9596961);
		Pais fixture = paisService.carregar(id);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		paisService.criar(pais);
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(250);
		copia.setArea(250);		
		paisService.atualizar(pais);
		paisService.carregar(id);
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		boolean expected = true;
		boolean fixture = paisService.excluir(id);
		assertEquals("testa exclusao", expected, fixture);
	}
	
	/**
	 * Exercícios Aula 02
	 */
	@Test
	public void teste04MaiorPopulacao() {
		System.out.println("Maior População");
		Pais expected = new Pais(1, "China", 1379302771, 9596961);
		Pais fixture = paisService.paisMaiorPopulacao();
		assertEquals(expected, fixture);
	}
	
	@Test
	public void teste05MenorArea() {
		System.out.println("Menor Area");
		Pais expected = new Pais(3, "Brasil", 207660929, 8515767);
		Pais fixture = paisService.paisMenorArea();
		assertEquals(expected, fixture);
	}
	
	@Test
	public void teste06VetorTresPaises() {
		System.out.println("Retorna 3 países");
		ArrayList<Pais> fixture = paisService.retornaTresPaises();
		assertEquals(paisesMock, fixture);
	}
}