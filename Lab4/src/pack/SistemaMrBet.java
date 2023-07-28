package pack;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sistema de apostas que armazena e interage com os times, campeonatos e apostas cadastradas
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class SistemaMrBet {
/**
 * apostasCadastradas armazena as apostas cadastradas em uma lista.
 * mapaIdTime armazena em um hashmap os Times cadastrados, relacionando eles com seus respectivos Id's.
 * mapaIdTime armazena em um hashmap os Campeonatos cadastrados, relacionando eles com seus respectivos nomes.
 */
	private ArrayList<Aposta> apostasCadastradas = new ArrayList<>();
	private HashMap<String, Time> mapaIdTime = new HashMap<>();
	private HashMap<String, Campeonato> mapaNomeCampeonato = new HashMap<>();

/**
 * Instancia um time e cadastra ele no mapa de mapaIdTime.
 * 
 * @param id id do Time.
 * @param nome nome do Time.
 * @param mascote mascote do Time.
 * @return "TIME JÁ EXISTE!" caso o time já tenha sido cadastrado e "INCLUSÃO REALIZADA!" caso o contrário.
 * @throws IllegalArgumentException caso algum dos parâmetros seja nulo ou String vazia
 */
	public String cadastrarTime(String id, String nome, String mascote) {
		if (nome == null || id == null || mascote == null) {throw new IllegalArgumentException();}
		if (nome == "" || id == "" || mascote == "") {throw new IllegalArgumentException();}
		Time t = new Time(id, nome, mascote);
		
		if (mapaIdTime.containsValue(t)){
			return "TIME JÁ EXISTE!";
		} else {
			mapaIdTime.put(id, t);
			return "INCLUSÃO REALIZADA!";
		}
	}
/**
 * procura e retorna um determinado Time, a partir do seu id.
 * 
 * @param idTime id do Time a ser procurado.
 * @return "TIME NÃO EXISTE!" caso o Time não esteja cadastrado, caso contrário retorna o toString do Time.
 */
	public String recuperarTime(String idTime) {
		if (!(mapaIdTime.containsKey(idTime))) {return "TIME NÃO EXISTE!";}
		
		Time t = mapaIdTime.get(idTime);
		return t.toString();
	}
/**
 * Instancia um Campeonato e cadastra ele no mapa mapaNomeCampeonato.
 *  
 * @param nomeCamp nome do campeonato.
 * @param qntParticipantes quantidade de participantes do campeonato.
 * @return "CAMPEONATO JÁ EXISTE!" caso o campeonato já tenha sido cadastrado, caso contrário retorna "CAMPEONATO ADICIONADO!".
 * @throws IllegalArgumentException caso o nome do campeonato seja nulo ou String vazia.
 */
	public String cadastrarCampeonato(String nomeCamp, int qntParticipantes) {
		if (nomeCamp == null) {throw new IllegalArgumentException();}
		if (nomeCamp == "") {throw new IllegalArgumentException();}
		
		Campeonato c = new Campeonato(nomeCamp, qntParticipantes);
		if (this.mapaNomeCampeonato.containsValue(c)) {
			return "CAMPEONATO JÁ EXISTE!";
		} else {
			mapaNomeCampeonato.put(nomeCamp, c);
			return "CAMPEONATO ADICIONADO!";
		}
	}
/**
 * inclui um Time em um determinado Campeonato, a partir do id do Time e do nome do Campeonato.
 * 
 * @param idTime id do Time a ser incluído.
 * @param nomeCampe nome do Campeonato a receber o time.
 * @return "TIME NÃO EXISTE!" ou "CAMPEONATO NÃO EXISTE!" caso um dos dois não esteja cadastrado. caso contrário,
 * retorna o resultado do método adicionaTime, onde o Time será adicionado caso não exceda a quantidade de participantes
 * do Campeonato.
 */
	public String incluirTimeCamp(String idTime, String nomeCampe) {
		if (!(mapaIdTime.containsKey(idTime))) {return "TIME NÃO EXISTE!";}
		if (!(mapaNomeCampeonato.containsKey(nomeCampe))) {return "CAMPEONATO NÃO EXISTE!";}
		
		Campeonato c = mapaNomeCampeonato.get(nomeCampe);
		Time t = mapaIdTime.get(idTime);
		return c.adicionaTime(t);
	}
/**
 * verifica se um Time está em determinado Campeonato, a partir do id do Time e do nome do Campeonato.
 * 
 * @param idTime id do Time a ser procurado.
 * @param nomeCampe nome do Campeonato que deve procurar o Time.
 * @return "TIME NAO EXISTE!" ou "CAMPEONATO NAO EXISTE!" caso um dos dois não esteja cadastrado, caso contrário
 * retorna o resultado do método verificaTime, indicando se o Time está ou não no Campeonato.
 */
	public String verificarTimeEmCamp(String idTime, String nomeCampe) {
		if (!(mapaIdTime.containsKey(idTime))) {return "TIME NÃO EXISTE!";}
		if (!(mapaNomeCampeonato.containsKey(nomeCampe))) {return "CAMPEONATO NÃO EXISTE!";}
		
		Campeonato c = mapaNomeCampeonato.get(nomeCampe);
		Time t = mapaIdTime.get(idTime);
		return c.verificaTime(t);
	}
/**
 * Exibe todos os Campeonatos que um determinado time participa, a partir do id do Time.
 * 
 * @param idTime id do Time desejado.
 * @return retorna todos os campeonatos que o Time participa no formato "Campeonato do NOME DO TIME:" + toString dos Campeonatos.
 */
	public String exibeCampeonatosTime(String idTime) {
		if (!(mapaIdTime.containsKey(idTime))) {return "TIME NÃO EXISTE!";}
		
		Time t = mapaIdTime.get(idTime);
		String out = "Campeonatos do " + t.getNome() + ":\n";
		
		for (Campeonato temp : this.mapaNomeCampeonato.values()) {
			if (temp.buscaTime(t)) {
				out += temp.toString() + "\n";
			}
		}return out;
	}
/**
 * Instancia e cadastra uma aposta na lista de apostas, a partir do id do Time, nome do Campeonato, colocação,
 * e valor que o usuário deseja apostar.
 * 
 * @param idTime id do Time a ser apostado.
 * @param nomeCampe nome do Campeonato a ser apostado.
 * @param colocacao colocação a ser apostada.
 * @param valor valor a ser apostado.
 * @return "TIME NÃO EXISTE!" ou "CAMPEONATO NÃO EXISTE!" caso um dos dois não esteja cadastrado, caso a colocação
 * seja maior que a quantidade de participantes do campeonato retorna "APOSTA NÃO REGISTRADA!", caso contrário,
 * retorna "APOSTA REGISTRADA!".
 */
	public String apostar(String idTime, String nomeCampe, int colocacao, double valor) {
		if (!(mapaIdTime.containsKey(idTime))) {return "TIME NÃO EXISTE!";}
		if (!(mapaNomeCampeonato.containsKey(nomeCampe))) {return "CAMPEONATO NÃO EXISTE!";}
		if (colocacao > mapaNomeCampeonato.get(nomeCampe).getQntParticipantes()) {return "APOSTA NÃO REGISTRADA!";}
		
		Campeonato c = mapaNomeCampeonato.get(nomeCampe);
		Time t = mapaIdTime.get(idTime);
		Aposta a = new Aposta(t, c, colocacao, valor);
		apostasCadastradas.add(a);
		return "APOSTA REGISTRADA!";
	}
/**
 * Exibe o status das apostas cadastradas na ordem em que foram cadastradas
 * 
 * @return retorna "NAO HÁ APOSTAS CADASTRADAS!" caso não haja apostadas cadastradas, caso contrário
 * retorna todas as apostas cadastradas no formato "NUMERO DA APOSTA." + toString da aposta.
 */
	public String statusApostas() {
		if (apostasCadastradas.size() == 0) {return "NÃO HÁ APOSTAS CADASTRADAS!";}
		
		String out = "";
		for (int i = 0; i < this.apostasCadastradas.size(); i++) {
			out += (i + 1) + ". " + this.apostasCadastradas.get(i).toString() + "\n";
		} return out;
	}
}