package pack;

import java.util.Objects;

/**
 * Representação de um Time, todo time deve ter um id,
 * um nome e um mascote. Times são dentificados unicamente pelo seu id.
 * 
 * @author Leila Medeiros de Farias
 *
 */
public class Time {
/**
 * id do Time, no formato "3digitos_2letras".
 * nome do Time.
 * mascote do Time.
 */
	private String id;
	private String nome;
	private String mascote;
	
/**
 * Constrói um Time apartir do id, nome e mascote que são passados pelo usúario.
 * 
 * @param id id do Time.
 * @param nome nome do Time.
 * @param mascote mascote do Time.
 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;		
		this.mascote = mascote;
	}
/**
 * pega o nome do Time.
 * @return nome do Time
 */
	public String getNome() {
		return this.nome;
	}
	@Override
	public String toString() {
		return "[" + this.id + "] " + this.nome + " / " + this.mascote;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
}
