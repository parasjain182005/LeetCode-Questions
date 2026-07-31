class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for(char c:word.toCharArray()){
           arr[c-'a']++;
        }
        Arrays.sort(arr);
        int c=0,d=1;
        int ans = 0;
        for(int i=arr.length-1; i>=0; i--){
            if(c==8){
                c=0;
                d++;
            }
            ans+=arr[i]*d;
            c++;
        }
        return ans;
    }
}