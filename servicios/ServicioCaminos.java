package servicios;
import java.util.*;

import grafo.Grafo;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> caminos = new ArrayList<>();
		List<Integer> caminoParcial = new ArrayList<>();
		caminoParcial.add(origen);
		generarCaminos(origen, caminoParcial, caminos);
		return caminos;
	}
	
	private void generarCaminos(int verticeActual, List<Integer> caminoParcial, List<List<Integer>> caminos) {
		if (verticeActual == destino) {
			caminos.add(new ArrayList<>(caminoParcial));
			return;
		}
		if (caminoParcial.size() - 1 == lim) { 
			return;
		}
		for (Integer adyacente : obtenerAdyacentes(verticeActual)) {
			if (!caminoParcial.contains(adyacente)) {
				caminoParcial.add(adyacente);
				generarCaminos(adyacente, caminoParcial, caminos);
				caminoParcial.remove(caminoParcial.size() - 1);
			}
		}
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
