class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            numToIndex.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int num = target - nums[i];
            if (numToIndex.containsKey(num) && numToIndex.get(num)!= i){
                int[] result = new int[2];
                result[0] = i;
                result[1] = numToIndex.get(num);
                Arrays.sort(result);
                return result;
            }
            
        }
        return null;
    }
}
