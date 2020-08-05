package Components;

public class HUD {

    public void nomeAlgotirmo() {
        // exibindo o nome do algoritmo usado
        System.out.println("******************************IMPORTANTE******************************");
        System.out.println("**********************************************************************");
        System.out.println("Nome do algoritmo utilizado: Busca em Largura ou Amplitude (B-F-S)");
        System.out.println("**********************************************************************");
        System.out.println();
        System.out.println();
    }

    /**
     * MENU COM AS OPÇÕES DE INSERÇÃO DE ARESTA
     */
    public void exibirMenu() {
        System.out.println("\nPreencha as arestas do grafo...\n");
        System.out.println("=====================================================");
        System.out.println("Não inserir arestas no vértice  [0]");
        System.out.println("Vertical para cima              [1]");
        System.out.println("Vertical para baixo             [2]");
        System.out.println("Horizontal para a direita       [3]");
        System.out.println("Horizontal para a esquerda      [4]");
        System.out.println("Diagonal esquerda para baixo    [5]");
        System.out.println("Diagonal direita para baixo     [6]");
        System.out.println("Diagonal esquerda para cima     [7]");
        System.out.println("Diagonal direita para cima      [8]");
        System.out.println("=====================================================");
    }

    /**
     * Apenas mostra o texto abaixo no console
     */
    public void mostrarCaminho() {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("MOSTRANDO O CAMINHO");
        System.out.println("=====================================================");
    }



}
