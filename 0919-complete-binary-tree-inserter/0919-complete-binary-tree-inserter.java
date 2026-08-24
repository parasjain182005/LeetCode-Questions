/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> q = new LinkedList<>();

    public void addToQueue(TreeNode root){
        q.add(root);

        while(!q.isEmpty()){
            TreeNode x = q.peek();
            if(x.left!=null){
                q.offer(x.left);
            }
            else break;

            if(x.right!=null){
                q.offer(x.right);
                q.poll();
            }
            else break;
        }

    }

    public CBTInserter(TreeNode root) {
        this.root=root;
        addToQueue(root);
    }
    
    public int insert(int val) {
        TreeNode x = q.peek();
        TreeNode temp = new TreeNode(val);
        if(x.left==null){
            x.left = temp;
        }
        else{
            x.right = temp;
            q.poll();
        }
        q.offer(temp);
        return x.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */