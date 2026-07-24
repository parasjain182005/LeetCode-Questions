class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(char c:sentence.toCharArray()){
            arr[c-'a']++;
        }
        for(int x:arr){
            if(x<1) return false;
        }
        return true;
    }
}