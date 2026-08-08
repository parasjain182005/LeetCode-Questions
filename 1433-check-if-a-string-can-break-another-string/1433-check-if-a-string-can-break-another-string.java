class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean a1 = true;
        boolean a2 = true;

        for(int i=0; i<arr1.length; i++){
            if(arr1[i]<arr2[i]) a1=false;
            if(arr2[i]<arr1[i]) a2=false;
        }

        return a1||a2;
    }
}