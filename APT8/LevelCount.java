public class LevelCount {
    public int count(TreeNode t, int level) {
        // if the tree is null or recursion tries to get to a null leaf
        if (t == null) {
            return 0;
        }

        level -= 1;
        int counter = 0;

        // if level was prev 0, there is only 1 node
        if (level == -1) {
            return 1;
        }
        return count(t.left, level) + count(t.right, level);
        // when you recurse to one prior to the wanted level
        // if (level == 0) {
        // return count(t.left, level) + count(t.right, level);
        // }

        // // force the tree to keep iterating down until you recurse to a base case
        // counter = count(t.left, level) + count(t.right, level);
        // // counter is a dummy variable?
        // // i dont think this is ever used
        // return counter;

    }
}
