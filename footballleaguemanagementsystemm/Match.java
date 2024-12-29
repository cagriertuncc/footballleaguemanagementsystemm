package footballleaguemanagementsystemm;
import java.util.Random;
public class Match {
    public int matchid;
    public Team team1;  // Birinci takım
    public Team team2;  // İkinci takım
    public int team1Goals;  // Birinci takımın attığı goller
    public int team2Goals;  // İkinci takımın attığı goller
    public Match next;
            
    public Match(Team team1, Team team2,int matchid) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchid=matchid;
        this.next=null;
    }

    public void simulateMatch() {
        Random rand = new Random();
        team1Goals = rand.nextInt(5);  // 0 ile 4 arasında gol sayısı
        team2Goals = rand.nextInt(5);

        team1.updateStatistics(team1Goals, team2Goals);  // Takım 1'in istatistiklerini güncelle
        team2.updateStatistics(team2Goals, team1Goals);  // Takım 2'nin istatistiklerini güncelle
    }
    public void printMatchResult() {
        System.out.println("Match Result:");
        System.out.println(team1.teamName + " " + team1Goals + " - " + team2Goals + " " + team2.teamName);
    }
    public int getTeam1Goals() {
        return team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }
}

    

