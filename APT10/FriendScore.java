import java.util.*;

public class FriendScore {
    HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<>();

    public int highestScore(String[] friends) {
        int highest = 0;
        // store all immediate friends within the hashmap for every person
        for (int i = 0; i < friends.length; i++) {
            String temp = friends[i];
            myGraph.put(i, new HashSet<Integer>());
            for (int j = 0; j < temp.length(); j++) {
                char slice = temp.charAt(j);
                if (slice == 'Y') {
                    HashSet<Integer> temp2 = myGraph.get(i);
                    temp2.add(j);
                    myGraph.put(i, temp2);
                }
            }
        }
        for (Integer Key : myGraph.keySet()) {
            Set<Integer> temp3 = twoFriends(Key);
            int size = temp3.size();
            if (size > highest) {
                highest = size;
            }
        }
        return highest;
    }

    private Set<Integer> twoFriends(int index) {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> friends = myGraph.get(index);
        set.addAll(friends);
        for (int friend : friends) {
            Set<Integer> twoF = myGraph.get(friend);
            set.addAll(twoF);
        }
        set.remove(index);
        return set;
    }
}
