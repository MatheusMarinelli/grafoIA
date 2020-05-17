package Components;

import Enums.Cor;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private char id;
    private int linha;
    private int coluna;
    private static int indiceId = 0;
    private int idVertice;
    private static int rgVertice = 0; //identifica o vertice p/ a matriz de adjacencia
    private Cor cor;
    private List<Vertice> filhos;

    public Vertice(int linha, int coluna) {
        id = gerarId();
        this.linha = linha;
        this.coluna = coluna;
        idVertice = gerarNumeroVertice();
        cor = Cor.BRANCO;
        filhos = new ArrayList<>();
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

    public int getIdVertice() {
        return idVertice;
    }

    /**
     * IDENTIFICADOR DO VÉRTICE
     * (A,B,C,D,E...)
     * @return retorna uma letra identificando o vértice
     */
    private char gerarId() {
        indiceId++;
        return (char) (64+indiceId);
    }

    /**
     * REGISTRA O ID NUMÉRICO PARA O VÉRTICE
     * SER MANIPULADO NA MATRIZ DE ADJACÊNCIA
     *
     * @return retorna o ID numérico do vértice
     */
    private int gerarNumeroVertice() {
        return rgVertice++;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public List<Vertice> getFilhos() {
        return filhos;
    }
}
