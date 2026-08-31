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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        List<Integer> l = new ArrayList<>();
        int i=1;
        while(temp.next.next!=null){
            if(temp.val<temp.next.val && temp.next.next.val<temp.next.val){
                l.add(i);
            }
            else if(temp.val>temp.next.val && temp.next.next.val>temp.next.val){
                l.add(i);
            }
            i++;
            temp = temp.next;
        }
        if(l.size()<2) return new int[]{-1,-1};

        int min = Integer.MAX_VALUE;
        for(int j=0; j<l.size()-1; j++){
            min = Math.min(min, l.get(j+1)-l.get(j));
        }
        int max = l.get(l.size()-1)-l.get(0);
        return new int[]{min, max};
    }
}