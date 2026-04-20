class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashmap= new HashSet<>();
        for( int i =0; i< nums.length; i++){
            if (!hashmap.contains(nums[i])){
                hashmap.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}