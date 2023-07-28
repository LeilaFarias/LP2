package documin;

import java.util.ArrayList;

public class VisaoCompleta implements Visao {
	
	private Documento referenciado;
	
	public VisaoCompleta(Documento referenciado) {
		this.referenciado = referenciado;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : this.referenciado.getArrayElementos()) {
			out.add(temp.representacaoCompleta());
		}
		return out.toArray(new String[out.size()]);
	}
	
}
