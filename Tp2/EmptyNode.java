package anillo;

public class EmptyNode extends Node {

    public Node next() {throw new  RuntimeException("el anillo esta vacio");}
    public Object current() { throw new  RuntimeException("el anillo esta vacio");}
    public Node add(Object data) {
        return new NotEmptyNode(data);
    }
    public Node remove() { throw new RuntimeException("el anillo esta vacio");}
}
