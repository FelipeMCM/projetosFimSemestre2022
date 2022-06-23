package ByteBank;

import java.io.Serializable;

public class ContaCorrente extends Conta implements Tributavel{
	
//Construtores não se herdam automaticamente!
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);						//Nesse caso o super está chamando o construtor específico da super class para ser executado, sendo necessário ficar de acordo com os parâmetros do construtor pai.
	}												//Dessa maneira consegue-se reutilizar um construtor.
	@Override									//"@Override" significa que estou sobrescrevendo o método abaixo.Isso com o "@" é uma anotação no JAVA.
		public void saca(double valor) throws SaldoInsuficienteException {
			double valorASacar = valor + 0.20;
			super.saca(valorASacar);					//Reutilização de código.
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
