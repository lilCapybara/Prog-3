import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	private Hashtable<Integer, LinkedList<Arco<T>>> vertices;	//Recomendable almacenar solo los arcos que salen de un vertice
																//<Key(vertice_id),Lista de arcos asociados al vertice>


	public GrafoDirigido(){
		this.vertices=new Hashtable<>();
	}


	@Override
	public void agregarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){	//Verifico que la id del vertice no exista
			return;
		}else{
			vertices.put(verticeId,new LinkedList<>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)){	//Verifico que la id del vertice exista
			vertices.remove(verticeId);
		}else{
			return;
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(vertices.containsKey(verticeId1)&&vertices.containsKey(verticeId2)){
			LinkedList<Arco<T>>listaDeArcos=vertices.get(verticeId1); //Me da la lista de arcos salientes de ese vertice
			//Podria ser tambien .add(new Arco(verticeId1,verticeId2, etiqueta) y me ahorro la linea que sigue
			listaDeArcos.add(verticeId1,verticeId2,etiqueta);	//Agrego el arco  la lista de arcos
			vertices.put(verticeId1,listaDeArcos);	//Actualizo el vertice
		}
		return;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1)){

		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();	//Me da un iterador para recorrer las claves del hashTable de vertices
	}												//dadas por el keySet()

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Iterator<Arco<T>>arcos=this.vertices.get(verticeId).iterator();	//get(verticeId) obtiene la estructura que almacena los arcos salientes de ese vertice
		if(vertices.containsKey(verticeId)){
			HashSet<Integer> adyacentes=new HashSet<>();
			while(arcos.hasNext()){
				adyacentes.add(arcos.next().getVerticeDestino()); //El primer .next() sobre un iterador sobre el que no se empezo a iterar comenzara sobre el primer item
			}
			return adyacentes.iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
