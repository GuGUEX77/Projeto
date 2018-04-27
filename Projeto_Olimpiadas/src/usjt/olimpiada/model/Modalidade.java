package usjt.olimpiada.model;

public class Modalidade {

	public static char VERAO = 'V';
	public static char INVERNO = 'I';
	
	private int id;
	private String nome;
	private char tipo;
	
	public Modalidade() {
		
	}
	
	public Modalidade(int id, String nome, char tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public char getVerao() {
		return VERAO;
	}
	public char getInverno() {
		return INVERNO;
	}
	
	@Override
	public String toString() {
		return "Modalidade [id=" + id + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
	
}
