import java.util.TreeSet;
import java.util.*;

public class UniqueTreeValues {
    private TreeSet<Integer> nums;

    public int[] unique(TreeNode root) {
        nums = new TreeSet<>();
        traverse(root);
        int[] ret = new int[nums.size()];
        int counter = 0;
        for (Integer x : nums) {
            ret[counter] = x;
            counter++;
        }

        return ret;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            nums.add(root.info);
            traverse(root.right);
        }

    }

}