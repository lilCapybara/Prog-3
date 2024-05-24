

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);


		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(2, 6, 3F);
		grafito.agregarArco(1, 3, 3F);
		grafito.agregarArco(3, 4, 3F);
		grafito.agregarArco(3, 5, 3F);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		//System.out.println(etiqueta); // Deber�a imprimir 3
	/*	BFS bfs=new BFS();
		bfs.bfs(grafito);	*/

		DFS dfs=new DFS();
		dfs.dfs(grafito);


	}

}
