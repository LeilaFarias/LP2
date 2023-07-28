package documin;

public class Titulo extends Elemento {

	public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.propriedades.put("nivel", String.valueOf(nivel));
		this.propriedades.put("linkavel", String.valueOf(linkavel));
	}

	@Override
	public String representacaoCompleta() {
		String nivel = propriedades.get("nivel");
		String link = propriedades.get("linkavel");

		if (link == "true") {
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
