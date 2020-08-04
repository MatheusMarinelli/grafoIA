package Components;

import Enums.Peso;
import Enums.Sentido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Classe Responsável pelo GRAFO
 */
public class Grafo {
    private Vertice[][] grafo;
    private final int linhas = 3;
    private int colunas;
    private List<Double[]> matrizAdjacencia;
    private ArrayList<Aresta> arestasGrafo;
    private HUD hud = new HUD();
    private Scanner sc;

    /**
     * CRIA UM NOVO GRAFO
     * @param colunas quantidade de colunas (2 a 6)
     */
    public Grafo(int colunas, Scanner sc) {
        this.colunas = colunas;
        grafo = criarGrafo();
        arestasGrafo = new ArrayList<>();
        this.sc = sc;
        newMatrizAdjacencia();
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
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("\t\t\t\tGRAFO GERADO");
        System.out.println("=====================================================");

        for (int i=0; i<linhas;i++) {
            System.out.print("\t\t\t\t\t");
            for (int j=0;j<colunas;j++) {
                System.out.print(grafo[i][j].getId() + " ");
            }
            System.out.println();
        }
        System.out.println("=====================================================");
    }

    /**
     * Cria a matriz de adjacência utilizando vetores
     * e inicializa cada posição dos vetores com 0.0
     *
     * Matriz de adjacência é uma lista de vetores
     */
    private void newMatrizAdjacencia() {
        matrizAdjacencia = new ArrayList<>();
        for (int i = (linhas*colunas)-1;i >= 1;i--){
             matrizAdjacencia.add(new Double[i]);
        }

        for (int i = 0;i<matrizAdjacencia.size();i++){
            for (int j = 0;j<matrizAdjacencia.get(i).length;j++){
                matrizAdjacencia.get(i)[j] = 0.0;
            }
        }
    }

    /**
     * MÉTODO QUE EFETUA O PREENCHIMENTO DAS ARESTAS
     * DENTRO DO GRAFO
     */
    public void preencherArestas() {
        hud.exibirMenu();

        //PERCORRENDO TODOS OS VÉRTICES DO GRAFO
        for (int i=0;i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
//                clearScreen();
                System.out.println("=====================================================");
                System.out.print("Aresta " + grafo[i][j].getId() + "\n");

                int opcao; //opção de inserção de uma nova aresta baseado no ID da ENUM Sentido
                do { // solicitando uma ou mais direções para criação de arestas

                    System.out.print("Digite uma das opções acima: ");
                    opcao = sc.nextInt();

                    if (opcao < 0 || opcao > 8)
                        System.out.println("Opção inválida!!!");

                    if (opcao != 0) {
                        //VERIFICANDO SE É POSSÍVEL INSERIR A ARESTA
                        checkOption(grafo[i][j],new Aresta().getSentido(opcao));
                    }
                } while (opcao != 0); // SE 0 VAI PARA O PRÓXIMO VÉRTICE
            }
        }

