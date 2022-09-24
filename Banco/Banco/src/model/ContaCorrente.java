package model;

public class ContaCorrente {

    private int numero_da_conta;
    private String nome_do_cliente;
    private double saldo_da_conta;
    private double credito_especial;
	
	public ContaCorrente(int numero_da_conta)
	{
		this.numero_da_conta = numero_da_conta;
		this.nome_do_cliente = "";
		this.saldo_da_conta = 0.0;
		this.credito_especial = 0.0;
	}

	public String getNome_do_cliente() {
		return nome_do_cliente;
	}

	public void setNome_do_cliente(String nome_do_cliente) {
		this.nome_do_cliente = nome_do_cliente;
	}

	public double getCredito_especial() {
		return credito_especial;
	}

	public void setCredito_especial(double credito_especial) {
		this.credito_especial = credito_especial;
	}

	public int getNumero_da_conta() {
		return numero_da_conta;
	}

	public double getSaldo_da_conta() {
		return saldo_da_conta;
	}
	
	public String Sacar(double valorSaque)
	{
		return "";
	}
	
	public String Deposito(double valorDeposito)
	{
		return "";
	}
	
	public void Imprimir()
	{
		System.out.print("Teste");
	}
	
	
	
}
