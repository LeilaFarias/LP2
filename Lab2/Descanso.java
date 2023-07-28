package lab2_leilamedeiros;

/**
* Representação da rotina de descanso de um aluno em específico, levando em consideração
* a quantidade de horas de descanso que ele acumulou durante x semanas.
* 
* @author Leila Medeiros de Farias
*/
public class Descanso {

/*
 * quantidade de horas descansadas no formato de 24 horas;
 * quantidade de semanas que foram aplicadas tais horas.
 */
    private int horasDescanso;
    private int numeroSemana = 1;

 //Métodos
 /*
  * define a quantidade de horas que o aluno descansou em x semanas.
  * @param valor a quantidade de horas descansadas.
  */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

 /*
  * define a quantidade de semanas.
  *
  * @param valor o valor inteiro de semanas.
  */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemana = valor;
    }
 /*
  * calcula de acordo com os dados obtidos se o aluno está ou não descansado,
  * tomando como referência o fato de que ele estará descansado caso suas
  * horas de descanso sejam maiores ou iguais a 26 horas por semana.
  *
  * @return o status de descansado ou cansado dependendo do resultado.
  */
    public String getStatusGeral() {
        if (horasDescanso / numeroSemana >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }
}
