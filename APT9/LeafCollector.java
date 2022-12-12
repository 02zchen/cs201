import java.util.*;

public class LeafCollector {

    public String[] getLeaves(TreeNode tree) {
        ArrayList<String> ret = new ArrayList<>();

        while (!isLeaf(tree)) {
            ArrayList<String> list = new ArrayList<>();
            collectAndremove(tree, list);
            // System.out.print(list.toString());
            String temp = String.join(" ", list);
            ret.add(temp);
        }
        ret.add("" + tree.info);

        return ret.toArray(new String[0]);
    }

    private void collectAndremove(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }
        if (isLeaf(root.left)) {
            list.add("" + root.left.info);
            System.out.print(root.left.info);
            root.left = null;
        }

        collectAndremove(root.left, list);

        if (isLeaf(root.right)) {
            list.add("" + root.right.info);
            System.out.print(root.right.info);
            root.right = null;
        }
        collectAndremove(root.right, list);
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

}
