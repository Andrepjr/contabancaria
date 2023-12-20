package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
	System.out.println("\nCriar Contas\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(),123,1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(),124,1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),125,2, "Mariana dos Santos",4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(),125,2, "Juliana Ramos",8000f, 15);
		contas.cadastrar(cp2);


		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_WHITE_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                VORTEX BANK                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nVortex Bank - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
				
				System.out.println("Digite o numero da Agencia: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do{
					System.out.println("Digite o Tipo da conta (1-CC ou 2-CP) ");
					tipo = leia.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 ->{
					System.out.println("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
			}
		}
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: André Prado Junior ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/Andrepjr/contabancaria");
		System.out.println("*********************************************************");
	}

}