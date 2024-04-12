public class DoubleNode<T> {
    private T info;
    private DoubleNode<T> next;
    private DoubleNode<T> last;

    public DoubleNode() {
        this.info = null;
        this.next = null;
        this.last=null;
    }

    public DoubleNode(DoubleNode<T>last, T info, DoubleNode<T> next) {
        this.last=null;
        this.info=null;
        this.next=null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DoubleNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleNode<T> last) {
        this.last = last;
    }
}