        matrizAdjacencia = inserirArestasMatrizAdjacencia();
    }



    /**
     * VALIDA SE A OPÇÃO DO USUÁRIO É VÁLIDA
     * PARA INSERIR UMA NOVA ARESTA
     *
     * @param v vértice em que o usuário está
     * @param sentido sentido de inserção da aresta
     */
    private void checkOption(Vertice v, Sentido sentido) {
        Aresta novaAresta;
        try {

            //testando a HORIZONTAL DIREITA
            if (sentido == Sentido.HORIZONTAL_DIREITA && grafo[v.getLinha()][v.getColuna() + 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha()][v.getColuna() + 1],sentido,Peso.UM);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a HORIZONTAL ESQUERDA
            if (sentido == Sentido.HORIZONTAL_ESQUERDA && grafo[v.getLinha()][v.getColuna() - 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha()][v.getColuna() - 1],sentido,Peso.UM);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                    }
            }

            //testando a VERTICAL CIMA
            if (sentido == Sentido.VERTICAL_CIMA && grafo[v.getLinha() - 1][v.getColuna()] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() - 1][v.getColuna()],sentido,Peso.UM);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a VERTICAL BAIXO
            if (sentido == Sentido.VERTICAL_BAIXO && grafo[v.getLinha() + 1][v.getColuna()] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() + 1][v.getColuna()],sentido,Peso.UM);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a DIAGONAL BAIXO DIREITA
            if (sentido == Sentido.DIAGONAL_BAIXO_DIREITA && grafo[v.getLinha() + 1][v.getColuna() + 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() + 1][v.getColuna() + 1],sentido,Peso.DOIS);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a DIAGONAL BAIXO ESQUERDA
            if (sentido == Sentido.DIAGONAL_BAIXO_ESQUERDA && grafo[v.getLinha() + 1][v.getColuna() - 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() + 1][v.getColuna() - 1],sentido,Peso.DOIS);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a DIAGONAL CIMA DIREITA
            if (sentido == Sentido.DIAGONAL_CIMA_DIREITA && grafo[v.getLinha() - 1][v.getColuna() + 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() - 1][v.getColuna() + 1],sentido,Peso.DOIS);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }

            //testando a DIAGONAL CIMA ESQUERDA
            if (sentido == Sentido.DIAGONAL_CIMA_ESQUERDA && grafo[v.getLinha() - 1][v.getColuna() - 1] != null) {
                novaAresta = new Aresta(v,grafo[v.getLinha() - 1][v.getColuna() - 1],sentido,Peso.DOIS);
                if (!Aresta.arestaExiste(arestasGrafo,novaAresta)) { // testa se a aresta existe
                    if (!novaAresta.posicaoVerticesValido(novaAresta.getX(),novaAresta.getY()))
                        novaAresta = novaAresta.inverterVertices(novaAresta);
                    arestasGrafo.add(novaAresta);
                }
            }
        } catch (Exception e) {
            System.out.println("Não é possível inserir uma aresta!!!");
        }
    }

    /**
     * Exibe a matriz de adjacência
     */
    public void exibirMatrizAdjacencia() {
        System.out.println("=====================================================");
        System.out.println("MATRIZ DE ADJACÊNCIA");
        System.out.println("=====================================================");
        //Exibir as letras na HORIZONTAL
        System.out.printf("\t %-4s"," ");
        for (int i =1;i<(getLinhas()*getColunas());i++){
            System.out.printf("%c%-7s",Vertice.getVerticeById(this,i)," ");
        }
        System.out.println();

        for (int i = 0;i<matrizAdjacencia.size();i++) {
            formatarMatrizAdjacencia(i);
            for (int j=0;j<matrizAdjacencia.get(i).length;j++) {
                System.out.printf("%.5f ",matrizAdjacencia.get(i)[j]);
            }
            System.out.println();
        }
        System.out.println("=====================================================");
    }

    /**
     * Gera o espaçamento inicial na exibição da matriz
     * @param i posição do laço na matriz
     */
    private void formatarMatrizAdjacencia(int i) {
        System.out.print(Vertice.getVerticeById(this,i));
        for (int aux=0;aux<=i;aux++) {
            System.out.printf("%-7s "," ");
        }
    }

    /**
     * Insere os pesos das arestas na matriz de adjacência
     * @return retorna a matriz de adjacência preenchida
     */
    private List<Double[]> inserirArestasMatrizAdjacencia() {
        for (int i = 0; i< matrizAdjacencia.size();i++) { // percorre os vetores da matriz de adjacência
            for (Aresta a:arestasGrafo) { // percorre as arestas do grafo inseridas pelo usuário
                if (a.getX().getIdVertice() == i) { // se o id do vértice for igual a posição do vetor, insere o peso na matriz
                    matrizAdjacencia.get(i)[a.getY().getIdVertice() - (a.getX().getIdVertice() + 1)] = a.getPeso().getValor();
                }
            }
        }
        //retorna a matriz de adjacência com os pesos
        return matrizAdjacencia;
    }

    public Vertice[][] getGrafo() {
        return grafo;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public List<Double[]> getMatrizAdjacencia() {
        return matrizAdjacencia;
    }

    public Vertice getVerticeByChar(char vertice) {
        for (int i=0;i<getLinhas();i++) {
            for (int j=0;j<getColunas();j++) {
                if (grafo[i][j].getId() == vertice)
                    return grafo[i][j];
            }
        }
        return null;
    }

    public ArrayList<Aresta> getArestasGrafo() {
        return arestasGrafo;
    }
}
