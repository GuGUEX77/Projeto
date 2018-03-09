package figuras;

public class Trapezio extends Poligono {
	private double baseMaior;
	public Trapezio(double baseMenor, double baseMaior, double altura) {
		super(baseMenor, altura);
		this.baseMaior = baseMaior;
	}

	@Override
	public double area() {
		return ((baseMaior + getBase()) * getAltura()) / 2.0;
	}

	@Override
	public double perimetro() {
		return baseMaior + getBase()+
				2.0 * Math.sqrt( Math.pow((baseMaior - getBase()) / 2.0, 2.0) +
						Math.pow(getAltura(), 2.0));
	}

	public double getBaseMaior() {
		return baseMaior;
	}

	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	@Override
	public String toString() {
		return "Trapezio [baseMaior=" + baseMaior + ", baseMenor=" + getBase() + ", Altura=" + getAltura() + "]";
	}

}
