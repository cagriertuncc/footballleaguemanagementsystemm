package footballleaguemanagementsystemm;

public class BinarySearchTreeTeam {
    Team root;

    public BinarySearchTreeTeam() {
        root = null;
    }

    public void insert(int teamID, String teamName) {
        if (root == null) {
            root = new Team(teamID, teamName);
            return;
        } else {
            Team current = root;
            Team parent = null;
            while (true) {
                parent = current;
                if (current.teamID > teamID) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Team(teamID, teamName);
                        return;
                    }
                } else if (current.teamID < teamID) {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Team(teamID, teamName);
                        return;
                    }
                } else {
                    return; // Duplicate IDs are not allowed
                }
            }
        }
    }

    public int minValue(Team root) {
        int min = root.teamID;

        while (root.left != null) {
            root = root.left;
            min = root.teamID;
        }
        return min;
    }

    // Search Functionality: Search for a team by name
    public Team searchTeamByName(String teamName) {
        return searchTeamByName(root, teamName);
    }

    private Team searchTeamByName(Team node, String teamName) {
        if (node == null) {
            return null; // Not found
        }
        if (node.teamName.equalsIgnoreCase(teamName)) {
            return node; // Found
        }
        // Search in left or right subtree
        Team leftResult = searchTeamByName(node.left, teamName);
        if (leftResult != null) {
            return leftResult;
        }
        return searchTeamByName(node.right, teamName);
    }
}

// Team class
class Team {
    int teamID;
    String teamName;
    Team left, right;

    public Team(int teamID, String teamName) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.left = this.right = null;
    }
}
