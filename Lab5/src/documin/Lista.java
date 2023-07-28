package documin;

/**
 * Representação de Lista, é um tipo de Elemento.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Lista extends Elemento {
	 /**
	 * constrói uma Lista a partir de um valor, uma prioridade de 1-5, um separador e um caractere,
	 * sendo esses últimos alocados para a coleção de propriedades e utilizados para gerar as
	 * representações, junto do valor.
	 * 
	 * @param valorLista texto da Lista.
	 * @param prioridade inteiro de 1-5.
	 * @param separador propriedade específica de Lista, uma String que irá separar o valor em partes. 
	 * @param caractere propriedade específica de Lista, uma String será usada para recriar o valor.
	 */
	public Lista(String valorLista, int prioridade, String separador, String caractere) {
		super(valorLista, prioridade);
		this.propriedades.put("separador", separador);
		this.propriedades.put("caractere", caractere);
	}

	@Override
	public String representacaoCompleta() {
		String separador = propriedades.get("separador");
		String caracter = propriedades.get("caractere");
		String[] split = valor.split(separador);
		String out = "";

		for (int i = 0; i < split.length; i++) {
			out += caracter + " " + split[i].trim() + "\n";
		}
		return out.trim();
	}

	@Override
	public String representacaoResumida() {
		return valor;
	}
}
