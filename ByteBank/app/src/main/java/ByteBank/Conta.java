//Príncipio de encapsulamento é declarar um atributo como privado.
//É raríssima as exceções em que os atributos não são privados.
package ByteBank;

import java.io.Serializable;

/**
 * Esta classe representa uma moldura de uma conta.
 * 
 * 
 * @author FelipeMCM
 * 
 * @version 0.1
 *
 */
public abstract class Conta implements Comparable<Conta>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double saldo;			//Quando o atributo é privado, significa que ele não pode ser modificado nem lido por outra classe a não ser sua própria.
	private int agencia;
	private int numero;
	private Cliente titular;				//Poderia se referenciar para um novo objeto escrevendo "Cliente titular = new Cliente();".
	private static int totalDeContas;
	
//	public Conta() {				Adicionando esse construtor padrão para compilar o código de alguma classe filho.
//		
//	}   							Não se herda construtores especificos.
	
	
	
/**
 * Construtor para inicializar o objeto Conta a partir da agencia e número.
 * 
 * @param agencia
 * @param numero
 */
	
//O construtor abaixo serve para a inicialização de atributos.
	public Conta(int agencia, int numero) {					//Isso é um construtor. Sintaticamente não é um método.Executa algo sempre que o objeto conta for inicializado.
		Conta.totalDeContas++;							//Também é válido deixar só "totalDeContas++".
		System.out.println("O total de contas é: " + Conta.totalDeContas);
		this.agencia = agencia;
		this.numero = numero;
		
		System.out.println("Bem vindo sua agência é " + agencia + " e seu número de conta é " + numero);
	}
	
//ABAIXO: o "double valor" é o que recebe no método(Argumento do método)[PARÂMETROS DO MÉTODO].
	public abstract void deposita(double valor); // O void é o que devolve para o usuário, nesse caso não devolve nada pois está
											// escrito "void".
		

/**
 * Valor precisa ser maior do que o saldo!
 * 
 * @param valor
 * @throws SaldoInsuficienteException
 */
	public void saca(double valor) throws SaldoInsuficienteException{
		if(this.saldo < valor) {						//O uso do "this" em um método é para acessar um atributo.
			throw new SaldoInsuficienteException("Exceção -> Saldo: " + this.saldo + " valor: " + valor);
		} 
		this.saldo -= valor;
	}
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
			this.saca(valor);
			destino.deposita(valor);
			
		
	}
	public double getSaldo() {					//O "get" não é palavra-chave no JAVA. Mas sim uma boa prática de escrever o código querendo dizer que está pegando algo.
		return this.saldo;
	}
	
	
	public int getNumero() {
		return this.numero;
		
	}
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Erro de valor inválido");
			return;
		}
		this.numero = numero;
		
	}
	
	
	public int getAgencia() {
		return this.agencia;
	}
	public void setAgencia(int agencia) {		//É comum os códigos serem escritos assim.
		if(agencia <= 0) {
			System.out.println("Erro de valor menor ou igual a zero!");
			return;
		}
		this.agencia = agencia;					//O valor do atributo(parâmetro do método) ter o mesmo nome que o nome do atributo.
	}
	
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public Cliente getTitular() {
		return this.titular;
		
	}
	
	public static int getTotalDeContas() {				//Com o "static" dá pra acessar um método com o nome da classe sem precisar ser com a variável referência do objeto.
		return Conta.totalDeContas;
	}
	@Override
	public boolean equals(Object umaRef) {
		
		Conta contaEquals = (Conta) umaRef;
		
		if(this.agencia != contaEquals.agencia) {
			return false;
		}
		if(this.numero != contaEquals.numero) {
			return false;
		}
		
		return true;
	}
	@Override
	public int compareTo(Conta contaCompara) {
		Double.compare(this.saldo, contaCompara.saldo);
		return 0;
	}
	
	@Override
	public String toString() {
		return "Número: " + this.numero + " Agencia: " + this.agencia + " Saldo: " + this.saldo; 
	}
}



//Normalmente métodos que alteram um atributo são do tipo "void".