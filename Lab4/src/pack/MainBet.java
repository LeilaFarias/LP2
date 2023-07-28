package pack;
import java.util.Scanner;

public class MainBet {
	public static void main(String[] args) {
		
		SistemaMrBet mrbet = new SistemaMrBet();
		
		Scanner sc = new Scanner(System.in);
		String escolha = null;
		while (true) {
			escolha = menu(sc);
			comando(escolha, sc, mrbet);
		}
	}
	private static String menu(Scanner sc) {
		System.out.println(
				"\n(M)Minha inclusão de times\n" + 
				"(R)Recuperar time\n" +
				"(.)Adicionar campeonato\n" +
				"(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n" +
				"(E)Exibir campeonatos que o time participa\n" +
				"(T)Tentar a sorte e status\n" +
				"(!)Já pode fechar o programa!\n"+
				"\n" +
				"Opção> ");
		return sc.next().toLowerCase();
	}
	private static void comando(String opcao, Scanner sc, SistemaMrBet mrbet) {
		switch(opcao){
		case "m":
			incluirTime(sc, mrbet);
			break;
		case "r":
			recuperarTime(sc, mrbet);
			break;
		case ".":
			incluirCampeonato(sc, mrbet);
			break;
		case "b":
			String escolha2 = submenu(sc);
			comando2(escolha2, sc, mrbet);
			break;
		case "e":
			exibirCampeonatosTime(sc, mrbet);
			break;
		case "t":
			String escolha3 = submenuAposta(sc);
			comando3(escolha3, sc, mrbet);
			break;
		case "!":
			fecharPrograma();
		default:
			throw new IllegalArgumentException("Entrada inválida para menu");
		}
	}
	private static void comando2(String opcao2, Scanner sc, SistemaMrBet mrbet) {
		switch(opcao2){
		case "i":
			incluirTimeCampeonato(sc, mrbet);
			break;
		case "v":
			verificarTimeCampeonato(sc, mrbet);
			break;
		default:
			throw new IllegalArgumentException("Entrada inválida para submenu");
		}
	}
	private static void comando3(String opcao3, Scanner sc, SistemaMrBet mrbet) {
		switch(opcao3){
		case "a":
			apostar(sc, mrbet);
			break;
		case "s":
			statusApostas(mrbet);
			break;
		default:
			throw new IllegalArgumentException("Entrada inválida para submenu de apostas");
		}
	}
	private static String submenu(Scanner sc) {
		System.out.println(
				"(I)Incluir time em campeonato\n" +
				"(V)Verificar se time está em campeonato\n" +
				"\n" +
				"Opcão> ");
		return sc.next().toLowerCase();
	}
	private static String submenuAposta(Scanner sc) {
		System.out.println(
				"(A)Apostar\n" +
				"(S)Status das Apostas\n" +
				"\n" +
				"Opcão> ");
		return sc.next().toLowerCase();
	}
	private static String incluirTime(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira o nome do time> ");
		String nomeTime = sc.next();
		System.out.println("\nInsira a identificação do time> ");
		String idTime = sc.next();
		System.out.println("\nInsira o mascote do time> ");
		String mascoteTime = sc.next();
		String out = mrbet.cadastrarTime(idTime, nomeTime, mascoteTime);
		System.out.println(out);
		return out;
	}
	private static String recuperarTime(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira o código do time> ");
		String cod = sc.next();
		String out = mrbet.recuperarTime(cod);
		System.out.println(out);
		return out;
	}
	private static String incluirCampeonato(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira o nome do campeonato> ");
		String nome = sc.next();
		System.out.println("\nInsira a quantidade de participantes> ");
		int qnt = sc.nextInt();
		String out = mrbet.cadastrarCampeonato(nome, qnt);
		System.out.println(out);
		return out;
	}
	private static String incluirTimeCampeonato(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira id do time> ");
		String idTime = sc.next();
		System.out.println("\nInsira o nome do campeonato> ");
		String nomeCamp = sc.next();
		String out = mrbet.incluirTimeCamp(idTime, nomeCamp);
		System.out.println(out);
		return out;
	}
	private static String verificarTimeCampeonato(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira id do time> ");
		String idTime = sc.next();
		System.out.println("\nInsira nome do campeonato> ");
		String nomeCamp = sc.next();
		String out = mrbet.verificarTimeEmCamp(idTime, nomeCamp);
		System.out.println(out);
		return out;
	}
	private static String exibirCampeonatosTime(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira o id do time> ");
		String idTime = sc.next();
		String out = mrbet.exibeCampeonatosTime(idTime);
		System.out.println(out);
		return out;
	}
	private static String apostar(Scanner sc, SistemaMrBet mrbet) {
		System.out.println("\nInsira o id do time> ");
		String idTime = sc.next();
		System.out.println("\nInsira o nome do campeonato> ");
		String nomeCampe = sc.next();
		sc.nextLine();
		System.out.println("\nInsira a colocação que irá apostar> ");
		int colocacao = sc.nextInt();
		System.out.println("\nInsira o valor que deseja apostar> ");
		double valor = sc.nextDouble();
		String out = mrbet.apostar(idTime, nomeCampe, colocacao, valor);
		System.out.println(out);
		return out;
	}
	private static void statusApostas(SistemaMrBet mrbet) {
		System.out.println(mrbet.statusApostas());
	}
	private static void fecharPrograma() {
		System.out.println("\nPor hoje é só pessoal!");
		System.exit(0);
	}
}