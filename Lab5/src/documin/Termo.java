package documin;

import java.util.Arrays;
import java.util.List;

/**
 * Representação de um Termo, é um tipo de Elemento.
 *  
 * @author Leila Medeiros de Farias.
 */
public class Termo extends Elemento{

	/**
	 * constrói um termo a partir de um valor, uma prioridade de 1-5, 
	 * um separador e uma ordem (Alfabética, Tamanho ou Nenhum), esses últimos são alocados 
	 * para a coleção de propriedades e utilizando para gerar as representações, junto do valor.
	 * 
	 * @param valorTermos texto do Termo.
	 * @param prioridades inteiro de 1-5.
	 * @param separador propriedade específica de Termo, uma String que irá separar o valor em partes.
	 * @param ordem propriedade específica de Termo, uma String que define a ordem dos valores.
	 */
	public Termo(String valorTermos, int prioridades, String separador, String ordem) {
		super(valorTermos, prioridades);
		this.propriedades.put("separador", separador);
		this.propriedades.put("ordem", ordem);
	}

	@Override
	public String representacaoCompleta() {
		String separador = propriedades.get("separador");
		String ordem = propriedades.get("ordem");
		String[] split = valor.split(" " + separador + " ");
		int totalTermos = split.length;

		switch (ordem.toUpperCase()) {
		case "ALFABÉTICA":
			Arrays.sort(split, String.CASE_INSENSITIVE_ORDER);
			
			String ordenado = String.join(", ", split);
			return "Total termos: " + totalTermos + "\n- " + ordenado;

		case "TAMANHO":
			List<String> out = Arrays.asList(split);
			out.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

			String out2 = String.join(", ", split);
			return "Total termos: " + totalTermos + "\n" + "- " + out2.trim();

		case "NENHUM":
			String out3 = "Total termos: " + totalTermos + "\n" + String.join(", ", split);
			return out3.trim();

		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String representacaoResumida() {
		String separador = propriedades.get("separador");
		String ordem = propriedades.get("ordem");
		String[] split = valor.split(" " + separador + " ");

		switch (ordem.toUpperCase()) {
		case "ALFABÉTICA":
			Arrays.sort(split, String.CASE_INSENSITIVE_ORDER);
			
			String ordenado = String.join(" " + separador + " ", split);
			return ordenado.trim();

		case "TAMANHO":
			List<String> out = Arrays.asList(split);
			out.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));

			String ordenado2 = String.join(" " + separador + " ", split);
			return ordenado2.trim();

		case "NENHUM":
			return this.valor;

		default:
			throw new IllegalArgumentException();
		}
	}
}
