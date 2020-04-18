package Enums;

/**
 * ENUM QUE REPRESENTA O PESO DAS ARESTAS
 */
public enum Peso {

    UM (1.0), //PESO NA HORIZONTAL OU VERTICAL
    DOIS (Math.sqrt(2.0)); // PESO DA DIAGONAL

    private double valor;

    public double getValor() {return valor;}
    Peso(double valor) {this.valor = valor;}
}
