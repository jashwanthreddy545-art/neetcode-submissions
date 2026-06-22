class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dp(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void dp(List<List<Integer>> result, int start, List<Integer> current, int[] nums) {
        result.add(new ArrayList<>(current));

        for(int i=start; i<nums.length; i++){
            if (i>start && nums[i-1]==nums[i]){
                continue;
            }
            current.add(nums[i]);
            dp(result, i+1, current, nums);
            current.remove(current.size()-1);
        }
    }
}
