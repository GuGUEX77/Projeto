package figuras;

public abstract class Poligono extends Figura{
	
	private double base, altura, raio;
	
	public Poligono(double raio) {
		super();
		this.raio = raio;
	}

	public Poligono(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Poligono [base=" + base + ", altura=" + altura + "]";
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
	
}
