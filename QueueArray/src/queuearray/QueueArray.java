
package queuearray;

public class QueueArray {
    static class Queue{
        int front;
        int rear;
        int size;
        int arr[];
        int maxSize;
        
        Queue(int length){
            maxSize = length;
            front = 0;
            rear = -1;
            size = 0;
            arr = new int[maxSize];
        }
        public boolean isEmpty(){
            return (size==0);
        }
        public boolean isFull(){
            return (size==maxSize);
        }
        public int size(){
            return size;
        }
        public void append(int element){ //push
            if(!isFull()){
                rear = (rear+1) % maxSize; // if(rear == maxSize-1) rear=0; else rear++;
                arr[rear] = element;
                size++;
            }
            else System.out.println("Queue is full");
        }
        public void serve(){ //pop
            if(!isEmpty()){
                //pop arr[front];
                front = (front+1) % maxSize; // if(front == maxSize-1) front=0; else front++;
                size--;
            }
            else System.out.println("Queue is empty");
        }
        public int retrieve(){ //peek
            if(!isEmpty()) return arr[front];
            else return -1; //throw exception
        }
        public void traverse(){  //important
            for(int pos=front,s=0 ; s<size ; s++){
                System.out.print(arr[pos]+" ");
                pos = (pos+1) % maxSize;
            }
            System.out.println("");
        }
        public void clear(){
            front = 0;
            rear = -1;
            size = 0;
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(3);
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
