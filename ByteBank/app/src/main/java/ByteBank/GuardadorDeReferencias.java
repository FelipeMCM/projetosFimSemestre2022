package ByteBank;

public class GuardadorDeReferencias {
	
	private Object[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeReferencias() {
		this.referencias = new Object[10];
		this.posicaoLivre = 0;
	}
	
	public void adiciona(Object ref) {
		this.referencias[posicaoLivre] = ref;
		this.posicaoLivre++;
		
	}

	public int getNumeroDeElementos() {
		return this.posicaoLivre;
	}

	public Object getReferenciasComPosicao(int posicao) {
		return this.referencias[posicao];
		
	}
	

}
