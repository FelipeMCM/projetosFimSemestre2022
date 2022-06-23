package ByteBank;

public class GuardadorDeContas {
	
	private Conta[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeContas() {
		this.referencias = new Conta[10];
		this.posicaoLivre = 0;
	}
	
	public void adiciona(Conta ref) {
		this.referencias[posicaoLivre] = ref;
		this.posicaoLivre++;
		
	}

	public int getNumeroDeElementos() {
		return this.posicaoLivre;
	}

	public Conta getReferenciasComPosicao(int posicao) {
		return this.referencias[posicao];
		
	}
	

}
