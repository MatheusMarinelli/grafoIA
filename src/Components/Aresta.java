package Components;

import Enums.Peso;
import Enums.Sentido;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Aresta {

    private Peso peso;
    private Vertice x,y;
    private Sentido sentido;

    public Aresta(Vertice x, Vertice y, Sentido sentido, Peso peso) {
        this.x = x;
        this.y = y;
        this.sentido = sentido;
        this.peso = peso;
    }

    public Aresta(Vertice x, Vertice y){
        this.x = x;
        this.y = y;
    }

    public Aresta(){}

    public Vertice getX() {
        return x;
    }

    public Vertice getY() {
        return y;
    }

    public Peso getPeso() {
        return peso;
    }

    public Sentido getSentido() {
        return sentido;
    }

    public boolean validarAresta() {
        return true;
    }

    /**
     * PEGA O SENTIDO DA ARESTA QUE SE DESEJA INSERIR
     * BASEADO NO PARÂMETRO
     *
     * @param opcao sentido da aresta a ser inserida
     * @return retorna o sentido que se deseja inserir a aresta
     */
    public Sentido getSentido(int opcao) {
        switch (opcao) {
            case 1:
                return Sentido.VERTICAL_CIMA;
            case 2:
                return Sentido.VERTICAL_BAIXO;
            case 3:
                return Sentido.HORIZONTAL_DIREITA;
            case 4:
                return Sentido.HORIZONTAL_ESQUERDA;
            case 5:
                return Sentido.DIAGONAL_BAIXO_ESQUERDA;
            case 6:
                return Sentido.DIAGONAL_BAIXO_DIREITA;
            case 7:
                return Sentido.DIAGONAL_CIMA_ESQUERDA;
            case 8:
                return Sentido.DIAGONAL_CIMA_DIREITA;
            default:
                return null;
        }
    }

    /**
     * Verifica se existe a aresta oposta a do parâmetro
     * Ex: deseja-se inserir a aresta D-C, o método verificará se existe C-D
     *
     * @param arestas  todas as arestas inseridas
     * @param novaAresta aresta que se deseja inserir
     * @return true (aresta já existe), false (aresta não existe)
     */
    public static boolean arestaExiste(ArrayList<Aresta> arestas, Aresta novaAresta) {

        for (Aresta a : arestas) { // valida se existe a aresta passada (ex: D-C)
            if (a.x == novaAresta.x && a.y == novaAresta.y)
                return true;
        }

        //caso não ache a aresta, tenta a achar a aresta oposta (ex: C-D)
        Aresta aux = new Aresta(novaAresta.getY(),novaAresta.getX());

        for (Aresta a : arestas) { // procurando a aresta oposta (ex: C-D)
            if (a.x == aux.x && a.y == aux.y)
                return true;
        }
        return false;
    }

    public boolean posicaoVerticesValido(Vertice x, Vertice y) {
        return x.getIdVertice() < y.getIdVertice();
    }

    public Aresta inverterVertices(Aresta aresta) {
        Vertice aux = aresta.x;
        aresta.x = aresta.y;
        aresta.y = aux;
        return aresta;
    }

    public void setX(Vertice x) {
        this.x = x;
    }

    public void setY(Vertice y) {
        this.y = y;
    }
}
