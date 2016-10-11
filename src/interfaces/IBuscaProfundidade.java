package interfaces;

public interface IBuscaProfundidade {

	public void Gerar(IGrafo g) throws Exception;
	public String CaminhoMinimo(int source, int destination);
	
}
