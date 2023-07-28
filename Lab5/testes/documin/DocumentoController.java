package documin;

import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoController {

	private HashMap<String, Documento> documentos;
	
	public DocumentoController() {
		this.documentos = new HashMap<>();
	}
	
	
	public boolean criarDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (documentos.containsKey(titulo)) {return false;}

		Documento d = new Documento(titulo);
		documentos.put(titulo, d);
		return true;
	}

	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (tamanhoMaximo <= 0) {throw new IllegalArgumentException("Tamanho máximo inválido");}
		if (documentos.containsKey(titulo)) {return false;}

		Documento d = new Documento(titulo, tamanhoMaximo);
		documentos.put(titulo, d);
		return true;
	}

	public void removerDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		documentos.remove(titulo);
	}

	public int contarElementos(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		Documento d = documentos.get(titulo);
		return d.contarElementos();
	}

	public String[] exibirDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		Documento d = documentos.get(titulo);
		return d.exibirDocumento();
	}

	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Texto t = new Texto(valor, prioridade);

		return d.criarElemento(t);
	}

	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		if (nivel > 5 || nivel <= 0) {throw new IllegalArgumentException("Nível inválido");}
		
		Documento d = documentos.get(tituloDoc);
		Titulo t = new Titulo(valor, prioridade, nivel, linkavel);

		return d.criarElemento(t);
	}

	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Lista l = new Lista(valorLista, prioridade, separador, charLista);

		return d.criarElemento(l);
	}

	public int criarTermo(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Termo t = new Termo(valorTermos, prioridade, separador, ordem);

		return d.criarElemento(t);
	}

	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Elemento e = documentos.get(tituloDoc).getElemento(elementoPosicao);
		return e.representacaoCompleta();
	}

	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Elemento e = documentos.get(tituloDoc).getElemento(elementoPosicao);

		return e.representacaoResumida();
	}

	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		d.moverElementoCima(elementoPosicao);
	}

	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		d.moverElementoBaixo(elementoPosicao);
	}

	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		return d.apagarElemento(elementoPosicao);
	}

	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título Referenciado vazio!");}
		if (!(documentos.containsKey(tituloDocReferenciado))) {throw new NoSuchElementException("Documento não Existe!");}

		Documento doc = documentos.get(tituloDoc);
		Documento docReferenciado = documentos.get(tituloDocReferenciado);
		Atalho a = new Atalho(tituloDocReferenciado, docReferenciado.getMediaPrioridades(), docReferenciado);

		return doc.criarAtalho(a);
	}
	public HashMap<String, Documento> getDocumentos() {
		return documentos;
	}
	public String getToString() {
		StringBuilder out = new StringBuilder();
		for (Documento temp : documentos.values()) {
			out.append(temp.toString());
			out.append(" ");
		}
		return out.toString().trim();
	}

}
