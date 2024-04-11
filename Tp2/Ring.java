package anillo;

public class Ring {

    public Ring(){
        current = null;
    }

    public Ring next() {
        emptyRing("el anillo esta vacio");
        current = current.next;
        return this;
    }

    private void emptyRing(String vacio) {
        new EmptyNode();
    }

    public Object current() {
        emptyRing("el anillo esta vacio");
        return current.data;
    }

    public Ring add(Object data) {
        Node newNode = new Node(data);
        if (current == null) {
            newNode.next = newNode;
            current = newNode;
        } else {
            Node previous = current;
            while (previous.next != current) {
                previous = previous.next;
            }
            newNode.next = current;
            previous.next = newNode;
            current = newNode;
        }
        return this;
    }

    public Ring remove() {
        emptyRing("");
        if (current.next == current)
        {
            current = null;
        }
        else
        {
            Node temp = current;
            while (temp.next != current)
            {
                temp = temp.next;
            }
            temp.next = current.next;
            current = temp.next;
        }
        return this;
    }



    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;}
    }
    private Node current;

}
