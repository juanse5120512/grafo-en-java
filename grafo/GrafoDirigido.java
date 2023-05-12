package grafo;
import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {
	private Map<Integer, ArrayList<Arco<T>>> nodos;

	public GrafoDirigido() {
		this.nodos = new HashMap<>();
	}

	public void print() {
		for (Integer k : nodos.keySet()) {
			System.out.println("-> KEY: " + k + " - VALUE: " + nodos.get(k).toString());
		}
	}

	@Override
	public void agregarVertice(int verticeId) {
		nodos.putIfAbsent(verticeId, new ArrayList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		nodos.remove(verticeId);
		for (ArrayList<Arco<T>> adyacentes : nodos.values()) {
			adyacentes.removeIf(arco -> arco.getVerticeDestino() == verticeId);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
			nodos.get(verticeId1).add(arco);
		} else {
			System.out.println("No se pudo agregar el arco");
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			ArrayList<Arco<T>> arcos = nodos.get(verticeId1);
			Iterator<Arco<T>> it = arcos.iterator();
			while (it.hasNext()) {
				Arco<T> arco = it.next();
				if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
					it.remove();
				}
			}
		}
	}
	
	@Override
	public boolean contieneVertice(int verticeId) {
		return nodos.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			ArrayList<Arco<T>> arcos = nodos.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (nodos.containsKey(verticeId1) && nodos.containsKey(verticeId2)) {
			ArrayList<Arco<T>> arcos = nodos.get(verticeId1);
			for (Arco<T> arco : arcos) {
				if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
					Arco<T> arcoAux = new Arco<>(verticeId1, verticeId2, arco.getEtiqueta());
					return arcoAux;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return nodos.size();
	}

	@Override
	public int cantidadArcos() {
		int cantidadArcos = 0;
		Set<Integer> keys = nodos.keySet();
		for (Integer key : keys) {
			ArrayList<Arco<T>> arcos = nodos.get(key);
			for (int i = 0; i < arcos.size(); i++) {
				cantidadArcos += 1;
			}
		}
		return cantidadArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return nodos.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> adyacentes = nodos.get(verticeId);
		if (adyacentes == null) {
			System.out.println("El vertice no existe");
		}
		ArrayList<Integer> destinos = new ArrayList<>();
		for (Arco<T> arco : adyacentes) {
			destinos.add(arco.getVerticeDestino());
		}
		return destinos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Set<Integer> keys = nodos.keySet();
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (Integer key : keys) {
			ArrayList<Arco<T>> listaArcos = nodos.get(key);
			arcos.addAll(listaArcos);
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos = nodos.get(verticeId);
		return arcos.iterator();
	}

}
