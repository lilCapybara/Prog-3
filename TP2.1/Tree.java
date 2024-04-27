import java.util.ArrayList;
import java.util.List;

public class Tree {

	private TreeNode root;

	public Tree() {
		this.root = null;
	}

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}

	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}

	public boolean isEmpty(){
		return this.root==null;
	}    //Revisa si el arbol tiene raiz o no

	public int getRoot(){
		return this.root.getValue();
	}

	public void delete(int value){    //Este es el delete que utiliza el usuario en el main
		delete(value, root);    //Inicio el delete desde la raiz del arbol
	}

	public void delete (int value, TreeNode newNode){

	}

	public void insert(int value){ //Este es el insert que utiliza el usuario en el main
		insert(value, root);    //Inicio el insert desde la raiz del arbol
	}

	public void insert(int value, TreeNode newNode){

		if (newNode.isEmpty()){        //Si el nodo esta vacio, se puede insertar el valor
			newNode.setValue(value);

		} else if (value< newNode.getValue()){    //Si el valor es menor al del nodo, me muevo hacia la izquierda

			if(newNode.getLeft()==null){    //Si el nodo actual no tiene nodo left, lo creo con value en el
				TreeNode nodo=new TreeNode(value);
			}
			insert(value, newNode.getLeft());

		}else if (value> newNode.getValue()){    //Si el valor es mayo al del nodo, me muevo hacia la derecha

			if(newNode.getRight()==null){    //Si el nodo actual no tiene nodo right, lo creo con value en el
				TreeNode nodo=new TreeNode(value);
			}
			insert(value, newNode.getRight());

		}else{    //Si el valor es igual, no inserto nada y salgo del metodo
			return;
		}
	}

	public void printPreOrder(){    //Metodo que llama el usuario desde el main
		if (this.root!=null){
			printPreOrder(root);
		}else{
			System.out.println("El arbol esta vacio");
		}
	}

	public void printPreOrder(TreeNode currentNode){    //Metodo que imprime el preorden
		if (currentNode!=null){
			System.out.println(currentNode.getValue());    //Imprimo el valor del nodo antes de recorrer los subarboles de este
			printPreOrder(currentNode.getLeft());    //Continuo por el nodo izquierdo
			printPreOrder(currentNode.getRight());    //Continuo por el nodo derecho
		}
	}

	public void printPostOrder(){    //Metodo que llama el usuario desde el main
		if (this.root!=null){
			printPostOrder(root);
		}else{
			System.out.println("El arbol esta vacio");
		}
	}

	public void printPostOrder(TreeNode currentNode){    //Metodo que imprime el postorden
		if (currentNode!=null){

			printPostOrder(currentNode.getLeft());    //Continuo por el nodo izquierdo
			printPostOrder(currentNode.getRight());    //Continuo por el nodo derecho
			System.out.println(currentNode.getValue());    //Imprimo el valor del nodo despues de recorrer los subarboles de este
		}
	}

	public void printInOrder(){    //Metodo que llama el usuario desde el main
		if (this.root!=null){
			printInOrder(root);
		}else{
			System.out.println("El arbol esta vacio");
		}
	}

	public void printInOrder(TreeNode currentNode){    //Metodo que imprime el postorden
		if (currentNode!=null){

			printInOrder(currentNode.getLeft());    //Continuo por el nodo izquierdo
			System.out.println(currentNode.getValue());    //Imprimo el valor del nodo despues de recorrer los subarboles izquierdos y antes de recorrer los subarboles derechos
			printInOrder(currentNode.getRight());    //Continuo por el nodo derecho

		}
	}

	public int sumarNodosInternos(){    //Metodo utilizado por el usuario en el main
		return sumarNodosInternos(root);
	}

	public int sumarNodosInternos(TreeNode currentNode){    //Metodo que realiza la suma de nodos internos
		if(currentNode==null){
			return 0;
		}else if(currentNode.getLeft()==null && currentNode.getRight()==null){    //Si el nodo es una hoja, devuelve 0
			return 0;
		}else{
			return currentNode.getValue()+sumarNodosInternos(currentNode.getLeft())+sumarNodosInternos(currentNode.getRight());    //Al valor del nodo actual le sumo el valor de sus subramas
		}
	}

	public List<Integer> valorMayorAK(int k){    //Metodo usado por el usuario en el main
		List<Integer> mayoresAK=new ArrayList<>();
		return valorMayorAK(root,k,mayoresAK);
	}

	public List valorMayorAK(TreeNode currentNode, int k, List mayoresAK){    //Metodo que arma la lista con valores mayores a k

		if(currentNode==null){    //Condicion de corte para la recursion
			return mayoresAK;
		}

		if(k<currentNode.getValue()){
			mayoresAK.add(currentNode.getValue());    //Agrego el valor del nodo a la lista
		}


		valorMayorAK(currentNode.getLeft(),k,mayoresAK);    //Sigo por la rama izquierda
		valorMayorAK(currentNode.getRight(),k,mayoresAK);    //Sigo por la rama derecha

		return mayoresAK;
	}

	public void fillTree(){
		fillTree(root);
	}

	public int fillTree(TreeNode currentNode){

		if(currentNode.isEmpty()){	//Si el nodo esta vacio, significa que es un nodo interno y debo llenarlo

			if(!currentNode.getLeft().isEmpty() && !currentNode.getRight().isEmpty()){	//Si los dos hijos del nodo son hojas
				currentNode.setValue(fillTree(currentNode.getLeft())+fillTree(currentNode.getRight()));
			}

			if(currentNode.getLeft().isEmpty()){    //Si el hijo izquierdo es un nodo interno
				currentNode.setValue(fillTree(currentNode.getLeft()));
			}

			if(currentNode.getRight().isEmpty()){        //Si el hijo derecho es un nodo interno
				currentNode.setValue(fillTree(currentNode.getRight()));
			}

			if(currentNode.getLeft()==null){    //Tiene un solo hijo y es el de la derecha
				currentNode.setValue(fillTree(currentNode.getRight()));
			}

			if(currentNode.getRight()==null){        //Tiene un solo hijo y es el de la izquierda
				currentNode.setValue(fillTree(currentNode.getLeft()));
			}
		}

		return currentNode.getValue();	//Si el nodo no esta vacio, significa que no es una hoja, por lo que devuelvo su valor
	}

}
