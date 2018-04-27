package usjt.olimpiada.model;

public class Olimpiada {

	private int id;
	private Pais pais;
	private Modalidade modalidade;
	private Ano ano;
	private int ouro;
	private int prata;
	private int bronze;
	private char tipo;

	
	public Olimpiada() {
		
	}
	
	public Olimpiada(int id, Pais pais, Modalidade modalidade, Ano ano, int ouro, int prata, int bronze, char tipo) {
		super();
		this.id = id;
		this.pais = pais;
		this.modalidade = modalidade;
		this.ano = ano;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Modalidade getModalidade() {
		return modalidade;
	}
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	public Ano getAno() {
		return ano;
	}
	public void setAno(Ano ano) {
		this.ano = ano;
	}
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	public int getPrata() {
		return prata;
	}
	public void setPrata(int prata) {
		this.prata = prata;
	}
	public int getBronze() {
		return bronze;
	}
	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Olimpiada [id="+ id + ", pais=" + pais + ", modalidade=" + modalidade + ", ano=" + ano + ", ouro=" + ouro + ", prata="
				+ prata + ", bronze=" + bronze + ", tipo=" + tipo + "]";
	}
	
}
