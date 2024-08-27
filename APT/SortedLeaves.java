import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {

   

    public String[] values(TreeNode tree) {
        ArrayList<String> valueList = new ArrayList<>();
        leafvalues(tree, valueList);
        Collections.sort(valueList);
        return valueList.toArray(new String[0]);
    }

    public void leafvalues(TreeNode t, ArrayList<String> valueList) {
        if (t == null) return; 

        if (t.left == null && t.right == null) {
            valueList.add(getValue(t.info));
            return;
        }

        leafvalues(t.left, valueList);
        leafvalues(t.right, valueList);
    }

    public String getValue(int value) {
        return Character.toString((char) value);
    }

    
}
