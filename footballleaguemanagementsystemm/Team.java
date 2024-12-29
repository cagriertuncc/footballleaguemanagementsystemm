package footballleaguemanagementsystemm;

public class Team {
    public int teamID;
    public String teamName;
    public PlayerList players;
    public int totalPoints;
    public int goalDifference;
    public Team next;
    public Team left;   //  left = null;
    public Team right;  // right=null;
   
    
    public Team(int teamID,String teamName){
        this.teamID = teamID;
        this.teamName = teamName;
        this.players = new PlayerList();
        this.totalPoints = 0;
        this.goalDifference = 0;
        this.next = null;
        this.left=null;
        this.right=null;
    }
    public void addPlayer(Player newPlayer) {
        players.addPlayer(newPlayer);
    }
     public void deletePlayer(int playerID) {
        players.deletePlayer(playerID);
    }
    /*public void updateTeam(int totalPoints, int goalDifference) {
        this.totalPoints = totalPoints;
        this.goalDifference = goalDifference;
    }
    */
     public void updateStatistics(int goalsScored, int goalsConceded) {
        // Update goal difference
        this.goalDifference += (goalsScored - goalsConceded);
        
        // Update total points
        if (goalsScored > goalsConceded) {
            this.totalPoints += 3;  // 3 points for a win
        } else if (goalsScored == goalsConceded) {
            this.totalPoints += 1;  // 1 point for a draw
        }
        // No points for loss, so no else condition needed
    }
     @Override
    public String toString() {
        return "Team{"            +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                ", totalPoints=" + totalPoints +
                ", goalDifference=" + goalDifference +
                '}';
    }
}
