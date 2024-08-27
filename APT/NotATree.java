import javax.swing.tree.TreeNode;

public class NotATree {
    public String check(TreeNode root){
        if(root == null) {
            return “not a tree”;
        }

        if(root.left != null && root.right != null) {
            return “is a tree”;
        }

        if (root.left == null) {
            return check(root.right);
        }

        return check(root.left);
        
    }
}
