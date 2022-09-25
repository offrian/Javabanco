package model;

public class ContaCorrente {

    private Long numeroDaConta;
    private Cliente nomeDoCliente;
    private double saldoDaConta;
    private double creditoEspecial;

	public ContaCorrente(Long numeroDaConta, Cliente nomeDoCliente, double saldoDaConta,
						 double creditoEspecial) {
		this.numeroDaConta = numeroDaConta;
		this.nomeDoCliente = nomeDoCliente;
		this.saldoDaConta = saldoDaConta;
		this.creditoEspecial = creditoEspecial;
	}

	public ContaCorrente(Long numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public Long getNumeroDaConta() {
		return numeroDaConta;
	}

	public Cliente getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(Cliente nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public double getSaldoDaConta() {
		return saldoDaConta;
	}

	public double getCreditoEspecial() {
		return creditoEspecial;
	}

	public void setCreditoEspecial(double creditoEspecial) {
		this.creditoEspecial = creditoEspecial;
	}

	public void sacar(double valorSaque){

		double valorSomadoComCreditoEspecial = saldoDaConta + creditoEspecial;

		if(valorSaque > saldoDaConta && valorSaque <= valorSomadoComCreditoEspecial){
			double calculo = (saldoDaConta - valorSaque) + creditoEspecial;
			this.creditoEspecial = calculo;
		}

		if(valorSomadoComCreditoEspecial < valorSaque){
			System.out.println("Saldo insuficiente para saque.");
		}else{
			 double saldoFinal = saldoDaConta -= valorSaque;
			System.out.println("Voce fez um saque de R$" + valorSaque +
					", seu saldo em conta e: R$" + saldoFinal);
		}
	}

	public void depositar(double valor){

		double valorAtualDoCreditoEspecial;

		double valorSomado = this.saldoDaConta += valor;

		if (this.creditoEspecial < 100){
			valorAtualDoCreditoEspecial = creditoEspecial - 100;

			while (valorAtualDoCreditoEspecial != 101){
				valorSomado --;
				this.creditoEspecial = valorAtualDoCreditoEspecial++;
			}
		}
	}

	public String imprimirDados(){
		return toString();
	}

	@Override
	public String toString() {
		return "Num Conta        Nome do Cliente 		  Saldo       " +
				"--------- ------------------------------ ----------\n" +
				numeroDaConta + "             " + nomeDoCliente.getNome() + "                 " + saldoDaConta ;
	}

}
