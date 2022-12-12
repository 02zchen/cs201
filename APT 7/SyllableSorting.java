import java.security.Key;
import java.util.*;

public class SyllableSorting {
    public String[] sortWords(String[] words) {
        // decompose words into syllables
        // syllables are non empty max of consonants follow by vowels
        TreeMap<String, syllable> map = new TreeMap<>();

        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, new syllable(word));
            }
            map.get(word).numberOf += 1;

        }

        List<syllable> list = new LinkedList<>(map.values());
        Collections.sort(list);

        ArrayList<String> ret = new ArrayList<String>();
        for (syllable aa : list) {
            for (int i = 0; i < aa.numberOf; i++) {
                ret.add(aa.getName());
            }
        }

        // System.out.println(Arrays.toString(ret));
        return ret.toArray(new String[ret.size()]);
    }

    private class syllable implements Comparable<syllable> {
        String[] v = new String[] { "a", "e", "i", "o", "u" };
        HashSet<String> vowels = new HashSet<>(Arrays.asList(v));

        String name;
        String[] unsortedS;
        String[] sortedS;

        int numberOf = 0;

        syllable(String word) {
            this.name = word;
            ArrayList<String> sDecomp = new ArrayList<>();
            int splice = 0;
            for (int i = 0; i < word.length() - 1; i++) {
                // find current character and the character after it
                String c = word.substring(i, i + 1);
                String nextC = word.substring(i + 1, i + 2);
                // if the current character is a vowel and the next character isn't
                if (vowels.contains(c) && !vowels.contains(nextC)) {
                    // splice word
                    String Syllable = word.substring(splice, i + 1);
                    // add the spliced word to the current syllable decomp
                    sDecomp.add(Syllable);
                    // increase intial splic index
                    splice = i + 1;
                }
                // if you get to the end of the string and there aren't any more switches,
                // return last splic
                if (i == word.length() - 2) {
                    String Syllable = word.substring(splice, word.length());
                    sDecomp.add(Syllable);
                }
            }
            this.unsortedS = sDecomp.toArray(new String[sDecomp.size()]);
            // System.out.println(Arrays.toString(unsortedS));

            Collections.sort(sDecomp, Comparator.naturalOrder());
            this.sortedS = sDecomp.toArray(new String[sDecomp.size()]);
            // System.out.println(Arrays.toString(sortedS));

        }

        public String getName() {
            return name;
        }

        public String[] getUnsorted() {
            return unsortedS;
        }

        public String[] getSorted() {
            return sortedS;
        }

        @Override
        public int compareTo(syllable o) {
            String[] a = this.getSorted();
            String[] b = o.getSorted();

            int length = 0;
            int alength = a.length;
            int blength = b.length;
            int compare = 0;

            // iterate through the smaller arraylist
            if (alength > blength) {
                length = blength;

            } else {
                length = alength;
            }

            for (int i = 0; i < length; i++) {
                compare = a[i].compareTo(b[i]);
                if (compare != 0) {
                    // System.out.println(compare);
                    return compare;
                }

                if (i == length - 1 && alength - length == 0) {
                    String[] x = this.getUnsorted();
                    String[] y = o.getUnsorted();

                    for (int j = 0; j < length; j++) {
                        compare = x[j].compareTo(y[j]);
                        if (compare != 0) {
                            // System.out.println(x[i]);
                            // System.out.println(y[i]);
                            // System.out.println(compare);
                            return compare;
                        }
                    }
                }

            }
            // if it makes it through the entire list without reaching a differnce, compare
            // unequals

            return compare;
        }

    }

    public static void main(String[] args) {
        String[] words = new String[] { "maga", "gamayawa" };
        SyllableSorting r = new SyllableSorting();
        r.sortWords(words);
    }
}

// ArrayList<String> sDecomp = new ArrayList<>();
// int splice = 0;
// for (int i = 0; i < word.length() - 1; i++) {
// // find current character and the character after it
// String c = word.substring(i, i + 1);
// String nextC = word.substring(i + 1, i + 2);
// // if the current character is a vowel and the next character isn't
// if (vowels.contains(c) && !vowels.contains(nextC)) {
// // splice word
// String Syllable = word.substring(splice, i + 1);
// // add the spliced word to the current syllable decomp
// sDecomp.add(Syllable);
// // increase intial splic index
// splice = i + 1;
// }
// // if you get to the end of the string and there aren't any more switches,
// // return last splic
// if (i == word.length() - 2) {
// String Syllable = word.substring(splice, word.length());
// sDecomp.add(Syllable);
// }
// }
// if (!map2.containsKey(word)) {
// map.put(word, sDecomp.toArray(new String[sDecomp.size()]));
// }
// // sort decomped word alphabetically
// Collections.sort(sDecomp, Comparator.naturalOrder());
// // add sorted word to the ret hashmap
// String[] temp = sDecomp.toArray(new String[sDecomp.size()]);
// // System.out.println(Arrays.toString(temp));
// if (!map.containsKey(word)) {
// // System.out.println(word);
// map.put(word, temp);
// }

// List<Map.Entry<String, String[]>> list = new LinkedList<>(map.entrySet());
// // sort ret keys according to their values, everything prior works noicely
// Collections.sort(list, new Comparator<Map.Entry<String, String[]>>() {
// public int compare(Map.Entry<String, String[]> o1, Map.Entry<String,
// String[]> o2) {
// String[] a = o1.getValue();
// String[] b = o2.getValue();
// int length = 0;
// int compare = 0;
// // iterate through the smaller arraylist
// if (a.length > b.length) {
// length = a.length;
// } else {
// length = b.length;
// }

// for (int i = 0; i < length; i++) {
// compare = a[i].compareTo(b[i]);
// if (compare != 0) {
// return compare;
// }
// }

// compare = (map2.get(o2.getKey())).compareTo(map2.get(o2.getKey()));
// return compare;
// // if it loops through the entire thing and compare is still equal, set
// compare
// // equal to
// }
// });