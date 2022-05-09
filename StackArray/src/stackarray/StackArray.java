package stackarray;

public class StackArray {
    
    static class Stack {
    int top;
    int []arr;
    int maxSize;
    
    Stack(int length){
        maxSize = length;
        top = -1;
        arr = new int[maxSize];
    }
    
    boolean isEmpty(){
        return (top==-1);
    }
    boolean isFull(){
        return (top==maxSize-1);
    }
    
    void push(int element){
        if(!isFull())
           arr[++top]=element;
        else{
            System.out.println("Stack is full, can't push any more");
        }
    }
    void pop(){
        if(!isEmpty())
           top--;
        else 
           System.out.println("Stack is empty");
    }
    int peek(){
        if(!isEmpty())return arr[top];
        else return -1;   //throw exception 
    }
    void traverse(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    void clear(){
        top=-1;
    }
    int size(){
        return top+1;
    } 
    
}
    
    public static void main(String[] args) {
        Stack s = new Stack(4);
//        System.out.println(s.isFull());
        s.push(2);
        s.push(5);
        s.push(3);
        s.push(8);
//        s.push(6);
        System.out.println(s.isFull());
        System.out.println(s.size());
        s.traverse();
//        s.clear();
//        System.out.println(s.size());
        s.pop();
        s.traverse();
//        s.push(7);
        s.push(4);
        s.traverse();
        System.out.println(s.isFull());
        s.push(0);
        s.clear();
        s.pop();
        s.push(9);
        System.out.println(s.isFull());
    }
}

//If ClearStack is extensively used then, may be array-based implementation is better. 

//If the memory is very limited, then may be the linked implementation is better.