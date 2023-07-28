package documin;
import java.util.ArrayList;

/**
 * Representação de uma Visao Prioritaria de um Documento, leva em
 * consideração as prioridades dos Elementos do Documento, implementa a interface de Visao.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class VisaoPrioritaria implements Visao {
	/**
	 * Atributos:
	 * referenciado sendo o Documento que a Visao trata.
	 * prioridade sendo o valor da prioridade desejada dos Elementos.
	 */
	private Documento referenciado;
	private int prioridade;
	
	/**
	 * constrói uma VisaoPrioritaria a partir do Documento que ela referencia e a prioridade 
	 * desejada para os Elementos que serão mostrados na exibição.
	 * 
	 * @param referenciado Documento que a Visao referencia.
	 * @param prioridade inteiro de 1-5.
	 */
	public VisaoPrioritaria(Documento referenciado, int prioridade) {
		this.referenciado = referenciado;
		this.prioridade = prioridade;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp.getPrioridade() >= this.prioridade) {
				out.add(temp.representacaoCompleta());
			}
		}
		return out.toArray(new String[out.size()]);
	}
}
