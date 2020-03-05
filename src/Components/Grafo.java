package Components;

public class Grafo {
    private Vertice[][] grafo;
    private final int linhas = 3;
    private int colunas;

    public Grafo(int colunas) {
        this.colunas = colunas;
        grafo = criarGrafo();
    }

    /**
     * Cria o Grafo
     * @return retorna os vértcies de um grafo
     */
    private Vertice[][] criarGrafo() {
        Vertice[][] aux = new Vertice[linhas][colunas];

        for (int i=0; i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                aux[i][j] = new Vertice(i,j);
            }
        }

        return aux;
    }

    public void mostrarGrafo() {
        for (int i=0; i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                System.out.print(grafo[i][j].getId() + " ");
            }
            System.out.println();
        }
    }

    public void preencherArestas() {

        for (int i=0;i<linhas;i++) {
            for (int j=0;j<colunas;j++) {
                clearScreen();
                System.out.print(grafo[i][j]);






            }
        }

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void exibirMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
