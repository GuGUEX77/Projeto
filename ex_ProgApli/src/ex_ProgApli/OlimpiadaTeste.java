package ex_ProgApli;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)
	public class OlimpiadaTeste {
		Olimpiada olimpiada, tipo;
		static int ano = 0;
		
		@Before
		public void setUp() throws Exception {
			System.out.println("setup");
			olimpiada = new Olimpiada("Verão", 1991);
			System.out.println(olimpiada);
		}
		
@Test
		public void testCarregar() {
			System.out.println("carregar");
			Olimpiada fixture = new Olimpiada("Verão", 1991);
			Olimpiada novo = new Olimpiada(null, 1991);
			novo.carregar();
			assertEquals("testa inclusão", novo, fixture);
			
			
		}
		
		
		
		
		
	}



