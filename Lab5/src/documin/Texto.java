package documin;

/**
 * Representação de um Texto, é um tipo de Elemento.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class Texto extends Elemento {
	 /**
	 * constrói um Texto a partir de um valor e uma prioridade de 1-5.
	 * 
	 * @param valor Texto do Elemento.
	 * @param prioridade inteiro de 1-5.
	 */
	public Texto(String valor, int prioridade) {
		super(valor, prioridade);
	}

	@Override
	public String representacaoCompleta() {
		return valor;
	}

	@Override
	public String representacaoResumida() {
		return valor;
	}
}
