

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private ArrayList<Arco>listaDeArcos;
	HashMap<Integer,Integer>mapaDeVertices;
	public GrafoDirigido(){
		this.listaDeArcos=new ArrayList<>();
		this.mapaDeVertices=new HashMap<>();
	}
	@Override
	public void agregarVertice(int verticeId) {
		mapaDeVertices.put(verticeId,verticeId);
	}

	@Override
	public void borrarVertice(int verticeId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco newArco=new Arco(verticeId1,verticeId2,etiqueta);
		listaDeArcos.add(newArco);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for(Arco arco:listaDeArcos){
			if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
				listaDeArcos.remove(arco);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		/*for(Arco arco:listaDeArcos){
			if(arco.getVerticeOrigen()==verticeId || arco.getVerticeDestino()==verticeId){
				return true;
			}
		}
		return false;*/		//Usando la lista de arcos

		return mapaDeVertices.containsKey(verticeId);	//Usando el mapa de hash
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for(Arco arco:listaDeArcos){
			if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
				return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for(Arco arco:listaDeArcos){
			if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
				return arco;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadArcos() {
		return listaDeArcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
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
