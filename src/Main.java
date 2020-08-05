import Components.Amplitude;
import Components.Grafo;
import Components.HUD;
import Components.Vertice;

import java.util.Scanner;

/**
 * PROGRAMA PRINCIPAL
 */
public class Main {
    public static void main(String[] args) {
        HUD hud = new HUD();
        Scanner sc = new Scanner(System.in); // objeto de leitura
        Vertice vInicio,vFim;
        Grafo grafo;

        Grafo.setScanner(sc);
        hud.nomeAlgotirmo();
        grafo = new Grafo();
        grafo.mostrarGrafo();
        grafo.preencherArestas();

        vInicio = grafo.getVerticeInicial();
        vFim = grafo.getVerticeFinal();

        grafo.exibirMatrizAdjacencia();
        hud.mostrarCaminho();

        Amplitude amplitude = new Amplitude(grafo,vInicio,vFim);
        amplitude.buscarRota();
        amplitude.mostrarCaminho();
        System.out.println();
        System.out.print("Distância percorrida: " + amplitude.distanciaPercorrida());
        System.out.println();
        System.out.printf("Distância Manhattan entre %c e %c: %2d",vInicio.getVertice(),vFim.getVertice(),amplitude.distanciaManhattan());

        sc.close();
    }
}
