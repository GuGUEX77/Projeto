package figuras;

public class Losango extends Quadrilatero{

	public Losango(double base, double altura) {
		super(base, altura);
	}
	
	@Override
	public double perimetro() {
		return 4.0 * getBase();
	}

	@Override
	public String toString() {
		return "Losango [getBase()=" + getBase() + ", getAltura()=" + getAltura() + "]";
	}
	
}
