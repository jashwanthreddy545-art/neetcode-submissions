class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while (!(pq.size() == 1 || pq.size()==0)){
            int h1 = pq.poll();
            int h2 = pq.poll();
            int result = Math.abs(h2-h1);
            if (result != 0){
                pq.offer(result);
            }
        }

        if (pq.size()==1){
            return pq.peek();
        } else {
            return 0;
        }

    }
}
