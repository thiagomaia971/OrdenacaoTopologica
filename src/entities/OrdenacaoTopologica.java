package entities;

import entities.buscaProfundidade.BuscaProfundidadeOT;
import interfaces.IBuscaProfundidade;
import interfaces.IGrafo;
import lista.Lista;

public class OrdenacaoTopologica {
	
	private IBuscaProfundidade buscaProfundidade;
	
	private IGrafo grafo;
	
	public OrdenacaoTopologica(IGrafo g){
		this.grafo = g;
		this.buscaProfundidade = new BuscaProfundidadeOT();
		
	}

	public Lista<Vertice> Gerar() throws Exception{
		this.buscaProfundidade.Gerar(this.grafo);
		BuscaProfundidadeOT buscaOT = (BuscaProfundidadeOT) this.buscaProfundidade;
		
		return buscaOT.ListaOrdemTopologica();
		
	}
	
	public boolean IsUniqueOrdenacaoTopologica(){
		
		BuscaProfundidadeOT buscaOT = (BuscaProfundidadeOT) this.buscaProfundidade;
		
		return buscaOT.IsUniqueOrdenacaoTopologica();
	}
	
}
