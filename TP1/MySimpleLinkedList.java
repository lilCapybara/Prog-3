import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{
//Usando MySimpleLinkedLis<T> con la T indicamos que la info que contenga el nodo sera del tipo que se especifique al instanciar la lista
    protected Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    public T extractFront() {
        Node<T> tmp = new Node<>(this.first.getInfo(), this.first.getNext());
        this.first = tmp.getNext();
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return this.first==null;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        int pos = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            if (pos == index){
                return aux.getInfo();
            }
            pos++;
            aux = aux.getNext();
        }
        return null;
    }

    public int indexOf(T info) {
        Node<T> aux = this.first;
        int pos = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            if (aux.getInfo() == info) {
                return pos;
            }
            pos++;
            aux = aux.getNext();
        }
        return -1;
    }

    public int size() {
        Node<T>  aux = this.first;
        int size = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            aux = aux.getNext();
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        Node<T> aux = this.first;
        String res = "";

        while ((aux != null) && (aux.getNext() != null)) {
            res = res + aux.getInfo().toString() + "->";
            aux = aux.getNext();
        }

        return res;
    }

    @Override
    public Iterator<T> iterator() {
        SimpleIterator<T> it = new SimpleIterator<>(this.first);
        return it;
    }

    public MySimpleLinkedList<T> listaComun(MySimpleLinkedList<T> l){
        SimpleIterator<T> it1=new SimpleIterator<>(this.first); //Podria ser this.iterator()
        SimpleIterator<T> it2=new SimpleIterator<>(l.first);

        MySimpleLinkedList<T> lista=new MySimpleLinkedList<T>();  //En esta lista se colocan los valores comunes de ambas listas

        while(it1.hasNext() && it2.hasNext()){
            if (-1 == it1.getInfo().compareTo(it2.getInfo())){  //it1<it2
                it1.next();
            }
            if (1 == it1.getInfo().compareTo(it2.getInfo())){   //it1>it2
                it2.next();
            }
            if (0==it1.getInfo().compareTo(it2.getInfo())){ //Solo si los elementos son iguales se insertan en la lista
                lista.insertSorted(lista,it1.getInfo());
                it1.next();
                it2.next();
            }
        }
        return lista;
    }

    public void insertSorted(MySimpleLinkedList<T>lista, T infoToInsert){
        Node<T>aux=lista.first;
        Node<T>last=new Node<>();
        Node<T>nodeToInsert=new Node<>();
        boolean inserted=false; //Controla si ya se hizo la insercion

        if(aux!=null) {
            while (!inserted) {
                if (0 <= infoToInsert.compareTo(aux.getInfo())) {  //info es menor o igual al info de aux
                    nodeToInsert.setInfo(infoToInsert);

                    if (aux==first){    //Si aux es el primer elemento, este pasa a ser el segundo y la info a insertar va a el primer nodo
                        nodeToInsert.setNext(aux);
                        this.first=nodeToInsert;
                    }else{
                        last.setNext(nodeToInsert); //Al nodo de la iteracion anterior le pongo como siguiente el nodo que voy a insertar
                        nodeToInsert.setNext(aux);  //Al nodo que voy a insertar le pongo como siguiente el nodo aux
                    }
                    inserted=true;
                } else if (1 == infoToInsert.compareTo(aux.getInfo())) {    //Si info es mayor a la info de aux, se guarda el aux y se sigue iterando
                    last=aux;
                }
                aux=aux.getNext();  //Paso al siguiente nodo
            }
        }else{
            lista.insertFront(infoToInsert);    //Si aux es null, es porque la lista esta vacia, entonces inserto info directamente en la primer posicion
        }
    }

    public MySimpleLinkedList<T>listaNoComun(MySimpleLinkedList<T>l){
        SimpleIterator<T> it1=new SimpleIterator<>(this.first); //Podria ser this.iterator()
        SimpleIterator<T> it2=new SimpleIterator<>(l.first);

        MySimpleLinkedList<T> lista=new MySimpleLinkedList<T>();  //En esta lista se colocan los valores no comunes de ambas listas
        boolean estaEnl;  //Verifica si un elemento de la lista 1 esta en la lista 2

        while(it1.hasNext()){
            estaEnl=false;

            while(it2.hasNext() && !estaEnl){   //Itero el it2 hasta que coincida con it1 o llegue al final de la lista
                if(it1==it2){
                    estaEnl=true;
                }
                it2.next();
            }
            //Tras salir del while, puede pasar que se encontro a it1 en la otra lista (estaEnl=true) o que no se haya encontrado
            if(!estaEnl){
                lista.insertFront(it1.getInfo());   //Si no se encontro it1 en la otra lista, se lo agrega a la lista nueva
            }
            it1.next();
            it2.setCursor(l.first); //Vuelvo a poner a it2 al principio
        }
        return lista;
    }
}