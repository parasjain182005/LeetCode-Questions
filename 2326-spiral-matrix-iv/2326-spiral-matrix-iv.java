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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(ans[i],-1);

        int i=0, j=0, x=1;
        while(head!=null){
            ans[i][j]=head.val;
            head=head.next;

            if(x==1){
                if(j+1>=n || (j+1<n && ans[i][j+1]!=-1)){
                    x=2;
                    i++;
                }
                else j++;
            }  
            else if(x==2){
                if(i+1>=m || (i+1<m && ans[i+1][j]!=-1)){
                    x=3;
                    j--;
                }
                else i++;
            }  
            else if(x==3){
                if(j-1<0 || (j-1>=0 && ans[i][j-1]!=-1)){
                    x=4;
                    i--;
                }
                else j--;
            }  
            else{
                if(i-1<0 || (i-1>=0 && ans[i-1][j]!=-1)){
                    x=1;
                    j++;
                }
                else i--;
            }  

        }
        return ans;
    }
}