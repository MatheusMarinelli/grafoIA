package Components;

import Enums.Cor;

import java.util.List;
import java.util.Queue;

/**
 * Essa classe representa o algoritmo que será usado na busca do caminho
 */
public class Amplitude {

    private Queue<Vertice> filaVertices;
    private Grafo grafo;

    public Amplitude(Grafo grafo, Vertice vertice){
        this.grafo = grafo;
        filaVertices.add(vertice);
    }

    /**
     * Algoritmo que será rodado para encontrar a rota mais curta
     * @return retorna a distância percorrida
     */
    public void buscarRota() {

        //percorrer a matriz de adjacencia para achar os filhos do vertice inicial
        Vertice aux = filaVertices.remove();
        buscarLinhaVetor(aux);
        buscarColuna(aux);

    }

    /**
     * Busca na coluna do vértice em questão se ele faz aresta com os seus anteriores
     * @param vertice
     */
    private void buscarColuna(Vertice vertice) {
        for (int i=0;i<grafo.getMatrizAdjacencia().size();i++) { //lógica para verificar nas colunas dos vetores
            int posicao = vertice.getIdVertice()-(i+1);
            if (grafo.getMatrizAdjacencia().get(i)[posicao] != 0) {
                adicionarVerticeFila(i);
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
            if (i == vertice.getIdVertice()) {
                for (int j = 0;j<grafo.getMatrizAdjacencia().get(i).length;j++) {
                    if (grafo.getMatrizAdjacencia().get(i)[j] != 0) {
                        adicionarVerticeFila(vertice.getIdVertice() + i + 1);
                    }
                }
            }
        }
    }

    private void adicionarVerticeFila(int idVertice) {
        for (int i = 0; i<grafo.getLinhas();i++) {
            for (int j=0;j<grafo.getColunas();j++) {
                if (grafo.getGrafo()[i][j].getIdVertice() == idVertice) {
                    if (!isAtTree(grafo.getGrafo()[i][j]))
                        atualizaCor(grafo.getGrafo()[i][j],Cor.CINZA);
                        filaVertices.add(grafo.getGrafo()[i][j]);
                    break;
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


}
