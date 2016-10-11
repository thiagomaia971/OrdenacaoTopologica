package entities;

public class Aresta {
	private int verticeOrigem;
	private int verticeAdjacente;
	private int peso;
	
	public Aresta(int _verticeOrigem, int _verticeAdjacente, int _peso){
		
		this.verticeOrigem = _verticeOrigem;
		this.verticeAdjacente = _verticeAdjacente;
		this.peso = _peso;
		
	}

	public int getVerticeOrigem() {
		return verticeOrigem;
	}

	public void setVerticeOrigem(int verticeOrigem) {
		this.verticeOrigem = verticeOrigem;
	}

	public int getVerticeAdjacente() {
		return verticeAdjacente;
	}

	public void setVerticeAdjacente(int verticeAdjacente) {
		this.verticeAdjacente = verticeAdjacente;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
}
