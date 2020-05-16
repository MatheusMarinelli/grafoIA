import Components.Grafo;
import java.util.Scanner;

/**
 * PROGRAMA PRINCIPAL
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // objeto de leitura
        int colunas;

        do { // solicitando a qtde de colunas do grafo
            System.out.print("Digite a quantidade de colunas do seu Grafo [2 -- 6]: ");
            colunas = sc.nextInt();
        } while(colunas < 2 || colunas > 6); //restringindo a qtde min. e max. de colunas do grafo

        Grafo g = new Grafo(colunas); // criando o grafo
        g.mostrarGrafo();

        System.out.println("Preencha as arestas do grafo...\n");
        g.preencherArestas();

        System.out.println("-------------------------------------");
        System.out.println("Matriz de Adjacência");
        g.exibirMatrizAdjacencia();

        sc.close();
    }
}
