package teste;

import figuras.Circulo;
import figuras.Diagonal;
import figuras.Figura;
import figuras.Geometria;
import figuras.Losango;
import figuras.Quadrado;
import figuras.Retangulo;
import figuras.Trapezio;
import figuras.Triangulo;

public class Teste {
	public static void main(String[] args) {
		Geometria g = new Geometria();
		g.add(new Losango(10.0, 5.0));
		g.add(new Triangulo(10.0, 5.0));
		g.add(new Retangulo(7.0, 3.0));
		g.add(new Quadrado(6.0));
		g.add(new Circulo(3.0));
		g.add(new Trapezio(20.0, 30.0, 15.0));
		
		for(Figura figura:g.getFiguras()) {
			System.out.println(g.area(figura));
			System.out.println(g.perimetro(figura));
			/*O operador instanceof testa se a classe e' subclasse de Diagonal;
			  caso contrario vai dar erro ao fazer o casting.*/
			if(figura instanceof Diagonal) {
				System.out.println(g.diagonal((Diagonal)figura));
			}
		}
	}
}
