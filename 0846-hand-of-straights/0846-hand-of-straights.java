class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        List<Integer> l = new ArrayList<>();
        for(int x:hand) l.add(x);
        Collections.sort(l);

        while(!l.isEmpty()){
            int x=l.get(0), j=0, c=1;
            l.remove(0);

            while(j<l.size() && c<groupSize){
                if(x==l.get(j)){
                    j++;
                }
                else if(x==l.get(j)-1){
                    x++;
                    c++;
                    l.remove(j);
                }
                else return false;
            }
            if(c<groupSize) return false;
        }
        return true;
    }
}