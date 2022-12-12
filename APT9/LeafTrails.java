import java.util.*;

public class LeafTrails {
    private ArrayList<leaf> trail;

    public String[] trails(TreeNode tree) {
        trail = new ArrayList<>();
        traverse(tree, "");
        Comparator<leaf> comp = Comparator.comparing(leaf::getInfo);
        Collections.sort(trail, comp);
        String[] ret = new String[trail.size()];
        int counter = 0;
        for (leaf l : trail) {
            ret[counter] = l.myPath;
            counter++;
        }
        return ret;
    }

    public void traverse(TreeNode tree, String p) {
        // if it reaches a leaf, add a leaf object to the trail
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null) {
            System.out.println(p);
            trail.add(new leaf(tree.info, p));
            return;
        }
        traverse(tree.left, p + "0");
        traverse(tree.right, p + "1");
    }

    private class leaf {
        int myInfo;
        String myPath;

        leaf(int i, String p) {
            myInfo = i;
            myPath = p;
        }

        public int getInfo() {
            return myInfo;
        }
    }
}
