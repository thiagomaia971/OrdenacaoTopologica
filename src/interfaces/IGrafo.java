package interfaces;

import entities.Aresta;

public interface IGrafo {
	
	void inserirAresta(int v1, int v2, int peso);
	boolean isFolha(int u);
	Aresta proximoAdjacente(int u);
	Aresta removerAresta(int u, int v, int peso);
	Aresta removerAresta(Aresta aresta);
	void imprimir();
	int numeroVertices();
	
}
