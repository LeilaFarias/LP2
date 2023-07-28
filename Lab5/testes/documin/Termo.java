package documin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Termo extends Elemento {

	public Termo(String valorTermos, int prioridades, String separador, String ordem) {
		super(valorTermos, prioridades);
		this.propriedades.put("separador", separador);
		this.propriedades.put("ordem", ordem);
	}

	@Override
	public String representacaoCompleta() {
		String separador = propriedades.get("separador");
		String ordem = propriedades.get("ordem");
		String[] split = valor.split(separador);
		int totalTermos = split.length;

		switch (ordem) {
		case "ALFABÉTICA":
			List<String> list = Arrays.asList(split);
			Collections.sort(list);
			String out = String.join(", ", list);
			
			return "Total termos: " + totalTermos + "\n" + "- " + out.trim();

		case "TAMANHO":
			selectionSort(split);

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
		String[] split = valor.split(separador);

		switch (ordem) {
		case "ALFABÉTICA":
			List<String> list = Arrays.asList(split);
			Collections.sort(list);

			String out = String.join(" " + separador + " ", list);
			return out.trim();

		case "TAMANHO":

			selectionSort(split);

			String out2 = String.join(" " + separador + " ", split);
			return out2.trim();

		case "NENHUM":
			return this.valor;

		default:
			throw new IllegalArgumentException();
		}
	}

	private void selectionSort(String[] split) {
		for (int i = 0; i < split.length; i++) {

			int i_menor = i;
			for (int j = i + 1; j < split.length; j++) {
				if (split[j].length() < split[i].length()) {
					i_menor = j;
				}
			}
			String aux = split[i];
			split[i] = split[i_menor];
			split[i_menor] = aux;
		}
	}

	@Override
	public String toString() {
		return "Termo []";
	}
	
}
