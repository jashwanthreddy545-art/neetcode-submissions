class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> startOfSeq = new HashSet<>();
        Set<Integer> numsSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numsSet.add(nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(!numsSet.contains(nums[i]-1)){
                startOfSeq.add(nums[i]);
            }
        }
        int maxSubSeq = 0;
        int count = 0;
        for(int i : startOfSeq){
            while(numsSet.contains(i)){
                count++;
                maxSubSeq = Math.max(maxSubSeq, count);
                i++;
            } 
            count =0;
        }
        return maxSubSeq;
    }
}
