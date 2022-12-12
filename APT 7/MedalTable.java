import java.util.HashMap;
import java.util.*;

public class MedalTable {
    public String[] generate(String[] results) {
        Map<String, MedalCountry> map = new HashMap<>();
        // iterates through each set of 3 results and logs each countries medal counts
        for (String s : results) {
            // splits each set of 3 results into individual country strings
            String[] data = s.split(" ");
            int counter = 0;
            for (String c : data) {
                if (!map.containsKey(c)) {
                    map.put(c, new MedalCountry(c));
                }
                // gold
                if (counter == 0) {
                    map.get(c).myGold += 1;
                }
                // silver
                if (counter == 1) {
                    map.get(c).mySilver += 1;
                }
                // bronze
                if (counter == 2) {
                    map.get(c).myBronze += 1;
                }
                counter++;
            }
        }

        ArrayList<MedalCountry> list = new ArrayList<>(map.values());
        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getSilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getBronze).reversed();

        Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);
        Comparator<MedalCountry> comp = gold.thenComparing(silver).thenComparing(bronze).thenComparing(country);
        // comp compares gold, silver, bronze then country name
        Collections.sort(list, comp);

        String[] ret = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i).toString();
        }
        return ret;
    }

    private class MedalCountry {
        String myName;
        int myGold;
        int mySilver;
        int myBronze;

        MedalCountry(String name) {
            myName = name;

        }

        public int getGold() {
            return myGold;
        }

        public int getSilver() {
            return mySilver;
        }

        public int getBronze() {
            return myBronze;
        }

        public String getName() {
            return myName;
        }

        @Override
        public String toString() {
            return String.format("%s %d %d %d", myName, myGold, mySilver, myBronze);
        }
    }
}