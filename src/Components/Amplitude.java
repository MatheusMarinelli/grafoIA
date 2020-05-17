package Components;

import Enums.Cor;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Essa classe representa o algoritmo que será usado na busca do caminho
 */
public class Amplitude {

    private Queue<Vertice> filaVertices;
    private Grafo grafo;
    private static Vertice verticeFila;

    public Amplitude(Grafo grafo, Vertice vertice){
        filaVertices = new LinkedList<>();
        this.grafo = grafo;
        filaVertices.add(vertice);
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
        grafo.getGrafo();
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


}
