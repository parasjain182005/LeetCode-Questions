/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i=0; i<s; i++){
                Node x = q.poll();
                l.add(x.val);

                List<Node> list = x.children;

                for(Node y:list){
                    q.add(y);
                }
            }

            ans.add(l);
        }
        return ans;
    }
}