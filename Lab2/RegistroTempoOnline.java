package lab2_leilamedeiros;

/*
 * Um registro acerca da quantidade de tempo dedicado online, por parte do aluno,
 * para certa disciplina.
 * 
 * @author Leila Medeiros de Farias
 */
public class RegistroTempoOnline {
    
/*
 * tempo exigido para a disciplina, no formato de horas;
 * tempo utilizado pelo aluno para a disciplina em questão, no formato de horas;
 * a disciplina analisada.
 */
    private int tempoNecessario;
    private int tempoDedicado;
    private String disciplina;

//Construtor
    RegistroTempoOnline (String nomeDisciplina){
        this.disciplina = nomeDisciplina;
        this.tempoNecessario = 120;
    }
    RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado){
        this.disciplina  = nomeDisciplina;
        this.tempoNecessario = tempoOnlineEsperado;
    }

/*
 * adiciona o tempo que o aluno passou online se dedicando a disciplina.
 * 
 * @para tempo o tempo dedicado em formato de horas.
 */
    public void adicionaTempoOnline(int tempo) {
        this.tempoDedicado += tempo;
    }
/*
 * checa se o tempo dedicado pelo aluno é o necessário para a disciplina.
 * 
 * @return de acordo com a verificação, retorna verdadeiro ou falso.
 */
    public boolean atingiuMetaTempoOnline() {
        if (this.tempoDedicado >= this.tempoNecessario) {
            return true;
        } else {
            return false;
        }
    }
/*
 * retorna a disciplina, o tempo dedicado pelo aluno e o tempo desejável pela disciplina,
 * no formato "disciplina tempo dedicado/tempo necessário".
 */ 
    public String toString() {
        return this.disciplina + " " + this.tempoDedicado + "/" + this.tempoNecessario;
    }
}