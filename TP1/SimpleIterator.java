import java.util.Iterator;

public class SimpleIterator<T extends Comparable<T>> implements Iterator<T> {
    private Node<T> cursor;


    public SimpleIterator(Node<T> head) {
        this.cursor = head;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
            T info = cursor.getInfo();
            this.cursor = cursor.getNext();
            return info;
    }
    public T getInfo(){
        return cursor.getInfo();
    }

    public Node<T> getCursor(){
        return cursor;
    }

    public void setCursor(Node<T>newCursor){
        this.cursor=newCursor;
    }
}
