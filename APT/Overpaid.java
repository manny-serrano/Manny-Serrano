public class Overpaid {
    public int count(TreeNode root){
        if(root == null){
            return 0; 
        }
        return findgreater(root, Integer.MIN_VALUE)-1; 


    }



    private int findgreater(TreeNode node, int value){
        
        if(node == null){
            return 0; 
        }
        int count =0; 
        if(node.info > value){
            count=1; 
        }
        
       count += findgreater (node.left, node.info) ;
        count+=findgreater (node.right, node.info); 
        
        return count; 

    }
}
