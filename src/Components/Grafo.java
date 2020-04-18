package Components;

import Enums.Peso;
import Enums.Sentido;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Classe Responsável pelo GRAFO
 */
public class Grafo {
    private Vertice[][] grafo;
    private final int linhas = 3;
    private int colunas;
    private Double matrizAdjacencia[][];
    private ArrayList<Aresta> arestasGrafo;

    /**
     * CRIA UM NOVO GRAFO
     * @param colunas quantidade de colunas (2 a 6)
     */
    public Grafo(int colunas) {
        this.colunas = colunas;
        grafo = criarGrafo();
        arestasGrafo = new ArrayList<>();
        matrizAdjacencia = new Double[3*colunas][3*colunas];
    }

    /**
     * Cria o Grafo
     * @return retorna o grafo (matriz de vértices)
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

    /**
     * EXIBE O GRAFO
     */
    public void mostrarGrafo() {
        for (int i=0; i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                System.out.print(grafo[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

    /**
     * MÉTODO QUE EFETUA O PREENCHIMENTO DAS ARESTAS
     * DENTRO DO GRAFO
     */
    public void preencherArestas() {
        exibirMenu();
        Scanner sc = new Scanner(System.in);

        //PERCORRENDO TODOS OS VÉRTICES DO GRAFO
        for (int i=0;i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
//                clearScreen();

                System.out.print("Aresta " + grafo[i][j].getId() + "\n");

                int opcao; //opção de inserção de uma nova aresta baseado no ID da ENUM Sentido
                do { // solicitando uma ou mais direções para criação de arestas

                    System.out.print("Digite uma das opções acima: ");
                    opcao = sc.nextInt();

                    if (opcao != 0) {
                        //VERIFICANDO SE É POSSÍVEL INSERIR A ARESTA
                        checkOption(grafo[i][j],new Aresta().getSentido(opcao));
                    }
                } while (opcao != 0); // SE 0 VAI PARA O PRÓXIMO VÉRTICE
            }
        }
        sc.close();
        completarMatrizAdjacencia();
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * MENU COM AS OPÇÕES DE INSERÇÃO DE ARESTA
     */
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

    /**
     * VALIDA SE OPÇÃO DO USUÁRIO É VÁLIDA
     * PARA INSERIR UM NOVA ARESTA
     *
     * @param v vértice em que o usuário está
     * @param sentido sentido de inserção da aresta
     */
    private void checkOption(Vertice v, Sentido sentido) {
        try {

            //testando a HORIZONTAL DIREITA
            if (sentido == Sentido.HORIZONTAL_DIREITA && grafo[v.getLinha()][v.getColuna() + 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha()][v.getColuna() + 1],sentido,Peso.UM));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha()][v.getColuna() + 1].getIdVertice()] = Peso.UM.getValor();
                matrizAdjacencia[grafo[v.getLinha()][v.getColuna() + 1].getIdVertice()][v.getIdVertice()] = Peso.UM.getValor();
            }

            //testando a HORIZONTAL ESQUERDA
            if (sentido == Sentido.HORIZONTAL_ESQUERDA && grafo[v.getLinha()][v.getColuna() - 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha()][v.getColuna() - 1],sentido,Peso.UM));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha()][v.getColuna() - 1].getIdVertice()] = Peso.UM.getValor();
                matrizAdjacencia[grafo[v.getLinha()][v.getColuna() - 1].getIdVertice()][v.getIdVertice()] = Peso.UM.getValor();
            }

            //testando a VERTICAL CIMA
            if (sentido == Sentido.VERTICAL_CIMA && grafo[v.getLinha() - 1][v.getColuna()] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() - 1][v.getColuna()],sentido,Peso.UM));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() - 1][v.getColuna()].getIdVertice()] = Peso.UM.getValor();
                matrizAdjacencia[grafo[v.getLinha() - 1][v.getColuna()].getIdVertice()][v.getIdVertice()] = Peso.UM.getValor();
            }

            //testando a VERTICAL BAIXO
            if (sentido == Sentido.VERTICAL_BAIXO && grafo[v.getLinha() + 1][v.getColuna()] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() + 1][v.getColuna()],sentido,Peso.UM));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() + 1][v.getColuna()].getIdVertice()] = Peso.UM.getValor();
                matrizAdjacencia[grafo[v.getLinha() + 1][v.getColuna()].getIdVertice()][v.getIdVertice()] = Peso.UM.getValor();
            }

            //testando a DIAGONAL BAIXO DIREITA
            if (sentido == Sentido.DIAGONAL_BAIXO_DIREITA && grafo[v.getLinha() + 1][v.getColuna() + 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() + 1][v.getColuna() + 1],sentido,Peso.DOIS));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() + 1][v.getColuna() + 1].getIdVertice()] = Peso.DOIS.getValor();
                matrizAdjacencia[grafo[v.getLinha() + 1][v.getColuna() + 1].getIdVertice()][v.getIdVertice()] = Peso.DOIS.getValor();
            }

            //testando a DIAGONAL BAIXO ESQUERDA
            if (sentido == Sentido.DIAGONAL_BAIXO_ESQUERDA && grafo[v.getLinha() + 1][v.getColuna() - 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() + 1][v.getColuna() - 1],sentido,Peso.DOIS));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() + 1][v.getColuna() - 1].getIdVertice()] = Peso.DOIS.getValor();
                matrizAdjacencia[grafo[v.getLinha() + 1][v.getColuna() - 1].getIdVertice()][v.getIdVertice()] = Peso.DOIS.getValor();
            }

            //testando a DIAGONAL CIMA DIREITA
            if (sentido == Sentido.DIAGONAL_CIMA_DIREITA && grafo[v.getLinha() - 1][v.getColuna() + 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() - 1][v.getColuna() + 1],sentido,Peso.DOIS));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() - 1][v.getColuna() + 1].getIdVertice()] = Peso.DOIS.getValor();
                matrizAdjacencia[grafo[v.getLinha() - 1][v.getColuna() + 1].getIdVertice()][v.getIdVertice()] = Peso.DOIS.getValor();
            }

            //testando a DIAGONAL CIMA ESQUERDA
            if (sentido == Sentido.DIAGONAL_CIMA_ESQUERDA && grafo[v.getLinha() - 1][v.getColuna() - 1] != null) {
                arestasGrafo.add(new Aresta(v,grafo[v.getLinha() - 1][v.getColuna() - 1],sentido,Peso.DOIS));
                matrizAdjacencia[v.getIdVertice()][grafo[v.getLinha() - 1][v.getColuna() - 1].getIdVertice()] = Peso.DOIS.getValor();
                matrizAdjacencia[grafo[v.getLinha() - 1][v.getColuna() - 1].getIdVertice()][v.getIdVertice()] = Peso.DOIS.getValor();
            }
        } catch (Exception e) {
            System.out.println("Não é possível inserir uma aresta!!!");
        }
    }

    /**
     * Exibe a matriz de adjacência
     */
    public void exibirMatrizAdjacencia() {
//        DecimalFormat df = new DecimalFormat("#.##");
        int t = linhas * colunas;
        for (int i = 0;i<t;i++) {
            for (int j=0;j<t;j++) {
//                String peso = df.format(matrizAdjacencia[i][j]);
//                System.out.print(peso + " ");
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * APÓS O USUÁRIO FINALIZAR A INSERÇÃO DAS ARESTAS, ESSE MÉTODO
     * PEGARÁ AS POSIÇÕES NULL DA MATRIZ (NÃO TEM ARESTA NA POSIÇÃO XY)
     * E SUBSTITUIRÁ PELO VALOR 0.0 (INDICANDO QUE NÃO HÁ ARESTA NA POSIÇÃO XY)
     */
    private void completarMatrizAdjacencia() {
        int t = linhas * colunas;
        for (int i=0;i<t;i++) {
            for (int j=0;j<t;j++) {
                if (matrizAdjacencia[i][j] == null)
                    matrizAdjacencia[i][j] = 0.0;
            }
        }
    }
}
