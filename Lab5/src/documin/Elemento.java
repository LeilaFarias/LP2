package documin;

import java.util.HashMap;

/**
 * Representação de um Elemento de um Documento, cada Elemento possui uma prioridade, um valor e 
 * propriedades específicas daquele tipo.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public abstract class Elemento {
	/**
	 * Atributos:
	 * prioridade sendo um inteiro de 1-5.
	 * valor sendo um texto do Elemento.
	 * propriedades sendo um HashMap de String para String, onde o nome da propriedade irá ligá-la para seu valor.
	 */
	protected int prioridade;
	protected String valor;
	protected HashMap<String, String> propriedades = new HashMap<>();
	/**
	 * constrói um Elemento a partir de um valor e uma prioridade fornecidos pelo usuário.
	 * 
	 * @param valor texto do Elemento.
	 * @param prioridade inteiro de 1-5.
	 */
	public Elemento(String valor, int prioridade) {
		this.prioridade = prioridade;
		this.valor = valor;
	}
	/**
	 * método abstrato que representa o Elemento de uma forma completa, dependendo
	 * da implementação da classe filha
	 * 
	 * @return String da representação;
	 */
	public abstract String representacaoCompleta();
	/**
	 * método abstrato que representa o Elemento de uma forma resumida, dependendo
	 * da implementação da classe filha
	 * 
	 * @return String da representação;
	 */
	public abstract String representacaoResumida();

	public int getPrioridade() {
		return this.prioridade;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
