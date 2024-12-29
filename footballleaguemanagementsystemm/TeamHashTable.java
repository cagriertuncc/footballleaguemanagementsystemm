package footballleaguemanagementsystemm;

public class TeamHashTable {
    Team[] table;
    int size;
    int prime;

public TeamHashTable(int capacity){
    table=new Team[capacity];
    prime=17;
    size=0;
}
public int hash(int key){
    return key % prime;
}

public void putTeam(Team newTeam){
    int index=hash(newTeam.teamID);
    int originalIndex=index;
while (table[index] != null) {
            if (table[index].teamID == newTeam.teamID) {
                System.out.println("Team already exists: " + newTeam.teamName);
                return;
            }  
        index = (index + 1) % table.length;
            if (index == originalIndex) {
                System.out.println("Hash table is full");
                return;
        }
    }
    table[index] = newTeam;
        size++;
}
public void removeTeam(int teamID) {
        int index = hash(teamID);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].teamID == teamID) {
                System.out.println("Removing team: " + table[index].teamName);
                table[index] = null;
                size--;
                rehash();
                return;
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                break;
            }
        }

        System.out.println("Team with ID " + teamID + " not found");
    }

    
    private void rehash() {
        Team[] oldTable = table;
        table = new Team[oldTable.length];
        size = 0;

        for (Team team : oldTable) {
            if (team != null) {
                putTeam(team);
            }
        }
    }

    
    public void displayTeams() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + ": " + (table[i] != null ? table[i].toString() : "null"));
        }
    }

    
    public Team getTeam(int teamID) {
        int index = hash(teamID);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].teamID == teamID) {
                return table[index];
            }
            index = (index + 1) % table.length;
            if (index == originalIndex) {
                break;
            }
        }

        System.out.println("Team with ID " + teamID + " not found");
        return null;
    }
}
