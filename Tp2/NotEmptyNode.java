package anillo;

public class NotEmptyNode extends Node {
    public NotEmptyNode (Object data) {
        this.data = data;
        next = this;
    }
    public Node next() {return this.next;}
    public Object current() {return this.data;}
    public Node add(Object newData) {
        NotEmptyNode newNode = new NotEmptyNode(data);
        Object value = this.current();
        this.data = newData;
        newNode.next = this.next;
        this.next = newNode;
        newNode.data = value;
        return this;
        }
    public Node remove() {
       return (this.next == this) ? Node.EmptyNode() : this.next;}
    private Object data;
    private Node next;
}

