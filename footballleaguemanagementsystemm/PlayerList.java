
package footballleaguemanagementsystemm;

public class PlayerList {
    public Player head;
    public int size;

    public PlayerList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void addPlayer(Player newPlayer) {
        if (head == null) {
            head = newPlayer;
        } else {
            Player current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPlayer;
        }
        this.size++;
    }

    public void deletePlayer(int playerID) {
        Player current = head;
        Player previous = null;

        if (current != null && current.playerID == playerID) {
            head = current.next;
            this.size--;
            return;
        }

        while (current != null && current.playerID != playerID) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        previous.next = current.next;
        this.size--;
    }

    public void printPlayers() {
        Player currNode = this.head;

        System.out.println("PlayerList: ");

        while (currNode != null) {
            System.out.print(" {id:" + currNode.playerID + "   " + currNode.playerName + " (" + currNode.position + ")}  --->");
            currNode = currNode.next;
        }
        System.out.println("");
    }
}
