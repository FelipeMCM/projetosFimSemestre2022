//Pr�ncipio de encapsulamento � declarar um atributo como privado.
//� rar�ssima as exce��es em que os atributos n�o s�o privados.
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
	protected double saldo;			//Quando o atributo � privado, significa que ele n�o pode ser modificado nem lido por outra classe a n�o ser sua pr�pria.
	private int agencia;
	private int numero;
	private Cliente titular;				//Poderia se referenciar para um novo objeto escrevendo "Cliente titular = new Cliente();".
	private static int totalDeContas;
	
//	public Conta() {				Adicionando esse construtor padr�o para compilar o c�digo de alguma classe filho.
//		
//	}   							N�o se herda construtores especificos.
	
	
	
/**
 * Construtor para inicializar o objeto Conta a partir da agencia e n�mero.
 * 
 * @param agencia
 * @param numero
 */
	
//O construtor abaixo serve para a inicializa��o de atributos.
	public Conta(int agencia, int numero) {					//Isso � um construtor. Sintaticamente n�o � um m�todo.Executa algo sempre que o objeto conta for inicializado.
		Conta.totalDeContas++;							//Tamb�m � v�lido deixar s� "totalDeContas++".
		System.out.println("O total de contas �: " + Conta.totalDeContas);
		this.agencia = agencia;
		this.numero = numero;
		
		System.out.println("Bem vindo sua ag�ncia � " + agencia + " e seu n�mero de conta � " + numero);
	}
	
//ABAIXO: o "double valor" � o que recebe no m�todo(Argumento do m�todo)[PAR�METROS DO M�TODO].
	public abstract void deposita(double valor); // O void � o que devolve para o usu�rio, nesse caso n�o devolve nada pois est�
											// escrito "void".
		

/**
 * Valor precisa ser maior do que o saldo!
 * 
 * @param valor
 * @throws SaldoInsuficienteException
 */
	public void saca(double valor) throws SaldoInsuficienteException{
		if(this.saldo < valor) {						//O uso do "this" em um m�todo � para acessar um atributo.
			throw new SaldoInsuficienteException("Exce��o -> Saldo: " + this.saldo + " valor: " + valor);
		} 
		this.saldo -= valor;
	}
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
			this.saca(valor);
			destino.deposita(valor);
			
		
	}
	public double getSaldo() {					//O "get" n�o � palavra-chave no JAVA. Mas sim uma boa pr�tica de escrever o c�digo querendo dizer que est� pegando algo.
		return this.saldo;
	}
	
	
	public int getNumero() {
		return this.numero;
		
	}
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Erro de valor inv�lido");
			return;
		}
		this.numero = numero;
		
	}
	
	
	public int getAgencia() {
		return this.agencia;
	}
	public void setAgencia(int agencia) {		//� comum os c�digos serem escritos assim.
		if(agencia <= 0) {
			System.out.println("Erro de valor menor ou igual a zero!");
			return;
		}
		this.agencia = agencia;					//O valor do atributo(par�metro do m�todo) ter o mesmo nome que o nome do atributo.
	}
	
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public Cliente getTitular() {
		return this.titular;
		
	}
	
	public static int getTotalDeContas() {				//Com o "static" d� pra acessar um m�todo com o nome da classe sem precisar ser com a vari�vel refer�ncia do objeto.
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
		return "N�mero: " + this.numero + " Agencia: " + this.agencia + " Saldo: " + this.saldo; 
	}
}



//Normalmente m�todos que alteram um atributo s�o do tipo "void".