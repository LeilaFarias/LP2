package documin;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representação de um documento que é identificado unicamente pelo seu titulo,
 * possui uma lista de elementos e visões cadastráveis pelo usuário, um Documento pode
 * se tornar o atalho de um outro Documento ou possuir um atalho referente a outro Documento.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Documento {

	/**
 	* Atributos:
 	* titulo sendo o titulo do Documento.
 	* elementos sendo a coleção que armazena os elementos do Documento.
 	* visoes sendo a coleção que armazena as visões do Documento. 
 	* temAtalho sendo um boolean que indica se o Documento possui um atalho ou não.
 	* ehAtalho sendo um boolean que indica se o Documento é ou não atalho de um outro Documento.
 	* 
 	*/
	private String titulo;
	private ArrayList<Elemento> elementos;
	private ArrayList<Visao> visoes;
	private boolean temAtalho;
	private boolean ehAtalho;

	/**
 	* Constrói um Documento a partir de um titulo fornecido pelo usuário e inicializa as coleções
 	* de elementos e visões, todo Documento começa com os atributos de atalho como false.
 	* 
 	* @param titulo titulo do Documento.
 	*/
	public Documento(String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
		this.visoes = new ArrayList<>();
		this.temAtalho = false;
		this.ehAtalho = false;
	}
	/**
 	* Constrói um Documento a partir de um titulo e um tamanho máximo para a lista de elementos, 
 	* inicializa as coleções de elementos e visões, todo Documento começa com os atributos de atalho como false.
 	* 
 	* @param titulo titulo do Documento.
 	* @param tamanhoMax tamanho maximo da lista de elementos.
 	*/
	public Documento(String titulo, int tamanhoMax) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>(tamanhoMax);
		this.temAtalho = false;
		this.ehAtalho = false;
	}

	/**
 	* exibe um Documento, a exibição se trata de um Array de Strings contendo 
 	* a representação resumida de todos os elementos do Documento.
 	* 
 	* @return Array de String das representações resumidas dos elementos. Caso não haja elementos, retorna
 	* um Array vazio.
 	*/
	public String[] exibirDocumento() {
		ArrayList<String> out = new ArrayList<>();
		for (Elemento temp : elementos) {
			out.add(temp.representacaoResumida());
		}
		return out.toArray(new String[out.size()]);
	}
	/**
 	* adiciona um Elemento na lista de elementos.
 	* 
 	* @param e Elemento que será adicionado.
 	* @return a posição (índice) do Elemento que foi adicionado.
 	*/
	public int addElemento(Elemento e) {
		this.elementos.add(e);
		return elementos.indexOf(e);
	}
	/**
 	* move um Elemento para a posição ao lado mais próxima do início da lista. Caso a posição
 	* seja a primeira da lista, o Elemento não muda de lugar.
 	* 
 	* @param elementoPosicao posição (índice) do Elemento que será movido
 	*/
	public void moverElementoCima(int elementoPosicao) {
		if (elementoPosicao != 0) {
			Collections.swap(elementos, elementoPosicao, elementoPosicao - 1);
		}
	}
	/**
 	* move um Elemento para a posição ao lado mais próxima do fim da lista. Caso a posição
 	* seja a última da lista, o Elemento não muda de lugar.
 	* 
 	* @param elementoPosicao posição (índice) do Elemento que será movido.
 	*/
	public void moverElementoBaixo(int elementoPosicao) {
		if (elementoPosicao < elementos.size() - 1) {
			Collections.swap(elementos, elementoPosicao, elementoPosicao + 1);
		}
	}
	/**
 	* remove um Elemento da lista de elementos.
 	* 
 	* @param elementoPosicao posição (índice) do Elemento que será removido.
 	* @return true caso o Elemento tenha sido removido com sucesso, false caso o contrário.
 	*/
	public boolean apagarElemento(int elementoPosicao) {
		Elemento e = elementos.get(elementoPosicao);
		return elementos.remove(e);
	}

	public Elemento getElemento(int elementoPosicao) {
		return elementos.get(elementoPosicao);
	}
	/**
 	* pega o tamanho da lista de Elementos, que indica a quantidade de Elementos que foram cadastrados
 	* 
 	* @return quantidade de Elementos cadastrados.
 	*/
	public int contarElementos() {
		return elementos.size();
	}
	/**
 	* calcula a média do atributo prioridade dos elementos da lista.
 	* 
 	* @return media das prioridades dos elementos.
 	* @throws IllegalStateException caso não haja elementos cadastrados.
 	*/
	public int getMediaPrioridades() {
		if (elementos.size() == 0) {throw new IllegalStateException("Adicione Elementos no referenciado antes de continuar");}
		int media = 0;
		for (Elemento temp : elementos) {
			media += temp.getPrioridade();
		}
		return media / elementos.size();
	}
	/**
	 * adiciona um atalho a lista de elementos e configura o atributo temAtalho para true;
	 * 
	 * @param a atalho a ser adicionado.
	 * @return a posição (índice) do atalho que foi adicionado.
	 * @throws IllegalStateException caso o Documento já tenha um atalho ou seja atalho de um outro Documento.
	 */
	public int addAtalho(Atalho a) {
		if (this.temAtalho == true || this.ehAtalho == true) {throw new IllegalStateException("O documento já é ou já possui atalho");}
		
		elementos.add(a);
		this.temAtalho = true;
		return elementos.indexOf(a);
	}	
	/**
	 * adiciona uma Visao a lista de visões.
	 * 
	 * @param v Visao a ser adicionada.
	 * @return a posição (índice) da Visão que foi adicionada.
	 */
	public int addVisao(Visao v) {
		this.visoes.add(v);
		return visoes.indexOf(v);
	}
	/**
	 * recupera uma Visao na coleção através do seu índice e a exibe.
	 * 
	 * @param visaoId posição (índice) da Visao na lista.
	 * @return Array de Strings que representa a Visão.
	 */
	public String[] getVisao(int visaoId) {
		return visoes.get(visaoId).exibirVisao();
	}
	public boolean getTemAtalho() {
		return this.temAtalho;
	}
	public boolean getEhAtalho() {
		return this.ehAtalho;
	}
	public void setEhAtalho() {
		this.ehAtalho = true;
	}
	public ArrayList<Elemento> getArrayElementos() {
		return this.elementos;
	}
	@Override
	public String toString() {
		return "Documento [titulo=" + titulo + "]";
	}
}
