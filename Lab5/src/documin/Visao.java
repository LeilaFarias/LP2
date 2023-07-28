package documin;

/**
 * Interface de Visao, utilizadas para exportar o Documento de diferentes formas.
 *  
 * @author Leila Medeiros de Farias.
 *
 */
public interface Visao {
	/**
	 * método abstrato que retorna diferentes representações do Documento, sempre utilizando
	 * seus Elementos.
	 * 
	 * @return Array de String contendo as representações dos Elementos. 
	 */
	abstract public String[] exibirVisao();

}
