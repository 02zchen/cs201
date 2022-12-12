public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        // fill in code here
        int maxIndex = 0;
        int matches = 0;
        int maxMatches = 0;
        for (int i = 0; i < strands.length; i++) {
            for (int j = 0; j < strands[i].length(); j++) {
                if (strands[i].substring(j, j + 1).equals(nuc)) {
                    matches++;
                }
            }
            if (matches > maxMatches) {
                maxMatches = matches;
                maxIndex = i;
                matches = 0;
            } else if (matches == maxMatches) {
                if (strands[i].length() > strands[maxIndex].length()) {
                    maxIndex = i;
                }
                matches = 0;
            }
            matches = 0;
        }
        if (maxMatches == 0) {
            return "";
        } else {
            return strands[maxIndex];
        }
    }
}