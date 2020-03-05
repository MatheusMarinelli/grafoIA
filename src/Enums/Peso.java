package Enums;

public enum Peso {

    UM (1.0),
    DOIS (Math.sqrt(2.0));

    private double valor;

    public double getValor() {return valor;}
    Peso(double valor) {this.valor = valor;}
}
