class Solution {
    public int nextGreaterElement(int n) {
        if(n<10) return -1;
        String s = Integer.toString(n);
        String x = ""+s.charAt(s.length()-1);
        int i=s.length()-2;
        while(i>=0){
            if(s.charAt(i)<x.charAt(x.length()-1)){
                break;
            } 
            x+=s.charAt(i);
            i--;
        }  
        if(i==-1) return -1;

        char[] arr = x.toCharArray();
        int j = arr.length-1;
        while(j-1>=0 && arr[j-1]>s.charAt(i)) j--;

        char a = arr[j];
        arr[j] = s.charAt(i); 

        Arrays.sort(arr);    

        String ans = s.substring(0,i) + a + new String(arr);
        long val = Long.parseLong(ans);

        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }
}