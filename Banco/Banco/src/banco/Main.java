package banco;

import java.util.Scanner;

import model.ContaCorrente;
import util.Keyboard;

public class Main {
	
	static ContaCorrente[] contas = new ContaCorrente[10];
	static int qtd_contas = 0;

	public static void main(String[] args) {		
		
		int opcao = 0;			
		do{
			opcao = Keyboard.menu("Cadastrar Contas/Listar Contas/Sair");
			switch(opcao)
			{
				case 1:
					CadastrarContas();
					break;
				case 2:
					ListarContas();
					break;
			}
			
		} while(opcao < 3);
		
		System.out.println("Fim do programa!");		

	}
	
	public static void CadastrarContas()
	{	
		ContaCorrente conta = new ContaCorrente(qtd_contas++);
		String nome = Keyboard.readString("Informe o nome: ");		
		conta.setNome_do_cliente(nome);
		conta.setCredito_especial(100);		
		contas[qtd_contas] = conta;
		qtd_contas = qtd_contas + 1;
	}
	
	public static void ListarContas()
	{
		for(int i = 0; i < qtd_contas; i++) 
		{
			System.out.print("Numero da conta:");
			System.out.println(contas[i].getNumero_da_conta());
			System.out.print("Nome do cliente:");
			System.out.println(contas[i].getNome_do_cliente());
			System.out.print("Saldo:");
			System.out.println(contas[i].getSaldo_da_conta());
			System.out.print("Credito Especial:");
			System.out.println(contas[i].getCredito_especial());
		}
	}
	
	
}
