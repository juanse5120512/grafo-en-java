package test;
import java.util.*;

import grafo.GrafoDirigido;
import servicios.ServicioBFS;
import servicios.ServicioCaminos;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArco(1, 2, 90);
        grafo.agregarArco(2, 3, 233);
        grafo.agregarArco(2, 4, 100);
        grafo.agregarArco(1, 5, 140);
        grafo.agregarArco(5, 4, 2131);

        ServicioBFS servicio = new ServicioBFS(grafo);

        List<Integer> resultado = servicio.bfsForest();

        System.out.println(resultado);

        ServicioCaminos sc = new ServicioCaminos(grafo, 1, 4, 1);
        System.out.println(sc.caminos());
    }
}
