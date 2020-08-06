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
        hud.exibirVerticesPercorridos(amplitude.getCaminhoPercorrido());
        hud.exibirDistanciaPercorrida(amplitude.distanciaPercorrida());
        hud.exibirDistanciaManhattan(amplitude.getVerticeInicial(),amplitude.getVerticeFinal(),amplitude.distanciaManhattan());

        sc.close();
    }
}
