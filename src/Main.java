import Components.Amplitude;
import Components.Grafo;
import Components.Vertice;

import java.util.Scanner;

/**
 * PROGRAMA PRINCIPAL
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // objeto de leitura
        int colunas;
        char inicio,fim;
        Vertice vInicio,vFim;

        // exibindo o nome do algoritmo usado
        System.out.println("******************************IMPORTANTE******************************");
        System.out.println("**********************************************************************");
        System.out.println("Nome do algoritmo utilizado: Busca em Largura ou Amplitude (B-F-S)");
        System.out.println("**********************************************************************");


        System.out.println();
        System.out.println();
        do { // solicitando a qtde de colunas do grafo
            System.out.print("Digite a quantidade de colunas do seu Grafo [2 -- 6]: ");
            colunas = sc.nextInt();
        } while(colunas < 2 || colunas > 6); //restringindo a qtde min. e max. de colunas do grafo

        System.out.println();
        System.out.println("=====================================================");
        System.out.println("\t\t\t\tGRAFO GERADO");
        System.out.println("=====================================================");
        Grafo g = new Grafo(colunas); // criando o grafo
        g.mostrarGrafo();
        System.out.println("=====================================================");

        do { // solicita o início do caminho
            System.out.print("Digite o vértice de início: ");
            inicio = sc.next().toUpperCase().charAt(0);
            vInicio = g.getVerticeByChar(inicio);
        } while (vInicio.equals(null));

        do { // solicita o final do caminho
            System.out.print("Digite o vértice final: ");
            fim = sc.next().toUpperCase().charAt(0);
            vFim = g.getVerticeByChar(fim);
        } while (vFim.equals(null));
        System.out.println("=====================================================");


        System.out.println();
        System.out.println("Preencha as arestas do grafo...\n");
        g.preencherArestas();

        System.out.println("=====================================================");
        System.out.println("Matriz de Adjacência");
        System.out.println("=====================================================");
        g.exibirMatrizAdjacencia();
        System.out.println("=====================================================");

        System.out.println();
        System.out.println("=====================================================");
        System.out.println("Mostrando o caminho");
        System.out.println("=====================================================");
        Amplitude a = new Amplitude(g,vInicio,vFim);
        a.buscarRota();
        System.out.print("Vértices percorridos: ");
        a.mostrarCaminho();
        System.out.println();
        System.out.print("Distância percorrida: " + a.distanciaPercorrida());
        System.out.println();
        System.out.printf("Distância Manhattan entre %c e %c: %2d",inicio,fim,a.distanciaManhattan());


        sc.close();
    }
}
