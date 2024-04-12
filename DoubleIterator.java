import java.util.Iterator;

public class DoubleIterator<T extends Comparable<T>> implements Iterator<T> {
    private DoubleNode<T>cursor;

    public DoubleIterator(DoubleNode<T> cursor) {
        this.cursor = cursor;
    }

    public DoubleNode<T> getCursor() {
        return cursor;
    }

    public void setCursor(DoubleNode<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {   //Devuelve la informacion del nodo actual y mueve el cursor hacia el siguiente nodo
        T info = cursor.getInfo();
        this.cursor = cursor.getNext();
        return info;
    }


}
