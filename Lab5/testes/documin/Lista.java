package documin;

public class Lista extends Elemento {

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
