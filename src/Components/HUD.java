package Components;

import java.util.List;

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

    public void exibirVerticesPercorridos(List<Vertice> caminho) {
        System.out.print("Vértices percorridos: ");
        for (int i=caminho.size()-1;i>=0;i--) {
            if (i==0)
                System.out.print(caminho.get(i).getVertice());
            else
                System.out.print(caminho.get(i).getVertice() + "-");
        }
    }

    public void exibirDistanciaPercorrida(Double distanciaPercorrida) {
        System.out.print("\nDistância percorrida: " + distanciaPercorrida);
    }

    /**
     * Exibe a distância Manhattan entreo vértice inicial e o vértice final
     *
     */
    public void exibirDistanciaManhattan(Vertice inicio, Vertice fim, int distanciaManhattan) {
        System.out.printf("\nDistância Manhattan entre %c e %c: %2d",
                inicio.getVertice(), fim.getVertice(), distanciaManhattan);
    }

}
