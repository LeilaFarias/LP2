package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Documento {

	private String titulo;
	private ArrayList<Elemento> elementos;
	private ArrayList<Visao> visoes;
	private boolean temAtalho;

	public Documento(String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
		this.visoes = new ArrayList<>();
		this.temAtalho = false;
	}

	public Documento(String titulo, int tamanhoMax) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>(tamanhoMax);
		this.temAtalho = false;
	}

	public ArrayList<Elemento> getArrayElementos() {
		return this.elementos;
	}

	public String[] exibirDocumento() {
		ArrayList<String> out = new ArrayList<>();
		for (Elemento temp : elementos) {
			out.add(temp.representacaoResumida());
		}
		return out.toArray(new String[out.size()]);
	}

	public int criarElemento(Elemento e) {
		this.elementos.add(e);
		return elementos.indexOf(e);
	}

	public void moverElementoCima(int elementoPosicao) {
		if (elementoPosicao != 0) {
			Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
		}
	}

	public void moverElementoBaixo(int elementoPosicao) {
		if (elementos.listIterator(elementoPosicao).hasNext()) {
			Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
		}
	}

	public boolean apagarElemento(int elementoPosicao) {
		Elemento e = elementos.get(elementoPosicao);
		return elementos.remove(e);
	}

	public Elemento getElemento(int elementoPosicao) {
		return elementos.get(elementoPosicao);
	}
	public int contarElementos() {
		return elementos.size();
	}

	public int getMediaPrioridades() {
		int media = 0;
		for (Elemento temp : elementos) {
			media += temp.getPrioridade();
		}
		return media / elementos.size();
	}

	public int criarAtalho(Atalho a) {
		if (this.temAtalho == true) {throw new IllegalStateException();}
		
		elementos.add(a);
		this.temAtalho = true;
		return elementos.indexOf(a);
	}
	
	public int criarVisao(Visao v) {
		this.visoes.add(v);
		return visoes.indexOf(v);
	}
	public String[] getVisao(int visaoId) {
		return visoes.get(visaoId).exibirVisao();
	}
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}
	@Override
	public String toString() {
		return "Documento [titulo=" + titulo + "]";
	}
}
