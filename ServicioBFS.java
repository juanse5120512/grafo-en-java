
import java.util.*;

public class ServicioBFS {
	private Grafo<?> grafo;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
	}

	
	public List<Integer> bfsForest() {
		List<Integer> forest = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		for (Integer node : obtenerVertices()) {
			if (!visited.contains(node)) {
				List<Integer> tree = bfsTree(node, visited);
				forest.addAll(tree);
			}
		}

		return forest;
	}
	
	private List<Integer> bfsTree(Integer node, Set<Integer> visited) {
		List<Integer> tree = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
	
		visited.add(node);
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			Integer currNode = queue.poll();
			tree.add(currNode);
			
			for (Integer ady : obtenerAdyacentes(currNode)) {
				if (!visited.contains(ady)) {
					visited.add(ady);
					queue.offer(ady);
				}
			}
		}
		
		return tree;
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