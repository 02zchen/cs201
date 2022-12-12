import java.util.*;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        if (votes.length == 1) {
            return 0;
        }
        int req = 0;
        int ourCount = votes[0];

        PriorityQueue<Integer> pq;
        pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < votes.length; i++) {
            pq.add(votes[i]);
        }

        int winCount = pq.remove();
        int tempCheck = pq.remove();
        if (winCount == ourCount && winCount > tempCheck) {
            return req;
        }
        pq.add(tempCheck);
        while (ourCount <= winCount) {
            ourCount++;
            pq.add(winCount - 1);
            req++;
            winCount = pq.remove();
        }
        return req;
    }
}
