
public class SoccerLeagues {
    public int[] points(String[] matches) {
        // HashMap<Integer, Integer> teamScores = new HashMap<>();
        int[] teamScores = new int[matches.length];
        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches.length; j++) {
                char compare = matches[i].charAt(j);
                if (compare == 'W') {
                    teamScores[i] += 3;
                }
                if (compare == 'D') {
                    teamScores[i] += 1;
                    teamScores[j] += 1;
                }
                if (compare == 'L') {
                    teamScores[j] += 3;
                }
            }
        }
        return teamScores;
    }
}

/*
 * each team plays two matches against each of the other teams
 * 
 * home win, tie, away win
 * 3, 1, 0 points
 * 
 * jth character of the ith element is the result of the match
 * between team i and j at i teams stadium
 * 
 * Matrix of
 * 
 */