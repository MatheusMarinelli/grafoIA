package Enums;

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

    public Sentido getSentido(int opcao) {
        switch (opcao) {
            case 1:
                return VERTICAL_CIMA;
            case 2:
                return VERTICAL_BAIXO;
            case 3:
                return HORIZONTAL_DIREITA;
            case 4:
                return HORIZONTAL_ESQUERDA;
            case 5:
                return DIAGONAL_BAIXO_ESQUERDA;
            case 6:
                return DIAGONAL_BAIXO_DIREITA;
            case 7:
                return DIAGONAL_CIMA_ESQUERDA;
            case 8:
                return DIAGONAL_CIMA_DIREITA;
            default:
                return null;
        }
    }
}
