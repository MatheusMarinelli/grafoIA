package Enums;

/**
 * REPRESENTA O SENTIDO DAS ARESTAS COM UM IDENTIFICADOR
 * DE SENTIDO (ID)
 */
public enum Sentido {
    VERTICAL_CIMA (1),
    VERTICAL_BAIXO (2),
    HORIZONTAL_DIREITA (3),
    HORIZONTAL_ESQUERDA (4),
    DIAGONAL_BAIXO_ESQUERDA (5),
    DIAGONAL_BAIXO_DIREITA (6),
    DIAGONAL_CIMA_ESQUERDA (7),
    DIAGONAL_CIMA_DIREITA (8);

    private int sentido;

    public int getSentido() {
        return sentido;
    }

    Sentido (int sentido) {
        this.sentido = sentido;
    }
}
