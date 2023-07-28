package documin;

import java.util.ArrayList;

public class VisaoTitulo implements Visao{

	private Documento referenciado;
	
	public VisaoTitulo(Documento referenciado) {
		this.referenciado = referenciado;
	}

	@Override
	public String[] exibirVisao() {
		ArrayList<String> out = new ArrayList<>();
		
		for (Elemento temp : referenciado.getArrayElementos()) {
			if (temp instanceof Titulo) {
				out.add(temp.representacaoResumida());
			}
		}
		return out.toArray(new String[out.size()]);
	}
}
