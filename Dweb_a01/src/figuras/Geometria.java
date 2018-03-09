package figuras;

import java.util.ArrayList;

public class Geometria {
	private ArrayList<Figura> figuras;
	
	public Geometria() {
		figuras = new ArrayList<Figura>();
	}
	
	public String area(Figura f) {
		return String.format(f+" area=%.2f", f.area());
	}
	
	public String perimetro(Figura f) {
		return String.format(f+" perimetro=%.2f", f.perimetro());
	}
	
	public String diagonal(Diagonal d) {
		return String.format(d+" diagonal=%.2f", d.diagonal());
	}
	
	public void add(Figura figura) {
		figuras.add(figura);
	}

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}
	
}
