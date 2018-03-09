package figuras;

public class Quadrado extends Quadrilatero implements Diagonal{

	public Quadrado(double lado) {
		super(lado, lado);
	}
	
	public double diagonal() {
		return getBase() * Math.sqrt(2.0);
	}

	@Override
	public String toString() {
		return "Quadrado [getLado()=" + getBase() + "]";
	}

}
