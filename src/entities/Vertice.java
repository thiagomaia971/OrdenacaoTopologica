package entities;

public class Vertice {
	
	private int PosicaoVertice;
	
	public Vertice(int posicaoVertice){
		this.PosicaoVertice = posicaoVertice;
	}

	public int getPosicaoVertice() {
		return PosicaoVertice;
	}

	public void setPosicaoVertice(int posicaoVertice) {
		PosicaoVertice = posicaoVertice;
	}
	
	@Override
	public String toString(){
		return this.PosicaoVertice+"";
	}
	
}
