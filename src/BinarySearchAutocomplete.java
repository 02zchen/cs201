import java.util.*;

/**
 * 
 * Using a sorted array of Term objects, this implementation uses binary search
 * to find the top term(s).
 * 
 * @author Austin Lu, adapted from Kevin Wayne
 * @author Jeff Forbes
 * @author Owen Astrachan in Fall 2018, revised API
 */
public class BinarySearchAutocomplete implements Autocompletor {

	private Term[] myTerms;
	private int mySize;

	/**
	 * Given arrays of words and weights, initialize myTerms to a corresponding
	 * array of Terms sorted lexicographically.
	 * 
	 * This constructor is written for you, but you may make modifications to
	 * it.
	 * 
	 * @param terms
	 *                - A list of words to form terms from
	 * @param weights
	 *                - A corresponding list of weights, such that terms[i] has
	 *                weight[i].
	 * @return a BinarySearchAutocomplete whose myTerms object has myTerms[i] =
	 *         a Term with word terms[i] and weight weights[i].
	 * @throws NullPointerException if either argument passed in is null
	 */
	public BinarySearchAutocomplete(String[] terms, double[] weights) {
		if (terms == null || weights == null) {
			throw new NullPointerException("One or more arguments null");
		}

		initialize(terms, weights);
	}

	/**
	 * Uses binary search to find the index of the first Term in the passed in
	 * array which is considered equivalent by a comparator to the given key.
	 * This method should not call comparator.compare() more than 1+log n times,
	 * where n is the size of a.
	 * 
	 * @param a
	 *                   - The array of Terms being searched
	 * @param key
	 *                   - The key being searched for.
	 * @param comparator
	 *                   - A comparator, used to determine equivalency between the
	 *                   values in a and the key.
	 * @return The first index i for which comparator considers a[i] and key as
	 *         being equal. If no such index exists, return -1 instead.
	 */
	public static int firstIndexOf(Term[] a, Term key, Comparator<Term> comparator) {
		int index = BinarySearchLibrary.firstIndex(Arrays.asList(a), key, comparator);
		return index;
	}

	/**
	 * The same as firstIndexOf, but instead finding the index of the last Term.
	 * 
	 * @param a
	 *                   - The array of Terms being searched
	 * @param key
	 *                   - The key being searched for.
	 * @param comparator
	 *                   - A comparator, used to determine equivalency between the
	 *                   values in a and the key.
	 * @return The last index i for which comparator considers a[i] and key as
	 *         being equal. If no such index exists, return -1 instead.
	 */
	public static int lastIndexOf(Term[] a, Term key, Comparator<Term> comparator) {
		int index = BinarySearchLibrary.lastIndex(Arrays.asList(a), key, comparator);
		return index;
	}

	/**
	 * Required by the Autocompletor interface. Returns an array containing the
	 * k words in myTerms with the largest weight which match the given prefix,
	 * in descending weight order. If less than k words exist matching the given
	 * prefix (including if no words exist), then the array instead contains all
	 * those words. e.g. If terms is {air:3, bat:2, bell:4, boy:1}, then
	 * topKMatches("b", 2) should return {"bell", "bat"}, but topKMatches("a",
	 * 2) should return {"air"}
	 * 
	 * @param prefix
	 *               - A prefix which all returned words must start with
	 * @param k
	 *               - The (maximum) number of words to be returned
	 * @return An array of the k words with the largest weights among all words
	 *         starting with prefix, in descending weight order. If less than k
	 *         such words exist, return an array containing all those words If
	 *         no such words exist, reutrn an empty array
	 * @throws NullPointerException if prefix is null
	 */

	@Override
	public List<Term> topMatches(String prefix, int k) {
		if (k < 0) {
			throw new IllegalArgumentException("Illegal value of k:" + k);
		}
		if (k == 0) {
			return new ArrayList<>();
		}
		Term prefixT = new Term(prefix, 0);
		PrefixComparator comp = PrefixComparator.getComparator(prefix.length());

		// find the start and end index of all words starting with the prefix
		int start = firstIndexOf(myTerms, prefixT, comp);
		int end = lastIndexOf(myTerms, prefixT, comp);
		// if prefix isn't found
		if (start < 0 || end < 0) {
			return new ArrayList<Term>();
		}

		// maintain pq of size k
		PriorityQueue<Term> pq = new PriorityQueue<>(Comparator.comparing(Term::getWeight));

		for (int i = start; i < end + 1; i++) {
			// unecessary bc all words should start with prefix
			// if (!t.getWord().startsWith(prefix)) {
			// continue; // don't process if doesn't begin with prefix
			// }

			Term t = myTerms[i];
			if (pq.size() < k) {
				pq.add(t);
			} else if (pq.peek().getWeight() < t.getWeight()) {
				pq.remove();
				pq.add(t);
			}
		}
		// after loop, pq holds *at most* k Terms and
		// these are terms that are the "heaviest" based on code above
		// since pq is a min-pq, lightest/least-heavy is first to be removed

		int numResults = Math.min(k, pq.size());
		LinkedList<Term> ret = new LinkedList<>();
		for (int i = 0; i < numResults; i++) {
			ret.addFirst(pq.remove());
		}
		return ret;
	}

	// public static void main(String[] args) {

	// }

	@Override
	public void initialize(String[] terms, double[] weights) {
		myTerms = new Term[terms.length];

		for (int i = 0; i < terms.length; i++) {
			myTerms[i] = new Term(terms[i], weights[i]);
		}

		Arrays.sort(myTerms);
	}

	@Override
	public int sizeInBytes() {
		if (mySize == 0) {

			for (Term t : myTerms) {
				mySize += BYTES_PER_DOUBLE +
						BYTES_PER_CHAR * t.getWord().length();
			}
		}
		return mySize;
	}
}