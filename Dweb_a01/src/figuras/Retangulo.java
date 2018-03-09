package figuras;

public class Retangulo extends Quadrilatero implements Diagonal {

	public Retangulo(double base, double altura) {
		super(base, altura);
	}
	
	public double diagonal() {
		return Math.sqrt(Math.pow(getAltura(), 2.0) +
				Math.pow(getBase(), 2.0));
				
	}

	@Override
	public String toString() {
		return "Retangulo [getBase()=" + getBase() + ", getAltura()=" + getAltura() + "]";
	}
	
}
