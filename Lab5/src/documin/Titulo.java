package documin;

/**
 * Representação de um Titulo, é um tipo de Elemento.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class Titulo extends Elemento {
	
	 /**
	 * constrói um Titulo a partir de um valor, uma prioridade de 1-5, um nível de 1-5 e um 
	 * booleano, sendo esses últimos alocados para a coleção de propriedades e utilizados para gerar as
	 * representações, junto do valor.
	 * 
	 * @param valor Texto do Titulo.
	 * @param prioridade inteiro de 1-5.
	 * @param nivel propriedade específica de Titulo, inteiro de 1-5 utilizado para gerar as representações.
	 * @param linkavel propriedade específica de Titulo, booleano utilizado para gerar as representações.
	 */
	public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.propriedades.put("nivel", String.valueOf(nivel));
		this.propriedades.put("linkavel", String.valueOf(linkavel));
	}

	@Override
	public String representacaoCompleta() {
		String nivel = propriedades.get("nivel");
		String link = propriedades.get("linkavel");

		if (link.equals("true")) {
			return nivel + " " + this.valor + " -- " + nivel + "-" + this.valor.toUpperCase().replace(" ", "");
		} else {
			return nivel + ". " + this.valor;
		}
	}

	@Override
	public String representacaoResumida() {
		return propriedades.get("nivel") + ". " + this.valor;
	}
}
