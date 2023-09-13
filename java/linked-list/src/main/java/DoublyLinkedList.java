class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;

    void push(T value) {
        Element<T> newNode = new Element<T>(value, null, null);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }

    T pop() {
        Element<T> nodeToRemove = this.tail;
        if (nodeToRemove == null)
            return null;

        if (nodeToRemove == this.head) {
            Element<T> node = nodeToRemove;
            setHeadAndTailToNull();
            return node.value;
        }

        Element<T> prevNode = nodeToRemove.prev;
        if (this.tail != null) {
            this.tail = prevNode;
            this.tail.next = null;
            this.tail.prev = prevNode.prev;
        }

        return nodeToRemove.value;
    }

    void unshift(T value) {
        Element<T> newNode = new Element<T>(value, null, null);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    T shift() {
        if (isEmpty())
            return null;

        Element<T> nextNode = this.head.next;
        Element<T> currentHead = this.head;

        if (nextNode != null) {
            this.head = nextNode;
            this.head.prev = null;
        } 
        else
            setHeadAndTailToNull();

        return currentHead.value;
    }

    boolean isEmpty() {
        return this.head == null;
    }
    
    void setHeadAndTailToNull() {
        this.head = null;
        this.tail = null;
    }

    void traverse() {
        Element<T> currentNode = this.head;
        while (currentNode != null) {
            System.out.println("Element data: " + currentNode.value);
            currentNode = currentNode.next;
        }
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
