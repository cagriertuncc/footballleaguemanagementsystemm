package footballleaguemanagementsystemm;

public class TeamList {
    public Team head;
    public int size;

    public TeamList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void addTeam(Team newTeam) {
        if (head == null) {
            head = newTeam;
        } else {
            Team current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTeam;
        }
        this.size++;
    }

    public void deleteTeam(int teamID) {
        Team current = head;
        Team previous = null;

        if (current != null && current.teamID == teamID) {
            head = current.next;
            this.size--;
            return;
        }

        while (current != null && current.teamID != teamID) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        previous.next = current.next;
        this.size--;
    }

    public Team findTeam(int teamID) {
        Team current = head;
        while (current != null) {
            if (current.teamID == teamID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void printTeams() {
        Team currNode = this.head;

        System.out.println("TeamList: ");

        while (currNode != null) {
            System.out.println(" {id:" + currNode.teamID + "   " + currNode.teamName + "}  --->");
            currNode.players.printPlayers();
            currNode = currNode.next;
        }
        System.out.println("");
    }
}
