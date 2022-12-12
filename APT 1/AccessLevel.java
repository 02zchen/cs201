
public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String AC = new String("");
        for (int i = 0; i < rights.length; i++) {
            if (rights[i] >= minPermission) {
                AC = AC + "A";
            } else {
                AC = AC + "D";
            }
        }
        return AC;

    }
}