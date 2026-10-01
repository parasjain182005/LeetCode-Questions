class SmallestInfiniteSet {
    Set<Integer> s;
    public SmallestInfiniteSet() {
        s = new HashSet<>();
        for(int i=1; i<=1000; i++){
            s.add(i);
        }        
    }
    
    public int popSmallest() {
        int x = Collections.min(s);
        s.remove(x);
        return x;
    }
    
    public void addBack(int num) {
        if(!s.contains(num)){
            s.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */