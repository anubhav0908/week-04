package collections.commonproblems.designavotingsystem;
import java.util.*;

public class DesignVotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); //create hash map
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>(); //create linked hash map
    private TreeMap<String, Integer> sortedVoteMap = new TreeMap<>(); //create tree map

    // Method to do a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes as per insertion order (LinkedHashMap)
    public void displayVoteOrder() {
        System.out.println("\nVotes in Order of Voting:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display votes sorted by candidate names (TreeMap)
    public void displaySortedVotes() {
        System.out.println("\nVotes Sorted by Candidate Name:");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display votes as stored in HashMap (Unordered)
    public void displayAllVotes() {
        System.out.println("\nAll Votes (Unordered HashMap):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        DesignVotingSystem votingSystem = new DesignVotingSystem();

        // Cast votes
        votingSystem.castVote("Arjun");
        votingSystem.castVote("Shristy");
        votingSystem.castVote("Arjun");
        votingSystem.castVote("Tata");
        votingSystem.castVote("Shristy");
        votingSystem.castVote("Arjun");

        // Display results
        votingSystem.displayVoteOrder();
        votingSystem.displaySortedVotes();
        votingSystem.displayAllVotes();
    }
}

