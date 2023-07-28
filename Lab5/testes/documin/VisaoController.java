package documin;

import java.util.NoSuchElementException;

public class VisaoController {
	
	private DocumentoController docController;
	
	public VisaoController(DocumentoController docController) {
		this.docController = docController;
	}
	
	public int criarVisaoCompleta(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoCompleta(d);
		return d.criarVisao(v);
	}
	public int criarVisaoResumida(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoCompleta(d);
		return d.criarVisao(v);
	}
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoPrioritaria(d, prioridade);
		return d.criarVisao(v);
	}

	public int criarVisaoTitulo(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoTitulo(d);
		return d.criarVisao(v);
	}

	public String[] exibirVisao(String tituloDoc, int visaoId) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		return d.getVisao(visaoId);
	}
}
