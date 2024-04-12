import java.util.Iterator;

public class MyDoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private DoubleNode<T>first;

    private int size;

    public MyDoubleLinkedList(DoubleNode<T>first, int size) {
        this.first=first;
        this.size=0;
    }

    public DoubleNode<T> getFirst() {
        return first;
    }

    public T extractFront() {
        if(this.getFirst()!=null){  //Verifico que haya un primer elemento
            if(first.getNext()!=null){  //Verifico que el primer elemento tenga un siguiente
                DoubleNode<T>aux=this.getFirst();
                first=first.getNext();
                return aux.getInfo();
            }else{  //Si solo existe un unico elemento
                DoubleNode<T>aux=this.getFirst();
                first=null;
                return aux.getInfo();
            }
        }else{  //Si no hay elementos en la lista
            return null;
        }

    }

    public boolean isEmpty() {
        return this.first==null;    //Si no hay primer elemento, significa que la lista esta vacia
    }

    public T get(int index) {
        DoubleNode<T>aux=this.getFirst();
        int contador=0;

        while(contador!=index){
            if(aux.getNext()!=null){
                aux=aux.getNext();
                contador++;
            }else{
                return null;
            }
        }
        return aux.getInfo();
    }

    public int size() {
        return size;
    }

    public String toString() {
        DoubleNode<T> aux = this.first;
        String res = "";

        while ((aux != null) && (aux.getNext() != null)) {
            res = res + aux.getInfo().toString() + "->";
            aux = aux.getNext();
        }

        return res;
    }

    @Override
    public Iterator<T> iterator() {
        DoubleIterator<T> it = new DoubleIterator<>(this.first);
        return it;
    }

}

