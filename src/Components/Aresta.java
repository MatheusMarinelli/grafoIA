package Components;

import Enums.Peso;
import Enums.Sentido;

public class Aresta {

    private Peso peso;
    private Vertice x,y;
    private Sentido sentido;

    public Aresta(Vertice x, Vertice y, Sentido sentido) {
        this.x = x;
        this.y = y;
        this.sentido = sentido;
    }

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
}
