import java.util.Hashtable;
import java.util.Iterator;

public class DFS {
    private Hashtable<Integer,String> colorVertices;   //<key,value>

    public DFS(){
        this.colorVertices =new Hashtable<>();
    }

    public void dfs (Grafo<T> grafo){
        Iterator<Integer>iteradorVertices=grafo.obtenerVertices();  //Obtiene un iterador de los vertices del grafo
        while(iteradorVertices.hasNext()){
            Integer vertice=iteradorVertices.next();
            colorVertices.put(vertice,"blanco");
        }
        Iterator<Integer>it2=grafo.obtenerVertices();
        while(it2.hasNext()){
            Integer vertice=it2.next();
            if(colorVertices.get(vertice)=="blanco"){
                dfsVisit(grafo,vertice);
            }
        }
    }

    private void dfsVisit(Grafo<T>grafo, Integer vertice){
        System.out.println(" "+vertice);
        colorVertices.put(vertice,"amarillo");    //Marco el vertice como visitado

        Iterator<Integer>adyacentesAVertice=grafo.obtenerAdyacentes(vertice);   //Traigo los adyacentes del vertice
        while(adyacentesAVertice.hasNext()){
            Integer v= adyacentesAVertice.next();

            if(colorVertices.get(v)=="blanco"){
                dfsVisit(grafo,v);
            }else if(colorVertices.get(vertice)=="amarillo"){
                System.out.println("Hay ciclo");
                return;
            }
            colorVertices.put(v,"negro");
        }
    }
}
