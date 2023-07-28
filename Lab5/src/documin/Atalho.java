package documin;

/**
 * Representação de um Atalho, um Atalho referencia a um certo Documento e é um tipo de Elemento.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Atalho extends Elemento {
	
	/**
	 * Atributos: 
	 * referenciado sendo o Documento a qual o Atalho se refere.
	 */
	private Documento referenciado;
	
	 /**
	 * constrói um Atalho a partir de uma String de valor, uma prioridade (valor de 1-5) e o Documento 
	 * a qual o Atalho se refere. 
	 *  
	 * @param valor Atributo herdado de Elemento, se trata do "texto" do Atalho.
	 * @param prioridade Atributo herdado de Elemento, se trata de um inteiro de 1-5.
	 * @param referenciado Documento a qual o Atalho se refere.
	 */
	public Atalho(String valor, int prioridade, Documento referenciado) {
		super(valor, prioridade);
		this.referenciado = referenciado;
	}

	@Override
	public String representacaoCompleta() {
		StringBuilder resultado = new StringBuilder();

		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp.getPrioridade() >= 4) {
				resultado.append(temp.representacaoCompleta() + " ");
			}
		}
		return resultado.toString().trim();
	}

	@Override
	public String representacaoResumida() {
		StringBuilder resultado = new StringBuilder();

		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp.getPrioridade() >= 4) {
				resultado.append(temp.representacaoResumida() + " ");
			}
		}
		return resultado.toString().trim();
	}
}
