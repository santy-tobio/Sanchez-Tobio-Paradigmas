package anillo;

public abstract class Node {

    static Node EmptyNode() {
        return new EmptyNode();
    }
    public abstract Node next();
    public abstract Object current();
    public abstract Node add(Object data);
    public abstract Node remove();

}
