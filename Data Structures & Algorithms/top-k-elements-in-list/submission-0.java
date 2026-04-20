class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> intCount = new HashMap<>();
        for (int i : nums){
            intCount.put(i, intCount.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> intCount.get(a)-intCount.get(b));
        for (Integer i : intCount.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k-1; i>=0; i--){
            result[i]= pq.poll();
        }
        return result;
    }
}
