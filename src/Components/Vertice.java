package Components;

public class Vertice {
    private char id;
    private int linha;
    private int coluna;
    private static int indiceId = 0;

    public Vertice(int linha, int coluna) {
        id = gerarId();
        this.linha = linha;
        this.coluna = coluna;
    }


    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    private char gerarId() {
        indiceId++;
        return (char) (64+indiceId);
    }
}
