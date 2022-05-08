
package arraylist;

public class ArrayList {
    static class List{
        int arr[];
        int maxSize;
        int size;
        
        List(int length){
            maxSize = length;
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
        public void destroy(){
            size = 0;
        }
        public void insert(int index,int element){
            for(int i=size-1;i>=index;i--){
                arr[i+1] = arr[i];
            }
            arr[index] = element;
            size++;
        }
        public void delete(int index){
            for(int i=index+1;i<=size-1;i++){
                arr[i-1] = arr[i];
            }
            size--;
        }
        public int retrieve(int index){
            return arr[index];
        }
        public void replace(int index , int element){
            arr[index] = element;
        }
        public void traverse(){
            for(int i=0;i<=size-1;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        List list = new List(3);
        System.out.println(list.isEmpty());
        System.out.println(list.isFull());
        list.insert(0,5);
        list.insert(1,4);
        list.insert(2,7);
        System.out.println(list.isEmpty());
        System.out.println(list.isFull());
        System.out.println(list.retrieve(1));
        list.delete(1);
        list.traverse();
        list.destroy();
        list.traverse();
        System.out.println(list.isEmpty());
        System.out.println(list.isFull());
        System.out.println(list.size());
    }
    
}
