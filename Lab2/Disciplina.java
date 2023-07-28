package lab2_leilamedeiros;

import java.util.Arrays;

/*
 * Representação, de um aluno específico, de um controle das notas e tempo dedicado em determinada 
 * disciplina 
 * 
 * @author Leila Medeiros de Farias
 */
public class Disciplina {

/*
 * notas do aluno em determinada disciplina, sendo 4 notas, cada uma de 0 a 10;
 * horas de estudo dedicadas à uma disciplina específica;
 * nome da disciplina analisada;  
 */
    private double[] notas = new double[4];
    private int horasDedicadas;
    private String nomeDiscip;
    
//Construtor
    Disciplina (String nomeDisciplina) { 
        this.nomeDiscip = nomeDisciplina;
    }

/*
 * cadastra as horas dedicadas ao estudo da disciplina.
 * @para horas a quantidade de horas dedicadas.
 */
    public void cadastraHoras(int horas){
        this.horasDedicadas += horas;
    }

/*
 * cadastra as notas, de 0 a 10, que o aluno tirou em cada prova, sendo possível 
 * a reposição de nota caso haja necessidade.
 * 
 * @para nota se trata da identificação referente a qual prova é aquela determinada nota.
 * @para valorNota o valor da nota em número decimal.
 */
    public void cadastraNota(int nota, double valorNota){
        if (nota == 1){
            this.notas[0] = valorNota;
        } else if (nota == 2){
            this.notas[1] = valorNota;
        } else if (nota == 3){
            this.notas[2] = valorNota;
        } else {
            this.notas[3] = valorNota;
        }
    }
    public double setMedia(){
        return (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
    }

/*
 * identifica se, pela média do aluno nas 4 provas ele está ou não aprovado,
 * tomando como média o valor 7.0.
 * 
 * @return o resultado da verificação
 */
    public boolean aprovado(){
        if (setMedia() >= 7.0){
            return true;
        } else {
            return false;
        }
    }
/*
 * retorna o nome da disciplica, a quantidade de horas dedicadas, as notas obtidas pelo aluno e a média dessas,
 * no fomarto "Disciplina horas média [notas]".
 */
    public String toString() {
        return this.nomeDiscip + " " + this.horasDedicadas + " " + setMedia() + " " + Arrays.toString(this.notas);
    }
}   


