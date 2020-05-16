package Components;

import Enums.Cor;

import java.util.List;
import java.util.Queue;

/**
 * Essa classe representa o algoritmo que será usado na busca do caminho
 */
public class Amplitude {

    private Queue<Vertice> filaVertices;
    private Grafo grafo;;

    public Amplitude(Grafo grafo){
        this.grafo = grafo;
    }

    /**
     * Algoritmo que será rodado para encontrar a rota mais curta
     * @param inicio vértice de início
     * @return retorna a distância percorrida
     */
    public void buscarRota(Vertice inicio) {
        atualizaCor(inicio,Cor.CINZA);

        //percorrer a matriz de adjacencia para achar os filhos do vertice inicial
        for (int i=0;i<grafo.getMatrizAdjacencia().size();i++) {
            if (grafo.getMatrizAdjacencia().get(i)[inicio.getIdVertice()-(i+1)] != 0)
                adicionarVerticeFila(i);
        }


        //add os filhos na fila de vertice
        //mudar a cor dos filhos

    }

    private void adicionarVerticeFila(int posicaoVetor) {
        for (int i = 0; i<grafo.getLinhas();i++) {
            for (int j=0;j<grafo.getColunas();j++) {
                if (grafo.getGrafo()[i][j].getIdVertice() == posicaoVetor) {
                    if (!isAtTree(grafo.getGrafo()[i][j]))
                        atualizaCor(grafo.getGrafo()[i][j],Cor.CINZA);
                        filaVertices.add(grafo.getGrafo()[i][j]);
                    break;
                }
            }
        }
    }

    private void atualizaCor(Vertice vertice, Cor cor){
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
