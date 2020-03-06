package Components;

import Enums.Peso;
import Enums.Sentido;

import java.util.Scanner;

public class Grafo {
    private Vertice[][] grafo;
    private final int linhas = 3;
    private int colunas;
    private Double matrizAdjacencia[][];

    public Grafo(int colunas) {
        this.colunas = colunas;
        grafo = criarGrafo();
    }

    /**
     * Cria o Grafo
     * @return retorna os vértcies de um grafo
     */
    private Vertice[][] criarGrafo() {
        Vertice[][] aux = new Vertice[linhas][colunas];

        for (int i=0; i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                aux[i][j] = new Vertice(i,j);
            }
        }

        return aux;
    }

    public void mostrarGrafo() {
        for (int i=0; i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                System.out.print(grafo[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

    public void preencherArestas() {
        exibirMenu();
        for (int i=0;i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
//                clearScreen();
                exibirMenu();
                System.out.print("Aresta " + grafo[i][j].getId());


                int opcao;
                do { // solicitando uma ou mais direções para criação de arestas
                    Scanner sc = new Scanner(System.in);
                    Sentido s = null;
                    System.out.print("Digite uma das opções acima: ");
                    opcao = sc.nextInt();

                    if (checkOption(grafo[i][j],s.getSentido(opcao))) {

                    }


                    sc.close();
                } while (opcao != 0);


            }
        }

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void exibirMenu() {
        System.out.println("Não inserir arestas no vértice  [0]");
        System.out.println("Vertical para cima              [1]");
        System.out.println("Vertical para baixo             [2]");
        System.out.println("Horizontal para a direita       [3]");
        System.out.println("Horizontal para a esquerda      [4]");
        System.out.println("Diagonal esquerda para baixo    [5]");
        System.out.println("Diagonal direita para baixo     [6]");
        System.out.println("Diagonal esquerda para cima     [7]");
        System.out.println("Diagonal direita para cima      [8]");
    }

    private boolean checkOption(Vertice v, Sentido sentido) {
        //testando a HORIZONTAL DIREITA
        if (sentido == Sentido.HORIZONTAL_DIREITA && grafo[v.getLinha()][v.getColuna() + 1] != null) {
            //inserir na matriz de adjacencia
        }

        //testando a HORIZONTAL ESQUERDA
        if (sentido == Sentido.HORIZONTAL_ESQUERDA && grafo[v.getLinha()][v.getColuna() - 1] != null) {

        }

        //testando a VERTICAL CIMA
        if (sentido == Sentido.VERTICAL_CIMA && grafo[v.getLinha() - 1][v.getColuna()] != null) {

        }

        //testando a VERTICAL BAIXO
        if (sentido == Sentido.VERTICAL_BAIXO && grafo[v.getLinha() + 1][v.getColuna()] != null) {

        }

        //testando a DIAGONAL BAIXO DIREITA

        return false;
    }


}
