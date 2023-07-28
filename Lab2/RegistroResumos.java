package lab2_leilamedeiros;

/*
 * Um registro dos resumos e anotações, de determinado aluno, que auxiliem nos seus
 * estudos.
 * 
 * @author Leila Medeiros de Farias
 */
public class RegistroResumos {
    
/*
 * uma lista contendo os temas dos resumos que foram anotados;
 * uma lista contendo o corpo dos resumos;
 * uma variável auxiliar para facilitar a movimentação pelas listas.
 */
    private String[] tema;
    private String[] resumo;
    private int aux;

//Construtor
    public RegistroResumos(int numeroDeResumos) {
        this.tema = new String[numeroDeResumos];
        this.resumo = new String[numeroDeResumos];
    }
/*
 * adiciona um resumo e um tema a lista, utilizando da variável auxiliar para
 * que ao lotar a lista, o próximo resumo adicionado seja colocado na primeira
 * posição da lista, ocupando o espaço do que já estava ali.
 * 
 * @para tema o tema do resumo.
 * @para resumo o corpo do resumo.
 */
    public void adiciona(String tema, String resumo) {
        if (aux < this.tema.length) {
            this.tema[aux] = tema;
            this.resumo[aux] = resumo;
            this.aux += 1;
        } else {
            this.aux = 0;
            this.tema[aux] = tema;
            this.resumo[aux] = resumo;
        }
    }
/*
 * retorna quantos resumos há na lista.
 */
    public int conta() {
        int cont = 0;
        for (int i = 0; i < resumo.length; i++){
            if (resumo[i] == null){
                return cont;
            } else {
                cont += 1;
          } 
        } return cont;
    }
/*
 * pega todos os resumos das listas e retorna uma lista com cada um
 * no formato "tema: resumo".
 */
    public String[] pegaResumos(){
        String[] retorno = new String[conta()];
        for (int j = 0; j < conta(); j++){  
            retorno[j] = tema[j] + ": " + resumo[j];
        }
        return retorno; 
    }
/*
 * retorna a quantidade de resumos que foram cadastrados e seus 
 * respectivos temas.
 */
    public String imprimeResumos(){
        String saida = "- ";
        System.out.println("- " + conta() + " resumo(s) cadastrado(s)");
        for (int k = 0; k < conta(); k++){
            if (k < conta() - 1){
                saida += this.tema[k] + " | ";
            } else{
                saida += this.tema[k];
            }
        }
        return saida;
    }
/*
 * verifica se há algum resumo cadastrado sobre determinado tema.
 * 
 * @return de acordo com a verificação, irá retornar um verdadeiro ou falso.
 */
    public boolean temResumo(String tema){
        for (int g = 0; g < conta(); g++){
            if (tema.equals(this.tema[g])){
                return true;
            } 
        }
        return false;
    }    
}

