package entities.buscaProfundidade;

import entities.Aresta;
import entities.Vertice;
import interfaces.IBuscaProfundidade;
import interfaces.IGrafo;
import lista.Lista;

public class BuscaProfundidadeOT implements IBuscaProfundidade {

	private static final byte BRANCO = 0;
	private static final byte CINZA = 1;
	private static final byte PRETO = 2;
	
	private IGrafo G;
	private Lista<Vertice> listaTopologica;
	
	private int cor[];
	private int antecessor[];
	private int d[];
	private int f[];
	
	private int time;
	
	private String caminho = "";
	
	@Override
	public void Gerar(IGrafo g) throws Exception{
		this.G = g;
		this.listaTopologica = new Lista<Vertice>();
		
		cor = new int[this.G.numeroVertices()];
		antecessor = new int[this.G.numeroVertices()];
		d = new int[this.G.numeroVertices()];
		f = new int[this.G.numeroVertices()];
		
		for (int i = 0; i < this.G.numeroVertices(); i++) {
			cor[i] = BRANCO;
			antecessor[i] = Integer.MAX_VALUE;
			d[i] = -1;
			f[i] = -1;
		}
		
		time = 0;
		
		for (int u = 0; u < this.G.numeroVertices(); u++) {
			if (cor[u] == BRANCO) {
				ExecuteDfs(u);
			}
		}
		
	}
	
	private void ExecuteDfs(int u){
		cor[u] = CINZA;
		d[u] = ++time;
		
		if (!this.G.isFolha(u)) {
			
			Aresta adj = this.G.proximoAdjacente(u);
			
			while(adj != null){
				int v = adj.getVerticeAdjacente();
				if (cor[v] == BRANCO) {
					antecessor[v] = u;
					ExecuteDfs(v);
				}
				adj = this.G.proximoAdjacente(u);
			}
			
			
		}
		
		cor[u] = PRETO;
		f[u] = ++time;
		this.listaTopologica.add(new Vertice(u), 1);
	}
	
	@Override
	public String CaminhoMinimo(int source, int destination){
		
		if (source == destination) {
			caminho += source;
		}else if(this.antecessor[destination] == -1){
			caminho = "Não existe caminho";
		}else {
			CaminhoMinimo(source, this.antecessor[destination]);
			caminho += " -> " + destination;
		}
		
		return caminho;
	}
	
	public Lista<Vertice> ListaOrdemTopologica(){
		return this.listaTopologica;
	}
	
}
