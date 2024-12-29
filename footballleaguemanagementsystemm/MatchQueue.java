package footballleaguemanagementsystemm;

public class MatchQueue {
    
    public Match front;
    public Match rear;
    public int size;

    public MatchQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Team team1, Team team2,int matchid) {
        Match n = new Match(team1,team2,matchid);
        
        if(rear == null){
            front = n;
            rear = n;
        }else{
            rear.next = n;
            rear = n;
        }
        size++;    
    }

    public Match dequeue() {
       if(front == null){
            System.out.println("Queue is empty");
            return null;
        }
        else{
            Match rFront = front;
            front = front.next;
            size--;
            return rFront;
        }
    }
    public void printQueue(){
        
        if (!isEmpty()) {
            Match current = front;
            while (current != null) {
                System.out.print(current.matchid + (current.next != null ? " -> " : ""));
                current = current.next;
            }
            System.out.println();
       }
    }
     public boolean isEmpty(){
       return size == 0;
    }
}
