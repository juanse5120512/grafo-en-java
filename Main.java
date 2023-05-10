import java.util.*;

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

        ServicioDFS servicio = new ServicioDFS(grafo);

        List<Integer> resultado = servicio.dfsForest();

        System.out.println(resultado);
    }
}
