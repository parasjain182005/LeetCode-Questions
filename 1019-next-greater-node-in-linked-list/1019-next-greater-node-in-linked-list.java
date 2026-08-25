/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        int n=list.size();
        int[] ans = new int[n];
        
        Stack<Integer> s1 = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while (!s1.isEmpty() && s1.peek() <= list.get(i)) {
                s1.pop();
            }

            if (!s1.isEmpty()) {
                ans[i] = s1.peek();
            } else {
                ans[i] = 0;
            }

            s1.push(list.get(i));
        }
        return ans;
    }
}