package footballleaguemanagementsystemm;

public class Player {
    public int playerID;
    public String playerName;
    public String position;
    public int goalsScored;
    public Player next;
    
    public Player(int playerID, String playerName, String position) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.position = position;
        this.goalsScored=0;
        this.next = null;
    }
    public void updateProfile(String position,int goalsScored){
        this.position = position;
        this.goalsScored = goalsScored;
    }
    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", position='" + position + '\'' +
                ", goalsScored=" + goalsScored +
                '}';
}
    
}
