import java.util.Hashtable;
import java.util.Iterator;

public class DFS<T> {
    private Hashtable<Integer,String> colorVertices;   //<key,value> --> <idVertice,color>

    public DFS(){
        this.colorVertices =new Hashtable<>();
    }

    public void dfs (Grafo<T> grafo){
        Iterator<Integer>iteradorVertices=grafo.obtenerVertices();  //Obtiene un iterador de los vertices del grafo

        while(iteradorVertices.hasNext()){  //Pongo todos los vertices en blanco antes de comenzar el recorrido
            Integer vertice=iteradorVertices.next();
            colorVertices.put(vertice,"blanco");
        }

        Iterator<Integer>it2=grafo.obtenerVertices();   //Creo un nuevo iterador, puesto que it1 tiene el cursor sobre el final de este
        while(it2.hasNext()){
            Integer vertice=it2.next();
            if(colorVertices.get(vertice).equals("blanco")){   //Si el vertice esta sin visitar (blanco) lo visito
                dfsVisit(grafo,vertice);
            }
        }
    }

    private void dfsVisit(Grafo<T>grafo, Integer vertice){
        System.out.println(" "+vertice);
        colorVertices.put(vertice,"amarillo");    //Marco el vertice como visitado (amarillo)

        Iterator<Integer>adyacentesAVertice=grafo.obtenerAdyacentes(vertice);   //Traigo los adyacentes del vertice
        while(adyacentesAVertice.hasNext()){
            Integer v= adyacentesAVertice.next();

            if(colorVertices.get(v).equals("blanco")){
                dfsVisit(grafo,v);
            }else if(colorVertices.get(v).equals("amarillo")){   //Si visito un vertice que ya fue visitado antes (esta en amarillo) significa que hay un ciclo
                System.out.println("Hay ciclo");
                return;
            }
            colorVertices.put(vertice,"negro");   //Si llegue aca, significa que ya termine de trabajar con el vertice (lo pongo en negro)
        }
    }
}
