import java.util.TreeMap;

public class LeafTrails {

    TreeMap<Integer, String> leafTrails;

    public String[] trails(TreeNode tree) {
        leafTrails = new TreeMap<>();

        append(tree, "");

        String[] ret = new String[leafTrails.size()];

        int i = 0;
        for(String s: leafTrails.values()) {
            ret[i] = s;
            i++;
        }

        return ret;
    }

    public void append(TreeNode root, String path) {

        if(root == null) return;

        
        if(root.left == null && root.right == null) {
            leafTrails.put(root.info, path);
            return;
        }

        append(root.left, path + "0");
        append(root.right, path + "1");
    }
}