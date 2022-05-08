
package queuenode;

public class LinkedQueue {
    static class Node{
        int value;
        Node next;
        
        Node(int value){
            this.value = value;
            next = null;
        }
    }
    static class Queue{
        Node front;
        Node rear;
        int size;
        
        Queue(){
            front = null;
            rear = null;
            size = 0;
        }
        
        public boolean isEmpty(){
            return (size==0);
            // or return (front == null);
            // or return (rear == null); 
        }
        public boolean isFull(){
            return false;
        }
        public int size(){
            return size;
        }
        // front and rear always be null together or not null together
        public void append(int element){ //push
           Node newNode = new Node(element);
           if(isEmpty())
               front = newNode;
           else
               rear.next = newNode;
           
           rear = newNode;
           size++;
        }
        public void serve(){ //pop
            Node temp = front;
            front = temp.next;
            // free(temp);
            if(front == null) //special case (if only one node exist before pop so after pop: front will be front.next -->null
                rear = null;
            size--;
        }
        public int retrieve(){ //peek
            if(!isEmpty()) return front.value;
            else return -1; //throw exception
        }
        public void traverse(){
            Node temp = front;
            //مينفعش امشي بالتوب علطول عشان هغير ف الستاك كدا 
            while(temp!=null){
                System.out.print(temp.value+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        public void clear(){
            // two pointers as same as linked stack
            while(front!=null){
                rear = front.next;
                //free(front)
                front = rear;
            }
            size = 0;
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.append(4);
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        System.out.println(q.retrieve());
//        System.out.println(q.isEmpty());
//        System.out.println(q.isFull());
//        q.serve();
//        System.out.println(q.isEmpty());
//        System.out.println(q.isFull());
        System.out.println(q.size());
        q.append(5);
        q.append(10);
        q.traverse();
        System.out.println(q.isFull());
        q.append(2);
        q.serve();
        q.traverse();
        System.out.println(q.size());
        q.clear();
        q.traverse();
        System.out.println(q.size());
    }
}
