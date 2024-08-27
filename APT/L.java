import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class L {
    private ArrayList<Integer> myList = new ArrayList<>();

    private void makeList(TreeNode t) {
        if (t == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);
        while(!q.isEmpty()) {
            TreeNode tree = q.remove();
            if (tree.left != null) q.add(tree.left);
            if (tree.right != null) q.add(tree.right);
            if (tree.left == null && tree.right == null) myList.add(tree.info);
        }
    }

    private void getLeavesHelper(TreeNode t) {
        if (t == null) return;
        if (t.left == null && t.right == null) {
            myList.add(t.info);
            return;
        }
        if (t.left != null) getLeavesHelper(t.left);
        if (t.right != null) getLeavesHelper(t.right);
    }

    public int[] getLeaves(TreeNode t) {
        makeList(t);
        int[] count = new int[myList.size()];;
        for (int i = 0; i < count.length; i++) {
            count[i] = myList.get(i);
        }
        return count;
    }
}
