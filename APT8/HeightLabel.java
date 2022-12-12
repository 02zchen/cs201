public class HeightLabel {
    private int height(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(height(t.left), height(t.right));
    }

    public TreeNode rewire(TreeNode t) {
        if (t == null) {
            return null;
        }
        return new TreeNode(height(t), rewire(t.left), rewire(t.right));
    }
}
