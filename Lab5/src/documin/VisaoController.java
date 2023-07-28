package documin;

import java.util.NoSuchElementException;

/**
 * controlador que gerencia as operações envolvendo as Visões.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class VisaoController {
	/**
	 * Atributos:
	 * docController sendo o controlador de Documentos.
	 */
	private DocumentoController docController;
	/**
	 * constrói um controlador de Visao a partir de um DocumentoController.
	 * 
	 * @param docController controlador de Documentos.
	 */
	public VisaoController(DocumentoController docController) {
		this.docController = docController;
	}
	/**
	 * recupera um Documento a partir de seu titulo e cria nele uma VisaoCompleta, a Visao é criada
	 * a partir do Documento que ela referencia.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @return a posição (índice) que a Visao foi criada.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoCompleta(d);
		return d.addVisao(v);
	}
	/**
	 * recupera um Documento a partir de seu titulo e cria nele uma VisaoResumida, a Visao é criada
	 * a partir do Documento que ela referencia.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @return a posição (índice) que a Visao foi criada.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarVisaoResumida(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoResumida(d);
		return d.addVisao(v);
	}
	/**
	 * recupera um Documento a partir de seu titulo e cria nele uma VisaoPrioritaria, a Visao é criada
	 * a partir do Documento que ela referencia e a prioridade desejada.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param prioridade inteiro de 1-5.
	 * @return a posição (índice) que a Visao foi criada.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou caso a prioridade seja 
	 * maior que 5 ou menor que 1.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoPrioritaria(d, prioridade);
		return d.addVisao(v);
	}
	/**
	 * recupera um Documento a partir de seu titulo e cria nele uma VisaoTitulo, a Visao é criada
	 * a partir do Documento que ela referencia.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @return a posição (índice) que a Visao foi criada.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		Visao v = new VisaoTitulo(d);
		return d.addVisao(v);
	}
	/**
	 * recupera um Documento a partir do seu titulo e recupera nele uma Visao a partir da sua 
	 * posição (índice).
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param visaoId posição (índice) da Visao.
	 * @return Array de String contendo a representação da Visao.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public String[] exibirVisao(String tituloDoc, int visaoId) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(docController.getDocumentos().containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = docController.getDocumentos().get(tituloDoc);
		return d.getVisao(visaoId);
	}
}
