package footballleaguemanagementsystemm;

public class MatchStack <T>{

    
    Object [] s_array;
    int top;
    
    
    public MatchStack(int size){
        s_array = new Object[size];
        top = -1;
    }
    public void push(T data){
        
        if(this.isFull())
            System.out.println("Stack is Full");
        else{
            top++;
            s_array[top] = data;
        }
        
    }
    public T pop(){
        if(this.isEmpty()){
          System.out.println("Stack is Empty");
          return null;
        }
        else{
            return (T)s_array[top--];
        }
    }
    public boolean isFull(){
        return top == s_array.length - 1 ;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void printStack(){
        
        for(int i = top; i > -1; i--){
            if(i == top)
                System.out.println(s_array[i] + " ----> Top");
            else
                System.out.println(s_array[i] + " ");
        }
    }   
}
    

