import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String, ArrayList<String>> myMap;

	public EfficientMarkov() {
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		for (int i = 0; i < text.length() - myOrder; i++) {
			String K = myText.substring(i, i + myOrder);
			String V = myText.substring(i + myOrder, i + myOrder + 1);

			if (!myMap.containsKey(K)) {
				ArrayList<String> X = new ArrayList<String>();
				X.add(V);
				myMap.put(K, X);
			} else {
				myMap.get(K).add(V);
			}
		}
		String K = myText.substring(text.length() - myOrder, text.length());
		if (!myMap.containsKey(K)) {
			ArrayList<String> X = new ArrayList<String>();
			X.add(PSEUDO_EOS);
			myMap.put(K, X);
		} else {
			myMap.get(K).add(PSEUDO_EOS);
		}
	}

	@Override
	public ArrayList<String> getFollows(String key) {
		ArrayList<String> ret = myMap.get(key);
		if (ret.isEmpty()) {
			throw new NoSuchElementException(key + " not in map");
		}
		return ret;
	}
}
