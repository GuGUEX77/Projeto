package figuras;

public class Triangulo extends Poligono{

	public Triangulo(double base, double altura) {
		super(base, altura);
	}
	
	public double area() {
		return (getBase() * getAltura())/2.0;
	}
	
	@Override
	public double perimetro() {
		return 3.0 * getBase(); //vale somente para triangulos equilateros
	}

	@Override
	public String toString() {
		return "Triangulo [getBase()=" + getBase() + ", getAltura()=" + getAltura() + "]";
	}

}
