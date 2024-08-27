public class LL {
    private void level(TreeNode t, int level) {
        if (t == null) return;
        t.info = level;
        if (t.left != null) level(t.left, level + 1);
        if (t.right != null) level(t.right, level + 1);
    }

    public TreeNode recharge(TreeNode t) {
        level(t, 1);
        return t;
    }
}
