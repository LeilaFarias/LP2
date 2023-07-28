package documin;

import java.util.HashMap;

public abstract class Elemento {

	protected int prioridade;
	protected String valor;
	protected HashMap<String, String> propriedades = new HashMap<>();

	public Elemento(String valor, int prioridade) {
		this.prioridade = prioridade;
		this.valor = valor;
	}

	public abstract String representacaoResumida();

	public abstract String representacaoCompleta();

	public int getPrioridade() {
		return this.prioridade;
	}
}
