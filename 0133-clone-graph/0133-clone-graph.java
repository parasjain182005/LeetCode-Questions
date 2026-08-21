/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            Node p = q.poll();

            for(Node x : p.neighbors){
                if(!map.containsKey(x)){
                    q.add(x);
                    map.put(x, new Node(x.val, new ArrayList<>()));
                }
                map.get(p).neighbors.add(map.get(x));
            }
        }

        return map.get(node);
    }
}