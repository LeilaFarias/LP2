package documin;

import java.util.ArrayList;

public class VisaoResumida implements Visao{
	
	private Documento referenciado; 
	
	public VisaoResumida(Documento referenciado) {
		this.referenciado = referenciado;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : this.referenciado.getArrayElementos()) {
			out.add(temp.representacaoResumida());
		}
		return out.toArray(new String[out.size()]);
	}
}
