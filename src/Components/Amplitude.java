package Components;

import Enums.Cor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Essa classe representa o algoritmo que será usado na busca do caminho
 */
public class Amplitude {

    private Queue<Vertice> filaVertices;
    private Grafo grafo;
    private ArrayList<Vertice> caminho;

    public Amplitude(Grafo grafo, Vertice verticeInicial, Vertice verticeFinal){
        filaVertices = new LinkedList<>();
        this.grafo = grafo;
        filaVertices.add(verticeInicial);
        caminho = new ArrayList<>();
        caminho.add(verticeFinal);
    }

    /**
     * Algoritmo que será rodado para encontrar a rota mais curta
     * @return retorna a distância percorrida
     */
    public void buscarRota() {
        //percorrer a matriz de adjacencia para achar os filhos do vertice inicial
        do {
            Vertice aux = filaVertices.remove();
            buscarLinhaVetor(aux);
            buscarColuna(aux);
            atualizaCor(aux,Cor.PRETO);
        } while (!filaVertices.isEmpty());
        buscarVerticesCaminho();

    }

    /**
     * Busca na coluna do vértice em questão se ele faz aresta com os seus anteriores
     * @param vertice
     */
    private void buscarColuna(Vertice vertice) {

        //se for o primeiro vértice gerado, sai do método
        //porque não existe uma coluna da letra A
        if (vertice.getIdVertice() == 0)
            return;

        for (int i=0;i<grafo.getMatrizAdjacencia().size();i++) { //lógica para verificar nas colunas dos vetores
            int posicao = vertice.getIdVertice()-(i+1);
            if (posicao < 0)
                return;
            if (grafo.getMatrizAdjacencia().get(i)[posicao] != 0) {
                adicionarVerticeFila(i,vertice);
            }
        }
    }

    /**
     * Busca os vértices dentro do seu respectivo vetor
     * @param vertice
     */
    private void buscarLinhaVetor(Vertice vertice) {
//lógica para verificar o vetor relacionado ao vertice
        for (int i=0;i<grafo.getMatrizAdjacencia().size();i++) {

            /*  caso seja o último vertice gerado (F numa 3x2)
                ele sai do método, porque a respectiva linha
                com o ID do vértice não existe */
            if (vertice.getIdVertice() == grafo.getMatrizAdjacencia().size())
                return;

            if (i == vertice.getIdVertice()) {
                for (int j = 0;j<grafo.getMatrizAdjacencia().get(i).length;j++) {
                    if (grafo.getMatrizAdjacencia().get(i)[j] != 0) {
                        adicionarVerticeFila(vertice.getIdVertice() + j + 1,vertice);
                    }
                }
            }
        }
    }

    private void adicionarVerticeFila(int idVertice, Vertice pai) {
        for (int i = 0; i<grafo.getLinhas();i++) {
            for (int j=0;j<grafo.getColunas();j++) {
                if (grafo.getGrafo()[i][j].getIdVertice() == idVertice) {
                    if (!isAtTree(grafo.getGrafo()[i][j])) {
                        addVerticeToTree(pai,grafo.getGrafo()[i][j]);
                        atualizaCor(grafo.getGrafo()[i][j],Cor.CINZA);
                        filaVertices.add(grafo.getGrafo()[i][j]);
                        break;
                    }
                }
            }
        }
    }

    private void atualizaCor(Vertice vertice, Cor cor){
        for (int i=0;i<grafo.getLinhas();i++) {
            for (int j=0;j<grafo.getColunas();j++) {
                if (grafo.getGrafo()[i][j].equals(vertice)) {
                    grafo.getGrafo()[i][j].setCor(cor);
                    return;
                }
            }
        }
        vertice.setCor(cor);
    }


    /**
     * Verifica se o vértice já está na árvore
     * @param vertice
     * @return
     */
    private boolean isAtTree(Vertice vertice) {
        if (vertice.getCor().equals(Cor.BRANCO)) {
            return false;
        } else
        return true;
    }

    /**
     * Adiciona o filho de um vértice ao vértice pai
     * @param pai
     * @param filho
     */
    private void addVerticeToTree(Vertice pai, Vertice filho) {
        for (int i=0;i<grafo.getLinhas();i++) {
            for (int j=0;j<grafo.getColunas();j++) {
                if (grafo.getGrafo()[i][j].getIdVertice() == pai.getIdVertice())
                    grafo.getGrafo()[i][j].getFilhos().add(filho);
            }
        }
    }

    /**
     * Buscar quais vértices fazem porte do caminho
     */
    private void buscarVerticesCaminho() {

        int posicao = 0;
        Vertice aux;
        boolean isFilho = false;
        boolean isBreak = false;

        do {
            aux = caminho.get(posicao);
            for (int i=0;i<grafo.getLinhas();i++) {
                if (isBreak)
                    break;
                for (int j=0;j<grafo.getColunas();j++) {
                    if (checkFilho(aux,grafo.getGrafo()[i][j])) {
                        isFilho = caminho.add(grafo.getGrafo()[i][j]);
                        isBreak = true;
                        break;
                    } else {
                        isFilho = false;
                    }
                }
            }
            posicao++;
            isBreak = false;

        } while (isFilho);

    }

    private boolean checkFilho(Vertice filho, Vertice pai) {
        for (Vertice v: pai.getFilhos()) {
            if (filho.getIdVertice() == v.getIdVertice())
                return true;
        }
        return false;
    }

    public void mostrarCaminho() {
        for (int i=caminho.size()-1;i>=0;i--) {
            if (i==0)
                System.out.print(caminho.get(i).getId());
            else
                System.out.print(caminho.get(i).getId() + "-");
        }
    }

    public double distanciaPercorrida() {
        int posicaoV1 = 0, posicaoV2 = 1;
        double total = 0;
        Vertice v1,v2;

        if (caminho.size() == 1) // caso o vertice inicial e final sejam iguais
            return total;

        while (posicaoV2 != caminho.size()) {
            v1 = caminho.get(posicaoV1);
            v2 = caminho.get(posicaoV2);
            Aresta aux = new Aresta(v1,v2);

            if (!aux.posicaoVerticesValido(v1,v2)) {
                aux.setX(v2);
                aux.setY(v1);
            }

            for (Aresta a:grafo.getArestasGrafo()) {
                if (a.getX().equals(aux.getX()) && a.getY().equals(aux.getY())) {
                    total += a.getPeso().getValor();
                    posicaoV1++;
                    posicaoV2++;
                    break;
                }
            }
        }
        return total;
    }


}
