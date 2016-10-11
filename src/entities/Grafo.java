package entities;

import interfaces.IGrafo;
import interfaces.ILista;
import lista.Lista;

public class Grafo implements IGrafo{

	private ILista<Aresta> listaAdj[];
	private int numeroVertices;
	
	public Grafo(int _numeroVertices){
		
		this.numeroVertices = _numeroVertices;
		
		listaAdj = new Lista[this.numeroVertices];
		
		for (int i = 0; i < listaAdj.length; i++) {
			listaAdj[i] = new Lista<Aresta>();
		}
		
	}

	@Override
	public void inserirAresta(int v1, int v2, int peso) {
		
		Aresta adj = new Aresta(v1, v2, peso); 
		this.listaAdj[v1].add(adj);
		
	}

	@Override
	public boolean isFolha(int u) {
		return (this.listaAdj[u].isEmpty());
	}

	@Override
	public Aresta proximoAdjacente(int u) {
		Aresta adj = this.listaAdj[u].next();
		
		return adj;
	}

	@Override
	public Aresta removerAresta(int u, int v, int peso) {
		Aresta aresta = new Aresta(u, v, peso);
		
		return this.listaAdj[u].remove(aresta);
		
	}

	@Override
	public Aresta removerAresta(Aresta aresta) {
		return this.listaAdj[aresta.getVerticeOrigem()].remove(aresta);
	}

	@Override
	public void imprimir() {
		
		for (int i = 0; i < this.numeroVertices; i++) {
			System.out.println("Vertice "+ i +":");
			Aresta no = this.listaAdj[i].next();
			
			while(no != null){
				System.out.println(" " + no.getVerticeAdjacente() + "("+ no.getPeso() +")");
				no = this.listaAdj[i].next();
			}
		}
		
	}

	@Override
	public int numeroVertices() {
		return this.numeroVertices;
	}
		
}
