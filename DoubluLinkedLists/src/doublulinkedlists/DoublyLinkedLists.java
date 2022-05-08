
package doublulinkedlists;

public class DoublyLinkedLists <E> {
//why doubly linked lists?
    // Singly linked list is not efficient when deleting last element in it. O(n)
    //More generally, we cannot efﬁciently delete an arbitrary node from an interior position  of the list if only given a reference to that node
    // , because we cannot determine the node that immediately precedes the node to be deleted.
    
    static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public  E getElement() { return element; } 
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; } 
        public void setNext(Node<E> n) { next = n; }
    }
    
    Node <E> header; // header sentinel 
    Node <E> trailer; // trailer sentinel 
    int size = 0;

    public DoublyLinkedLists() {
        header = new Node<>(null, null , null);  //create header 
        trailer = new Node<>(null, header , null); // trailer is preceded by header 
        header.setNext(trailer); // header is followed by trailer
    }
    public int size() { return size; } 
    public boolean isEmpty() { return size == 0; }
    
    public E ﬁrst() {
        if (isEmpty()) return null;
        return header.getNext().getElement(); // ﬁrst element is beyond header 
    } 
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement(); // ﬁrst element is beyond header 
    }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node 
        Node<E> newNode = new Node<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode); 
        size++; 
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev(); 
        Node<E> successor = node.getNext(); 
        predecessor.setNext(successor); 
        successor.setPrev(predecessor); 
        size--; 
        return node.getElement(); 
    } 
    public void addFirst(E e) { 
        addBetween(e, header, header.getNext());
    } 
    public void addLast(E e) { 
        addBetween(e, trailer.getPrev(), trailer);
    } 
    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    } 
    void traverse(){
            Node temp = header;
            while(temp!=null){
                if(temp.element!=null) System.out.print(temp.element + " ");
                temp = temp.next;
            }
            System.out.println("");
    }
    public static void main(String[] args) {
        DoublyLinkedLists<Integer> dll = new DoublyLinkedLists();
        System.out.println(dll.isEmpty());
        dll.addFirst(5);
        dll.addFirst(10);
        dll.traverse();
        dll.addLast(2);
        dll.traverse();
        dll.removeFirst();
        dll.traverse();
        System.out.println(dll.size());
    }
    
}
