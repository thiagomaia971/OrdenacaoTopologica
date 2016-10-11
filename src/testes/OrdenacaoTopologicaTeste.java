package testes;

import org.junit.Test;

import entities.Grafo;
import entities.OrdenacaoTopologica;
import entities.Vertice;
import interfaces.IGrafo;
import lista.Lista;

public class OrdenacaoTopologicaTeste {

	@Test
	public void test() throws Exception {
		
		IGrafo grafo = new Grafo(6);
		
		grafo.inserirAresta(0, 1, 0);
		grafo.inserirAresta(0, 2, 0);
		
		grafo.inserirAresta(1, 3, 0);
		grafo.inserirAresta(1, 5, 0);
		
		grafo.inserirAresta(2, 5, 0);
		grafo.inserirAresta(2, 4, 0);
		
		grafo.inserirAresta(3, 5, 0);
		
		grafo.inserirAresta(4, 5, 0);
		
		OrdenacaoTopologica OT = new OrdenacaoTopologica(grafo);
		
		Lista<Vertice> listaOT = OT.Gerar();
		
		for (Vertice vertice : listaOT) {
			System.out.println(vertice);
		}
		
		
		
	}

}
