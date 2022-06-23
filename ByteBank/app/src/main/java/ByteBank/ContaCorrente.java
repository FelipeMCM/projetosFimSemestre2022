package ByteBank;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Tributavel{
	
//Construtores n�o se herdam automaticamente!
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);						//Nesse caso o super est� chamando o construtor espec�fico da super class para ser executado, sendo necess�rio ficar de acordo com os par�metros do construtor pai.
	}												//Dessa maneira consegue-se reutilizar um construtor.
	@Override									//"@Override" significa que estou sobrescrevendo o m�todo abaixo.Isso com o "@" � uma anota��o no JAVA.
		public void saca(double valor) throws SaldoInsuficienteException {
			double valorASacar = valor + 0.20;
			super.saca(valorASacar);					//Reutiliza��o de c�digo.
		}
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
		
	}
	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
	@Override
		public String toString() {
			return "Conta Correntee, "+ super.toString();
		}
	
}
