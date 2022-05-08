
package linkedlist;

public class LinkedList {
    // Review enhanced linked list (current and current position)Slide 6 DR waleed yousef
    static class Node{
        int value;
        Node next;
        
        Node(int value){
        this.value = value;
        next=null;
        }
    }
    static class Linked_List{
        Node head;
        int size; //to calculate size from it
        
        Linked_List(){
            head=null;
            size=0;
        }
        
        boolean isEmpty(){
            return (size==0);
        }
        boolean isFull(){
            return false;
        }
        int size(){
            return size;
        }
        void destroyList(){
            Node temp = head;
            while(head!=null){
                temp = temp.next;
                //free(top);
                head = temp;
            }
            size = 0;
        }
        void traverse(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println("");
        }
        void insert(int pos ,int element){
            Node newNode = new Node(element);
            if(pos == 0){
                newNode.next = head;
                head = newNode;
            }
            else{
                Node x = head;
                for(int i=0;i<pos-1;i++)
                    x = x.next;
                newNode.next = x.next;
                x.next = newNode;
            }
            size++;
        }
        void deleteAt(int pos){
            if(pos == 0){
                Node temp = head.next;
                //free(head);
                head = temp;
            }
            else{
                Node x = head;
                for(int i=0;i<pos-1;i++)
                    x = x.next;
                Node temp = x.next.next;
                //free(x.next);
                x.next = temp;
            }
            size--;
        }
        int retrieve(int pos){
            Node x = head;
            for(int i=0;i<pos-1;i++)
                x = x.next;
            return(x.next.value);
        }
        void replace(int pos , int element){
            Node x = head;
            for(int i=0;i<pos-1;i++)
                x = x.next;
            x.next.value = element;
        }
        
    }
    public static void main(String[] args) {
        Linked_List l = new Linked_List();
        System.out.println(l.isEmpty());
        System.out.println(l.isFull());
        l.insert(0, 5);
        l.insert(1, 2);
        l.insert(2, 8);
        l.traverse();
        l.deleteAt(2);
        l.traverse();
        System.out.println(l.retrieve(1));
        l.destroyList();
        l.traverse();
        System.out.println(l.size());
    }
}
