public class HeightLabel {
    public TreeNode rewire(TreeNode t) {
        if(t == null){
            return null; // treet null as a node for getting height 
        }

        TreeNode copy = new TreeNode (height(t));
        //TreeNode copy = new TreeNode(t.info); 
        copy.info = height(t); // write height method to get height of node
        copy.left = rewire(t.left);
        copy.right = rewire(t.right); 
        return copy; 

        
        


}

private int height(TreeNode t){

    if(t==null){
        return 0;
    }

    return 1+ Math.max(height(t.left), height(t.right)); 
}


}
       
       
       
        
    
