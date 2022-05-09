
package linkedstack;

public class LinkedStack {
    static class Node{
        int value;
        Node next;
        
        Node(int value){
        this.value = value;
        next=null;
        }
    }
    static class Stack{
        Node top;
        int size; //to calculate size from it
        
        Stack(){
            top=null;
            size=0;
        }
        
        boolean isEmpty(){
        return (top==null);
        }
        boolean isFull(){
            return false;
        }
        void push(int element){
            Node newNode = new Node(element);
            newNode.next=top;
            top=newNode;
            size++;
        }
        void pop(){
            if(!isEmpty()){
            size--;
            Node temp=top;
            top=top.next;
            // free(temp);  //not equal null but it's free to assign new value
            }
            else System.out.println("Stack is empty");  //throw exeption
        }
        int peek(){
            if(!isEmpty())return top.value;
            else return -1;   //throw exception 
        }
        void clear(){
            size=0;
            Node temp = top;
            // or we can use two temps
            while(temp!=null){
                temp = temp.next;
                //fre(top);
                top = temp;
            }
            top=null; //ملهاش لازمة لو هستخدم تيمب واحد بس لانها كدا كدا هتبقا نل جوة اللوب
        }
        
        int size(){
            return size;
        }
        void traverse(){
            Node temp=top;
            //مينفعش امشي بالتوب علطول عشان هغير ف الستاك كدا 
            while(temp!=null){
                System.out.print(temp.value+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        
    }
    

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(5);
        s.push(3);
//        s.push(8);  
//        s.push(6);
//        System.out.println(s.isFull());
//        System.out.println(s.size());
        s.traverse();
        s.clear();
        s.traverse();
//        s.push(7);
//        s.push(4);
        System.out.println(s.peek());
        System.out.println(s.size());
        s.pop();
//        System.out.println(s.size());
    }
    
}
//If ClearStack is extensively used then, may be array-based implementation is better. 

//If the memory is very limited, then may be the linked implementation is better.

