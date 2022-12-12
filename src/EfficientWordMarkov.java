import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov() {
        this(3);
    }

    public EfficientWordMarkov(int order) {
        myOrder = order;
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        for (int i = 0; i < myWords.length - myOrder; i++) {
            WordGram K = new WordGram(myWords, i, myOrder);
            String V = myWords[i + myOrder];

            if (!myMap.containsKey(K)) {
                ArrayList<String> X = new ArrayList<String>();
                X.add(V);
                myMap.put(K, X);
            } else {
                myMap.get(K).add(V);
            }

        }
        WordGram K = new WordGram(myWords, myWords.length - myOrder, myOrder);
        if (!myMap.containsKey(K)) {
            ArrayList<String> X = new ArrayList<String>();
            X.add(PSEUDO_EOS);
            myMap.put(K, X);
        } else {
            myMap.get(K).add(PSEUDO_EOS);
        }

    }

    @Override
    public ArrayList<String> getFollows(WordGram key) {
        ArrayList<String> ret = myMap.get(key);
        if (ret.isEmpty()) {
            throw new NoSuchElementException(key + " not in map");
        }
        return ret;
    }

}
