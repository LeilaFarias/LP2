package documin;
import java.util.ArrayList;

public class VisaoPrioritaria implements Visao {

	private Documento referenciado;
	private int prioridade;
	
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
