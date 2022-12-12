public class TxMsg {
    static char[] Vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };

    public String getMessage(String original) {
        String[] data = original.split(" ");
        String[] ret = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            ret[i] = convert(data[i]);
        }

        return String.join(" ", ret);

    }

    public String convert(String data) {
        char[] charS = data.toCharArray();
        int vowelCounter = 0;
        for (int i = 0; i < charS.length; i++) {
            // checks if the current character is a vowel
            if (isVowel(charS[i])) {
                vowelCounter++;
                charS[i] = ' ';

            } else {
                if (i != 0 && !isVowel(charS[i - 1]) && charS[i - 1] != ' ') {
                    charS[i] = ';';
                }
            }

        }

        if (vowelCounter == charS.length) {
            return data;
        } else {
            String x = String.valueOf(charS);
            x = x.replace(" ", "");
            x = x.replace(";", "");
            return x;
        }
    }

    public boolean isVowel(char x) {
        for (char y : Vowels) {
            if (y == x) {
                return true;
            }
        }
        return false;
    }
    /*
     * public char[] charRemove(char[] original, int location){
     * char[] result = new char[original.length-1];
     * int last_insert = 0;
     * for (int i = 0; i < original.length; i++){
     * if (i == location)
     * i++;
     * 
     * result[last_insert++] = original[i];
     * }
     * return result;
     * }
     */
}
