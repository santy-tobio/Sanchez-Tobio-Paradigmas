package anillo;

public class EmptyNode extends Node {

    public EmptyNode() {
        super();
    }

    public Object nextNode() {
        throw new RuntimeException("el anillo esta vacio");
    }

    @Override
    public Object currentNode() {
        return null;
    }

    @Override
    public Object dataInNode() {
        return null;
    }

}
