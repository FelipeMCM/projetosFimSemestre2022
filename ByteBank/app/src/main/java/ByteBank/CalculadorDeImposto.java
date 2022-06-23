package ByteBank;





public class CalculadorDeImposto {
	
	private double totalImposto;
	
	
	
	
	public void registra(Tributavel t) {					//Escrever o tipo "Tributavel" no par�metro "t" � polimorfismo
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
	
	
	
}
