package documin;

import java.util.ArrayList;

/**
 * Representação de uma Visao Completa de um Documento, utiliza das
 * representações completas dos Elementos para gerar sua representação,
 * implementa a interface de Visao.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class VisaoCompleta implements Visao {
	/**
	 * Atributos:
	 * referenciado sendo o Documento que a Visao trata.
	 */
	private Documento referenciado;
	
	/**
	 * constrói uma VisaoCompleta a partir de um Documento que a Visao referencia.
	 * 
	 * @param referenciado Documento que a Visao referencia.
	 */
	public VisaoCompleta(Documento referenciado) {
		this.referenciado = referenciado;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : this.referenciado.getArrayElementos()) {
			out.add(temp.representacaoCompleta());
		}
		return out.toArray(new String[out.size()]);
	}
}
