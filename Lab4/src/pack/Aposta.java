package pack;

/**
 * representação de uma Aposta, uma aposta deve conter o time, o campeonato, a colocação
 * e o valor que será apostado.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Aposta {
/**
 * timeApostado sendo o time que deseja apostar.
 * campeonatoApostado sendo o campeonato que deseja apostar.
 * colocacaoApostada sendo a colocação que deseja fazer a aposta.
 * valorApostado sendo o valor que deseja apostar.
 */
	private Time timeApostado;
	private Campeonato campeonatoApostado;
	private int colocacaoApostada;
	private double valorApostado;
	
/**
 * constrói uma aposta a partir do time, campeonato, colocação e o valor que o usuário deseja apostar.
 * 
 * @param timeApostado time que deseja apostar
 * @param campeonatoApostado campeonato que deseja apostar
 * @param colocacaoApostada colocação que deseja apostar
 * @param valorApostado valor que deseja apostar.
 */
	public Aposta(Time timeApostado, Campeonato campeonatoApostado, int colocacaoApostada, double valorApostado) {
		this.timeApostado = timeApostado;
		this.campeonatoApostado = campeonatoApostado;
		this.colocacaoApostada = colocacaoApostada;
		this.valorApostado = valorApostado;
	}
	@Override
	public String toString() {
		return this.timeApostado.toString() + "\n" + this.campeonatoApostado.getNome() + "\n" + 
				this.colocacaoApostada + "/" + this.campeonatoApostado.getQntParticipantes() + "\n" +
				"R$ " + this.valorApostado + "\n";
	}
}
