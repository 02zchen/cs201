public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
        if (t == null) {
            return null;
        }
        if (t.right == null && t.left == null) {
            return t;
        }

        if (t.right == null && t.left != null) {
            t = tighten(t.left);
        }

        if (t.left == null && t.right != null) {
            t = tighten(t.right);
        }

        t.left = tighten(t.left);
        t.right = tighten(t.right);
        return t;
    }

}