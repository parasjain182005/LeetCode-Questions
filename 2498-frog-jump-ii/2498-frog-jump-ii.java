class Solution {
    public boolean check(int[] arr, int x){
        boolean[] vis = new boolean[arr.length];
        int a=0;
        for(int i=1; i<arr.length; i++){
            if(i+1<arr.length && arr[i+1]-a<=x) continue;
            else if(arr[i]-a<=x){
                vis[i]=true;
                a=arr[i];
            }
            else return false;
        }

        for(int i=arr.length-2; i>=0; i--){
            if(vis[i]==true) continue;
            else if(a-arr[i]<=x){
                a=arr[i];
            }
            else return false;
        }
        return true;
    }
    public int maxJump(int[] stones) {
        int l=1;
        int r = stones[stones.length-1];

        while(l<=r){
            int mid = (l+r)/2;

            if(check(stones, mid)){
                r=mid-1;
            }
            else l=mid+1;
        }
        return l;
    }
}