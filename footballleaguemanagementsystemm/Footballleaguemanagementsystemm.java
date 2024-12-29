
package footballleaguemanagementsystemm;


public class Footballleaguemanagementsystemm {


    public static void main(String[] args) {
        //TeamList teamList=new TeamList();
        //TeamHashTable hashTable = new TeamHashTable(35);
        BinarySearchTreeTeam bst = new BinarySearchTreeTeam();

        bst.insert(1, "Galatasaray");
        bst.insert(2, "Fenerbahce");
        bst.insert(3, "Besiktas");
        
        
        Team foundTeam = bst.searchTeamByName("Galatasaray");
        if (foundTeam != null) {
        System.out.println("Team found: " + foundTeam.teamName + " (ID: " + foundTeam.teamID + ")");
        } else {
        System.out.println("Team not found.");
        }
        
        
        Team team1=new Team(1,"Team A");
        Team team2=new Team(2,"Team B");
        Team team3=new Team(3,"Team C");
        
        /*
        hashTable.putTeam(team1);
        hashTable.putTeam(team2);
        hashTable.putTeam(team3);
        
        hashTable.displayTeams();
         
        teamList.addTeam(new Team(1,"Galatasaray"));
        teamList.addTeam(new Team(2,"Fenerbahce"));
        
        teamList.findTeam(1).addPlayer(new Player(1, "Fernando Muslera", "Kaleci"));
        teamList.findTeam(1).addPlayer(new Player(2, "Mesut Ozil", "Orta Saha"));
        teamList.findTeam(1).addPlayer(new Player(3, "fevzi", "defans"));
        
        
        teamList.printTeams();
        */
    }
    
}
