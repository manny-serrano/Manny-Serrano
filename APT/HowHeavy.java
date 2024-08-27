public class HowHeavy {
        public int weight(TreeNode tree, int target){
            TreeNode targetnode = find(tree, target); 
            if(tree == null){
                return 0; 
            }
            return sum(targetnode); 
            
           
            



        }

        public TreeNode find(TreeNode node, int target){
            if(node ==null){
                return null; 
            }
            if(node.info ==target){
                return node; 
            }
            TreeNode left = find(node.left, target); 
            if(left!=null){
                return left;
            }
            return find(node.right, target); 
        }
        private int sum(TreeNode root){
            if(root==null){
                return 0; 
            }
            return root.info+sum(root.left) +sum(root.right); 
        }
    }

