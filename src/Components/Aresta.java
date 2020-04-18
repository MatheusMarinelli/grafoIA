package Components;

import Enums.Peso;
import Enums.Sentido;

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
}
