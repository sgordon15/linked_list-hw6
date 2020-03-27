package edu.ti.collections.list.linked;

public class LinkedList<T> {

    private class Node {
        T payload;
        Node next = null;

        public Node(T payload) {
            this.payload = payload;
        }

        public T getPayload() {
            return payload;
        }

        public void setPayload(T payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node headNode = null;
     Node endNode = null;

    public LinkedList() {
        // nothing
    }

    public LinkedList(T payload) {
        headNode = new Node(payload);
        endNode = headNode;
    }

    public boolean isEmpty() {
        return (headNode == null);
    }

     Node end() {
        Node endNode = headNode;
        while (endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    }

    public int size() {
        int size = 0;
        for (Node start = headNode; start != null; start = start.next) {
            size += 1;
        }
        return size;
    }

    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(headNode);
        if (headNode == null) {
            endNode = newNode;

        }
        headNode = newNode;
    }

    public void append(T object) {
        Node newNode = new Node(object);
        if (headNode == null) {
            headNode = newNode;
            endNode = newNode;
        } else {
            endNode.setNext(newNode);
            endNode = newNode;

        }
    }

    public T get(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node requestedNode = headNode;
            while (n-- > 0) {
                requestedNode = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }

    public T remove(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node beforeRequestedNode = null;
            Node requestedNode = headNode;
            while (n-- > 0) {
                beforeRequestedNode = requestedNode;
                requestedNode = requestedNode.getNext();
            }
            if (requestedNode.getNext() == null) {
                beforeRequestedNode.setNext(null);
                endNode = end();

            }
            else if (beforeRequestedNode != null){
                beforeRequestedNode.setNext(requestedNode.getNext());
            }
            else {
                headNode  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }

    public T remove(T object) {
        T requestedObject = null;
        if (headNode != null) {
            Node beforeRequestedNode = null;
            Node requestedNode = headNode;
            boolean foundNode = false;
            do {
                if (requestedNode.getPayload().equals(object)) {
                    foundNode = true;
                } else {
                    beforeRequestedNode = requestedNode;
                    requestedNode = requestedNode.getNext();
                }
            } while (!foundNode && requestedNode.getNext() != null);
            if (requestedNode.getNext() == null) {
                beforeRequestedNode.setNext(null);
                endNode = end();
            }

            else if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                headNode  = requestedNode.getNext();
            }

            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }
}
