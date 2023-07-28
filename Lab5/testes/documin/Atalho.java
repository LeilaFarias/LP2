package documin;

public class Atalho extends Elemento {

	private Documento referenciado;

	public Atalho(String valor, int prioridade, Documento referenciado) {
		super(valor, prioridade);
		this.referenciado = referenciado;
	}

	@Override
	public String representacaoCompleta() {
		StringBuilder resultado = new StringBuilder();

		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp.getPrioridade() > 4) {
				resultado.append(temp.representacaoCompleta());
			}
		}
		return resultado.toString();
	}

	@Override
	public String representacaoResumida() {
		StringBuilder resultado = new StringBuilder();

		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp.getPrioridade() > 4) {
				resultado.append(temp.representacaoResumida());
			}
		}
		return resultado.toString();
	}
}
