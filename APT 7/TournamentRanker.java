import java.util.*;

public class TournamentRanker {

    public String[] rankTeams(String[] names, String[] lostTo) {
        HashMap<String, player> scores = new HashMap<>();
        // create an entry for each player based on names
        for (int i = 0; i < names.length; i++) {
            // put the player from names
            String n = names[i];
            String l = lostTo[i];

            if (!scores.containsKey(n)) {
                scores.put(n, new player(n));
            }
            if (!l.equals("")) {
                if (!scores.containsKey(l)) {
                    scores.put(l, new player(l));
                }
                // update wins for the person names lost to, and update the player
                scores.get(l).wins += 1;
                scores.get(n).lostTo = (scores.get(l));
            }

        }
        // return intialize the number of wins of the opponent that beat each player

        // change all of th
        ArrayList<player> list = new ArrayList<>(scores.values());
        Collections.sort(list);

        String[] ret = new String[list.size()];
        int counter = 0;
        for (player p : list) {
            ret[counter] = p.name;
            counter++;
        }
        return ret;
    }

    private class player implements Comparable<player> {
        String name;
        int wins;
        player lostTo;

        player(String name) {
            this.name = name;
            this.wins = 0;
        }

        public String getName() {
            return this.name;
        }

        public int getWins() {
            return wins;
        }

        @Override
        public int compareTo(TournamentRanker.player o1) {
            int comp = 0;
            int a = this.getWins();
            int b = o1.getWins();
            if (a != b) {
                comp = b - a;
                return comp;
            } else {
                return this.lostTo.compareTo(o1.lostTo);
            }
        }

    }

    public static void main(String[] args) {
        TournamentRanker r = new TournamentRanker();
        String[] names = new String[] { "RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI"
        };
        String[] lostTo = new String[] { "SCHUETTLER", "AGASSI", "AGASSI", "" };
        System.out.println(Arrays.toString(r.rankTeams(names, lostTo)));
    }
}
