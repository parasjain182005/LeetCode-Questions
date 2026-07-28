class Solution {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        char c = '1';
        int i=0, n=arr.length;
        while(i<n){
            if(i+1<n && arr[i]==arr[i+1]){
                s1.append(arr[i]);
                s2.append(arr[i]);
                i+=2;
            }
            else{
                c=arr[i];
                i++;
            }
        }
        s2.reverse();
        if(c=='1') return s1.toString()+s2.toString();
        return s1.toString()+c+s2.toString();
    }
}