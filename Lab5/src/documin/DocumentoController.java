package documin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * controlador que gerencia as operações no Documento e seus Elementos.
 * 
 * @author Leila Medeiros de Farias.
 *
 */
public class DocumentoController {
	/**
	 * Atributos:
	 * documentos sendo a coleção que armazena os Documentos e os recupera através da String do seu titulo.
	 * 
	 */
	private HashMap<String, Documento> documentos;
	
	/**
	 * constrói um controlador de Documentos, inicializando sua coleção.
	 */
	public DocumentoController() {
		this.documentos = new HashMap<>();
	}
	/**
	 * cria um Documento a partir do seu titulo e o insere na coleção de Documentos, 
	 * sendo o titulo a chave para o Documento.
	 * 
	 * @param titulo titulo do Documento.
	 * @return false caso o titulo do Documento já exista, true caso o contrário.
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 */
	public boolean criarDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (documentos.containsKey(titulo)) {return false;}

		Documento d = new Documento(titulo);
		documentos.put(titulo, d);
		return true;
	}
	/**
	 * cria um Documento a partir do seu titulo e tamanho desejado da lista
	 * de Elementos, o insere na coleção de Documentos sendo o titulo a chave para o Documento.
	 * 
	 * @param titulo titulo do Documento.
	 * @param tamanhoMaximo tamanho da lista de Elementos do Documento.
	 * @return false caso o titulo do Documento já exista, true caso o contrário.
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou o tamanho seja menor que 0.
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (tamanhoMaximo <= 0) {throw new IllegalArgumentException("Tamanho máximo inválido");}
		if (documentos.containsKey(titulo)) {return false;}

		Documento d = new Documento(titulo, tamanhoMaximo);
		documentos.put(titulo, d);
		return true;
	}
	/**
	 * remove um Documento da coleção a partir do seu titulo.
	 * 
	 * @param titulo titulo do Documento.
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public void removerDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		documentos.remove(titulo);
	}
	/**
	 * recupera um Documento a partir de seu titulo e retorna sua quantidade de Elementos.
	 * 
	 * @param titulo titulo do Documento
	 * @return quantidade de Elementos em inteiro.
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int contarElementos(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		Documento d = documentos.get(titulo);
		return d.contarElementos();
	}
	/**
	 * recupera um Documento a partir do seu titulo e o exibe.
	 * 
	 * @param titulo titulo do Documento.
	 * @return Array de Strings contendo a exibição do Documento.
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public String[] exibirDocumento(String titulo) {
		if (titulo.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(titulo))) {throw new NoSuchElementException("Documento não Existe!");}

		Documento d = documentos.get(titulo);
		return d.exibirDocumento();
	}
	/**
	 * recupera um Documento a partir do seu titulo e cria nele um Elemento do tipo Texto, 
	 * o Elemento é criado a partir de um valor e uma prioridade de 1-5.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param valor valor do Elemento.
	 * @param prioridade inteiro de 1-5.
	 * @return retorna a posição (índice) que o Elemento foi criado.
	 * 
	 * @throws IllegalArgumentException caso o titulo ou o valor sejam vazios e caso 
	 * a prioridade seja maior que 5 ou menor que 1.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		if (tituloDoc.isBlank() || valor.isBlank()) {throw new IllegalArgumentException("Argumento inválido!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Texto t = new Texto(valor, prioridade);

		return d.addElemento(t);
	}
	/**
	 * recupera um Documento a partir do seu titulo e cria nele um Elemento do tipo Titulo,
	 * o Elemento é criado a partir de um valor, uma prioridade de 1-5, um nivel de 1-5 e um booleano.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param valor valor do Elemento.
	 * @param prioridade inteiro de 1-5.
	 * @param nivel inteiro de 1-5.
	 * @param linkavel booleano do Elemento.
	 * @return a posição (índice) que o Elemento foi criado.
	 * 
	 * @throws IllegalArgumentException caso o titulo ou valor sejam vazios e caso
	 * a prioridade ou o nivel sejam maiores que 5 ou menores que 1.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */

	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		if (tituloDoc.isBlank() || valor.isBlank()) {throw new IllegalArgumentException("Argumento inválido!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		if (nivel > 5 || nivel <= 0) {throw new IllegalArgumentException("Nível inválido");}
		
		Documento d = documentos.get(tituloDoc);
		Titulo t = new Titulo(valor, prioridade, nivel, linkavel);

		return d.addElemento(t);
	}
	/**
	 * recupera um Documento a partir do titulo e cria nele um Elemento do tipo Lista,
	 * o Elemento é criado a partir de um valor, uma prioridade de 1-5, um separador e um caractere.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param valorLista valor do Elemento.
	 * @param prioridade inteiro de 1-5.
	 * @param separador separador do Elemento.
	 * @param charLista caractere do Elemento.
	 * @return a posição (índice) que o Elemento foi criado.
	 * 
	 *@throws IllegalArgumentException caso o titulo ou valor sejam vazios, ou 
	 *caso a prioridade seja maior que 5 ou menor que 1. 
	 *@throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		if (tituloDoc.isBlank() || valorLista.isBlank()) {throw new IllegalArgumentException("Argumento inválido!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Lista l = new Lista(valorLista, prioridade, separador, charLista);

		return d.addElemento(l);
	}
	/**
	 * recupera um Documento a partir do titulo e cria nele um Elemento do tipo Lista,
	 * o Elemento é criado a partir de um valor, uma prioridade de 1-5, um separador
	 * e uma ordem (alfabética, tamanho ou nenhum).
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param valorTermos valor do Elemento.
	 * @param prioridade inteiro de 1-5.
	 * @param separador separador do Elemento.
	 * @param ordem ordem do Elemento.
	 * @return a posição (índice) que o Elemento foi criado.
	 * 
	 * @throws IllegalArgumentException caso o tituo, valor ou ordem sejam vazios, caso a prioridade
	 * seja maior que 5 ou menor que 1.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public int criarTermo(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		if (tituloDoc.isBlank() || valorTermos.isBlank() || ordem.isBlank()) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (prioridade > 5 || prioridade <= 0) {throw new IllegalArgumentException("Prioridade inválida");}
		
		Documento d = documentos.get(tituloDoc);
		Termo t = new Termo(valorTermos, prioridade, separador, ordem);

		return d.addElemento(t);
	}
	/**
	 * recupera um Documento a partir do seu titulo, recupera neste Documento um determinado Elemento e
	 * devolve a reresentação completa deste Elemento.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param elementoPosicao posição (índice) do Elemento.
	 * @return representação completa do Elemento.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, caso a posição seja menor que 0 ou
	 * caso o Elemento seja um Termo e sua ordem seja diferente de "Alfabética", "Tamanho" ou "Nenhum".
	 * @throws NoSuchElementException caso o Documento não exista.
	 * @throws IndexOutOfBoundsException caso a posição desejada seja maior que o tamanho da lista.
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || elementoPosicao < 0) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Elemento e = documentos.get(tituloDoc).getElemento(elementoPosicao);
		return e.representacaoCompleta();
	}
	/**
	 * recupera um Documento a partir do seu titulo, recupera neste Documento um determinado Elemento
	 * e devolve a representação resumida deste Elemento.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param elementoPosicao posição (índice) do Elemento.
	 * @return representação resumida do Elemento.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou caso a posição seja menor que 0 ou
	 * caso o Elemento seja um Termo e sua ordem seja diferente de "Alfabética", "Tamanho" ou "Nenhum".
	 * @throws NoSuchElementException caso o Documento não exista.
	 * @throws IndexOutOfBoundsException caso a posição desejada seja maior que o tamanho da lista. 
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || elementoPosicao < 0) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Elemento e = documentos.get(tituloDoc).getElemento(elementoPosicao);

		return e.representacaoResumida();
	}
	/**
	 * recupera um Documento a partir do seu titulo e move o Elemento desejado para a posição 
	 * ao lado mais próxima do começo da lista, caso o Elemento seja o primeiro da lista, ele não é movido.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param elementoPosicao posição (índice) do Elemento.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou caso a posição seja menor que 0.
	 * @throws NoSuchElementException caso o Documento não exista.
	 * @throws IndexOutOfBoundsException caso a posição desejada seja maior que o tamanho da lista. 
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || elementoPosicao < 0) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		d.moverElementoCima(elementoPosicao);
	}
	/**
	 * recupera um Documento a partir do seu titulo e move o Elemento desejado para a posição 
	 * ao lado mais próxima do fim da lista, caso o Elemento seja o último da lista, ele não é movido.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param elementoPosicao posição (índice) do Elemento.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou caso a posição seja menor que 0.
	 * @throws NoSuchElementException caso o Documento não exista.
	 * @throws IndexOutOfBoundsException caso a posição desejada seja maior que o tamanho da lista. 
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || elementoPosicao < 0) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		d.moverElementoBaixo(elementoPosicao);
	}
	/**
	 * recupera um Documento a partir do seu titulo e retira um Elemento da sua coleção de Elementos.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @param elementoPosicao posição (índice) do Elemento que será apagado.
	 * @return true caso tenha sido efetuada a remoção, false caso o contrário.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio, ou caso a posição seja menor que 0.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || elementoPosicao < 0) {throw new IllegalArgumentException("Argumento inválido");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		return d.apagarElemento(elementoPosicao);
	}
	/**
	 * recupera um Documento a partir do titulo e cria nele um Elemento do tipo Atalho,
	 * o Elemento é criado a partir do titulo do Documento que o Atalho referencia, a media
	 * de prioridade do Documento referenciado e o próprio Documento referenciado.
	 * 
	 * @param tituloDoc titulo do Documento que será adicionado o Atalho.
	 * @param tituloDocReferenciado titulo do Documento referenciado que será utilizado para gerar o Atalho.
	 * @return a posição (índice) que o Elemento foi criado.
	 * 
	 * @throws IllegalArgumentException caso o titulo de algum dos dois Documentos sejam vazios.
	 * @throws NoSuchElementException caso algum dos dois Documento não exista.
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (tituloDocReferenciado.isBlank()) {throw new IllegalArgumentException("Título Referenciado vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		if (!(documentos.containsKey(tituloDocReferenciado))) {throw new NoSuchElementException("Documento referenciado não Existe!");}

		Documento doc = documentos.get(tituloDoc);
		Documento docReferenciado = documentos.get(tituloDocReferenciado);
		Atalho a = new Atalho(tituloDocReferenciado, docReferenciado.getMediaPrioridades(), docReferenciado);

		docReferenciado.setEhAtalho();
		return doc.addAtalho(a);
	}
	/**
	 * recupera o toString de todos os documentos cadastrados.
	 * 
	 * @return representação dos Documentos.
	 */
	public String getToStringDocumentos() {
		StringBuilder out = new StringBuilder();
		for (Documento temp : documentos.values()) {
			out.append(temp.toString());
			out.append(" ");
		}
		return out.toString().trim();
	}
	/**
	 * recupera um Documento a partir do seu titulo e transforma a lista de Elementos deste
	 * Documento em um Array de Elementos, por fim, transformar este Array em uma String.
	 * 
	 * @param tituloDoc titulo do Documento.
	 * @return a String contendo todos os Elementos do Documento.
	 * 
	 * @throws IllegalArgumentException caso o titulo seja vazio.
	 * @throws NoSuchElementException caso o Documento não exista.
	 */
	public String getElementosDeUmDocumento(String tituloDoc) {
		if (tituloDoc.isBlank()) {throw new IllegalArgumentException("Título vazio!");}
		if (!(documentos.containsKey(tituloDoc))) {throw new NoSuchElementException("Documento não Existe!");}
		
		Documento d = documentos.get(tituloDoc);
		Elemento[] list = d.getArrayElementos().toArray(new Elemento[d.getArrayElementos().size()]);
		return Arrays.toString(list);
	}
	public HashMap<String, Documento> getDocumentos() {
		return documentos;
	}
}
