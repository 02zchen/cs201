import java.util.Comparator;

/**
 * Factor pattern for obtaining PrefixComparator objects
 * without calling new. Users simply use
 *
 * Comparator<Term> comp = PrefixComparator.getComparator(size)
 *
 * @author owen astrachan
 * @date October 8, 2020
 */
public class PrefixComparator implements Comparator<Term> {

    private int myPrefixSize; // size of prefix

    /**
     * private constructor, called by getComparator
     * 
     * @param prefix is prefix used in compare method
     */
    private PrefixComparator(int prefix) {
        myPrefixSize = prefix;
    }

    /**
     * Factory method to return a PrefixComparator object
     * 
     * @param prefix is the size of the prefix to compare with
     * @return PrefixComparator that uses prefix
     */
    public static PrefixComparator getComparator(int prefix) {
        return new PrefixComparator(prefix);
    }

    @Override
    /**
     * Use at most myPrefixSize characters from each of v and w
     * to return a value comparing v and w by words. Comparisons
     * should be made based on the first myPrefixSize chars in v and w.
     * 
     * @return < 0 if v < w, == 0 if v == w, and > 0 if v > w
     */

    // compares the words of term V and term W based on the lexographical order of
    // the first (prefix) number of characters
    public int compare(Term v, Term w) {
        // change this to use myPrefixSize as specified,
        // replacing line below with code
        String a = v.getWord();
        String b = w.getWord();
        int comp = 0;
        boolean reduced = false;
        // if a or b are shorter, compare up to shortest length
        int length = myPrefixSize;
        int minlength = Math.min(a.length(), b.length());

        if (minlength < myPrefixSize) {
            length = minlength;
            reduced = true;
        }

        if (length == 0 && reduced == true) {
            comp = a.length() - b.length();
        }

        for (int i = 0; i < length; i++) {
            char a1 = a.charAt(i);
            char b1 = b.charAt(i);
            // return the difference in character value at first difference
            if (a1 != b1) {
                return a1 - b1;
            }
            // if you get to myprefixSize and theyre still equal, return the difference in
            // lengths if one of the strings was originally shorter than prefix
            if (i == length - 1 && a1 == b1 && reduced) {
                comp = a.length() - b.length();
                // System.out.println("a: " + a.length() + " b: " + b.length());
                // System.out.println("comp: " + comp);
            }
        }
        return comp;
    }

    // public static void main(String[] args) {
    // Comparator<Term> c3 = PrefixComparator.getComparator(3);
    // Comparator<Term> c4 = PrefixComparator.getComparator(4);
    // Term c = new Term("bee", 0);
    // Term d = new Term("beeswax", 0);

    // // int r3_cat = c3.compare(c, d);
    // int r4_cat = c4.compare(c, d);

    // System.out.println("result: " + Math.signum(r4_cat));
    // }
}
