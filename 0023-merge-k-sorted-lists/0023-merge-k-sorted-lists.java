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
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode ll = new ListNode(-1);
        ListNode temp = ll;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }
            else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }
        if(h1!=null){
            temp.next = h1;
        }
        if(h2!=null){
            temp.next = h2;
        }
        return ll.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode temp = lists[0];
        for(int i=1; i<lists.length; i++){
            temp = merge(temp, lists[i]);
        }
        return temp;
    }
}