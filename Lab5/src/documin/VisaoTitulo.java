package documin;

import java.util.ArrayList;

/**
 * Representação de uma Visão considerando todos os Elementos Titulo do Documento e
 * suas respectivas representações resumidas, implementa a interface Visao.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class VisaoTitulo implements Visao{
	
	/**
	 * Atributos:
	 * referenciado sendo o Documento que a Visao trata.
	 */
	private Documento referenciado;
	
	/**
	 * constrói uma VisaoTitulo a partir de um Documento que a Visao referencia.
	 * 
	 * @param referenciado Documento que a Visao referencia.
	 */
	public VisaoTitulo(Documento referenciado) {
		this.referenciado = referenciado;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp instanceof Titulo) {
				out.add(temp.representacaoResumida());
			}
		}
		return out.toArray(new String[out.size()]);
	}
}
