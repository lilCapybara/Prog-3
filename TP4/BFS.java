import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class BFS<T> {
    private Stack<Integer>pilaDeVertices;
    private HashMap<Integer,String>listaDeVisitados;    //<idVertice,"visitado"/"no visitado">

    public BFS(){
        this.pilaDeVertices=new Stack<>();
        this.listaDeVisitados=new HashMap<>();
    }
    public void bfs(Grafo<T>g){
        pilaDeVertices.clear(); //Vacio la pila de vertices
        Iterator<Integer>itVertices=g.obtenerVertices();

        while(itVertices.hasNext()){    //Pongo todos los vertices como no visitados antes de comenzar
            Integer vertice=itVertices.next();
            listaDeVisitados.put(vertice,"no visitado");
        }
        Iterator<Integer>itVertices2=g.obtenerVertices();   //Creo un nuevo iterador, puesto que itVertices tiene su cursor apuntando al final de este
        while(itVertices2.hasNext()){
            Integer vertice= itVertices2.next();
            if(listaDeVisitados.get(vertice).equals("no visitado")){
                bfsVisit(g,vertice);
            }
        }
    }

    public void bfsVisit(Grafo<T> g, int vertice){
        listaDeVisitados.put(vertice,"visitado");   //Marco el vertice como visitado
        pilaDeVertices.push(vertice);   //Pongo el vertice en la pila

        while(!pilaDeVertices.isEmpty()){
            int v=pilaDeVertices.pop();   //Quito el vertice de la pila para trabajar con sus adyacentes a continuacion
            System.out.println(" "+v);
            Iterator<Integer>adyacentes= g.obtenerAdyacentes(v);
            while(adyacentes.hasNext()){    //Recorro los vertices adycentes al vertice actual
                int adj=adyacentes.next();
                if(listaDeVisitados.get(adj).equals("no visitado")){     //Si no visite el vertice adyacente antes, entro en el if
                    listaDeVisitados.put(adj,"visitado");     //Marco el vertice como visitado
                    pilaDeVertices.push(adj);     //Agrego el vertice a la pila
                }
            }

        }
    }
}
