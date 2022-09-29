package banco;

import model.Cliente;

import model.ContaCorrente;
import util.Keyboard;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Throwable {
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println(" ");
		System.out.println("======================= Bem-vindo ao Banco ========================");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<ContaCorrente> contasCorrentes = new ArrayList<>();
		int option = 0;

        while (option != 8) {
			interfaceBanco();
			System.out.print("Opcao: ");
            String opcao = reader.readLine();
            option = Integer.parseInt(opcao);

            switch (option) {
            case 1 -> cadastrarContas(reader, contasCorrentes);
            case 2 -> listarContas(contasCorrentes);
			case 3 -> excluirContas(reader, contasCorrentes);
			case 4 -> efetuarDepositos(reader,contasCorrentes);
			case 5 -> efetuarSaques(reader,contasCorrentes);
			case 6 -> consultarContas(contasCorrentes, reader);
			case 7 -> efetuarTransferencia (reader, contasCorrentes);
            }
        }
	}


	private static void interfaceBanco() {
		System.out.println("Selecione uma opcao:");
		System.out.println("        1. Cadastrar Contas");
		System.out.println("        2. Listar Contas");
		System.out.println("        3. Excluir Contas");
		System.out.println("        4. Efetuar Depositos");
		System.out.println("        5. Efetuar Saques ");
		System.out.println("        6. Consular Contas ");
		System.out.println("        7. Efetuar Transferencia entre contas ");
		System.out.println("        8. Exit ");
		System.out.println("===========================================================================================");
	}

	
	private static void efetuarSaques(BufferedReader reader, List<ContaCorrente> contasCorrentes) throws IOException {
		long numeroDaConta;
		double valorSaque;

		layoutAba("Saque");

		System.out.print("Digite o numero da conta que voce deseja sacar: ");
		numeroDaConta = Long.parseLong(reader.readLine());
		System.out.println(" ");

		System.out.print("Digite o valor do saque: ");
		valorSaque = Long.parseLong(reader.readLine());

		for(ContaCorrente contaCorrente : contasCorrentes){
			if(numeroDaConta == contaCorrente.getNumeroDaConta()){
				contaCorrente.sacar(valorSaque);
				System.out.println(" ");
			}
		}
	}
	
	private static void efetuarTransferencia(BufferedReader reader, List<ContaCorrente> contasCorrentes) throws IOException {
		long numeroDaConta;
		double valorTransferir;
		double contaDestinataria;

		layoutAba("Transferir");

		System.out.print("Digite o numero da conta remetente: ");
		numeroDaConta = Long.parseLong(reader.readLine());
		System.out.println(" ");
		
		
		System.out.print("Digite a conta que destinataria: ");
		contaDestinataria = Long.parseLong(reader.readLine());
		System.out.print(" ");
		
		
		System.out.print("Digite o valor de transferencia: ");
		valorTransferir = Long.parseLong(reader.readLine());
		System.out.print(" ");
		
		for(ContaCorrente contaCorrente : contasCorrentes) {
			if (numeroDaConta == contaCorrente.getNumeroDaConta()) {
				contaCorrente.sacar(+ valorTransferir);
			}
		}
		
			for(ContaCorrente contaCorrente1 : contasCorrentes) {
			if  (contaDestinataria == contaCorrente1.getNumeroDaConta()){
					contaCorrente1.depositar( + valorTransferir);
					
					System.out.println("Transferencia realizada com sucesso!");
				}
				}
			} 
	
	private static void efetuarDepositos(BufferedReader reader, List<ContaCorrente> contasCorrentes) throws IOException {
		long numeroDaConta;
		double valorDeposito;

		layoutAba("Deposito");

		System.out.print("Digite o numero da conta que voce deseja depositar: ");
		numeroDaConta = Long.parseLong(reader.readLine());
		System.out.println(" ");
		System.out.print("Digite o valor do deposito: ");
		valorDeposito = Long.parseLong(reader.readLine());

		for(ContaCorrente contaCorrente : contasCorrentes){
			if(numeroDaConta == contaCorrente.getNumeroDaConta()){
					contaCorrente.depositar(valorDeposito);
					System.out.println(" ");
			}
		}
	}

	private static void layoutAba(String aba) {
		System.out.println(" ");
		System.out.println("--------------------------------------------");
		System.out.println(aba);
		System.out.println("--------------------------------------------");
		System.out.println(" ");
	}

	public static void excluirContas(BufferedReader reader, List<ContaCorrente> contasCorrentes) throws IOException {
		System.out.println(" ");
		System.out.println("--------------------------------------------");
		System.out.println("Excluir Conta");
		System.out.println("--------------------------------------------");
		System.out.println(" ");
		System.out.print("Digite o numero da conta que voce deseja excluir: ");
		System.out.println(" ");

		long numeroDaConta = Long.parseLong(reader.readLine());

		for (int i = 0; i < contasCorrentes.size(); i++) {
			if (numeroDaConta == contasCorrentes.get(i).getNumeroDaConta()) {
				contasCorrentes.remove(contasCorrentes.get(i));
				System.out.println(" ");
				System.out.println("Conta Removido com sucesso!!");
				System.out.println(" ");
			}
		}
	}

	public static void consultarContas(List<ContaCorrente> contasCorrentes, BufferedReader reader) throws IOException {

		System.out.println(" ");
		System.out.println("--------------------------------------------");
		System.out.println("Consultar Conta");
		System.out.println("--------------------------------------------");
		System.out.println(" ");
		System.out.print("Digite o numero da conta que voce deseja buscar: ");
		System.out.println(" ");

		long numeroDaConta = Long.parseLong(reader.readLine());

		for(ContaCorrente contaCorrente : contasCorrentes){
			if(numeroDaConta == contaCorrente.getNumeroDaConta()){
				System.out.println(contaCorrente.imprimirDados());
			}
		}
	}

    public static void listarContas(List<ContaCorrente> contas){
        System.out.println(" ");
        System.out.println("------------ Lista de Contas ------------");
		System.out.println(" ");

		if(contas.isEmpty()){
			System.out.println(" ");
			System.out.println("Nao ha contas registradas");
			System.out.println(" ");
		}

        for (ContaCorrente conta : contas) {
            System.out.println(conta);
            System.out.println(" ");
        }
    }

	public static void cadastrarContas(BufferedReader reader, List<ContaCorrente> contasCorrentes) throws Throwable {

		Long numeroDaConta;
		String nome;
		double saldo = 0;
		double creditoEspecial = 100;

		System.out.println(" ");
		System.out.println("--------------------------------------------");
		System.out.println("Cadastro de conta");
		System.out.println("--------------------------------------------");

		System.out.print("Informe o numero da conta:");
		numeroDaConta = Long.parseLong(reader.readLine());

        verificarNumeroDeConta(contasCorrentes, numeroDaConta);

        System.out.print("Qual o nome do cliente:");
		nome = reader.readLine();

		Cliente cliente = new Cliente(nome);
		ContaCorrente conta = new ContaCorrente(numeroDaConta, cliente, saldo, creditoEspecial);
		contasCorrentes.add(conta);
		System.out.println(" ");
		System.out.println("Conta cadastrada com sucesso!");
		System.out.println(" ");

	}

	//mexer depois
    public static void verificarNumeroDeConta(List<ContaCorrente> contasCorrentes, Long numeroDaConta) {

        for(ContaCorrente contaCorrente : contasCorrentes){
            if(numeroDaConta == contaCorrente.getNumeroDaConta()){
				System.err.println("Ja existe uma conta com esse numero! Cadastre uma conta com um numero diferente");
            }
        }
    }
}
