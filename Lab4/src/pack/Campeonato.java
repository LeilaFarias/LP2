package pack;

import java.util.Objects;

/**
 * Representação de um Campeonato com uma certa quantidade de participantes
 * que é definida pelo usúario no momento da criação do campeonato,
 * assim também é com o nome do campeonato. Campeonatos são identificados
 * unicamente pelo seu nome.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Campeonato {
/**
 * participantes do campeonato.
 * nome do campeonato.
 * Um inteiro de controle para serem adicionados times ao array.
 */
	private Time[] participantes;
	private String nome;
	private int controle = 0;
	
/**
 * Constrói um campeonato a partir do seu nome e quantidade de participantes.
 *  	
 * @param nome nome do campeonato.
 * @param qntParticipantes quantidade de participantes do campeonato.
 */
	public Campeonato(String nome, int qntParticipantes) {
		this.participantes = new Time[qntParticipantes];
		this.nome = nome;
	}
/**
 * adiciona um Time ao array de participantes do campeonato.
 * 	
 * @param tim Time a ser adicionado.
 * @return retorna "TIME INCLUÍDO NO CAMPEONATO!" caso seja possível adicionar o time e
 *  "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!" caso não seja possível adicionar o time.
 */
	public String adicionaTime(Time tim) {
		for (Time temp : participantes) {
			if (temp != null && temp.equals(tim)){
				return "TIME INCLUÍDO NO CAMPEONATO!";
			}
		}
		if (controle < participantes.length) {
			participantes[controle] = tim;
			controle++;
			return "TIME INCLUÍDO NO CAMPEONATO!";
		} else {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
	}
/** 
 * verifica se um Time específico está nos participantes do campeonato.
 * 
 * @param tim Time que será procurado.
 * @return retorna o resultado da verificação, se o time está ou não no campeonato.
 */
	public String verificaTime(Time tim) {
		for (Time temp : participantes) {
			if (temp != null && temp.equals(tim)) {
			return "O TIME ESTÁ EM CAMPEONATO!";
			}
		} return "O TIME NÃO ESTÁ EM CAMPEONATO!";
	}	
/**
 * método privado para retornar a quantidade de times que estão participando do campeonato.
 *  
 * @return retorna a quantidade de participantes, inicialmente sendo zero.
 */
	private int qntCadastrados() {
		int cadastrados = 0;
		for (Time t : participantes) {
			if (t != null) {
				cadastrados += 1;
			}
		}
		return cadastrados;
	}
/**
 * procura um time específico no array de participantes do campeonato
 * 
 * @param t time a ser procurado
 * @return retorna True caso o time esteja participando do campeonato, False caso não esteja.
 */
	public boolean buscaTime(Time t) {
		for (Time temp : participantes) {
			if (temp != null && temp.equals(t)) {
				return true;
			}
		} return false;
	}
/**
 * método para pegar a quantidade de participantes possíveis do campeonato.
 * 
 * @return quantidade de participantes.
 */
	public int getQntParticipantes() {
		return participantes.length;
	}
/**
 *	pega o nome do campeonato.
 * @return nome do campeonato.
 */
	public String getNome() {
		return this.nome;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome.toLowerCase(), other.nome.toLowerCase());
	}
	@Override
	public String toString() {
		return this.nome + " - " + qntCadastrados() + "/" + participantes.length;
	}
}
