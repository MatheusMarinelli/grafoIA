package Components;

import Enums.Peso;
import Enums.Sentido;

import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
    private Vertice[][] grafo;
    private final int linhas = 3;
    private int colunas;
    private Double matrizAdjacencia[][];
    private ArrayList<Aresta> arestasGrafo;

    public Grafo(int colunas) {
        this.colunas = colunas;
        grafo = criarGrafo();
        arestasGrafo = new ArrayList<>();
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
            arestasGrafo.add(new Aresta(v,grafo[v.getLinha()][v.getColuna() + 1],sentido,Peso.UM));
            //add na matriz de adjacencia
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
        if (sentido == Sentido.DIAGONAL_BAIXO_DIREITA && grafo[v.getLinha() + 1][v.getColuna() + 1] != null) {

        }

        //testando a DIAGONAL BAIXO ESQUERDA
        if (sentido == Sentido.DIAGONAL_BAIXO_ESQUERDA && grafo[v.getLinha() + 1][v.getColuna() - 1] != null) {

        }

        //testando a DIAGONAL CIMA DIREITA
        if (sentido == Sentido.DIAGONAL_CIMA_DIREITA && grafo[v.getLinha() - 1][v.getColuna() + 1] != null) {

        }
        //testando a DIAGONAL CIMA ESQUERDA
        if (sentido == Sentido.DIAGONAL_CIMA_ESQUERDA && grafo[v.getLinha() - 1][v.getColuna() - 1] != null) {

        }

        return false;
    }


}
