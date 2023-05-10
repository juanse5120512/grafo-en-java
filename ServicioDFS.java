import java.util.*;

public class ServicioDFS {

    private Grafo<?> grafo;

    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
    }

    public List<Integer> dfsForest() {
        Set<Integer> visitados = new HashSet<>();
        List<Integer> finalizados =  new ArrayList<>();
        List<Integer> auxFinalizados = new ArrayList<>();
        for (Integer vertice : obtenerVertices()) {
            if (!visitados.contains(vertice)) {
                auxFinalizados = dfs(vertice, visitados);
                finalizados.addAll(auxFinalizados);
            }
        }
        return finalizados;
    }

    private List<Integer> dfs(Integer u, Set<Integer> visitados) {
        List<Integer> finalizados = new ArrayList<>();
        visitados.add(u);
        for (Integer v : obtenerAdyacentes(u)) {
            if (!visitados.contains(v)) {
                List<Integer> resultadoTemporal = dfs(v, visitados);
                finalizados.addAll(resultadoTemporal);
            }
        }
        finalizados.add(u);
        return finalizados;
    }

    public Set<Integer> obtenerVertices() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        Set<Integer> vertices = new HashSet<Integer>();
        while (it.hasNext()) {
            int vertice = it.next();
            vertices.add(vertice);
        }
        return vertices;
    }

    public Set<Integer> obtenerAdyacentes(Integer vertice) {
        Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
        Set<Integer> adyacentes = new HashSet<Integer>();
        while (it.hasNext()) {
            int adyacente = it.next();
            adyacentes.add(adyacente);
        }
        return adyacentes;
    }

}
