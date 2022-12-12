public class PathSum {
    public int hasPath(int target, TreeNode tree) {

        // if tree is empty, return 0
        int checker = 0;
        // base case: if your tree is null or you try to move to an invalid leaf,
        // checker returns zero
        if (tree == null) {
            return 0;
        }
        // subtract the current node info from the target
        int sum = target - tree.info;

        // base case: if you reach a leaf and the sum is 0, return 1
        if (tree.left == null && tree.right == null && sum == 0) {
            return 1;
        }

        // else, move to node that isnt null and repeat down every branch until you find
        // it
        checker = hasPath(sum, tree.left) + hasPath(sum, tree.right);

        return checker;
    }

}
