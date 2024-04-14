package anillo;

public class Ring {
    public Ring(){
        current = new EmptyNode();
    }
    public Ring next() {
        current = current.next();
        return this;
    }
    public Object current() {
        return current.current();
    }
    public Ring add(Object data) {
        current = current.add(data);
        return this;
    }
    public Ring remove() {
          current = current.remove();
          return this;
    }
    private Node current;
}
