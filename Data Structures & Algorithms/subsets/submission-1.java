class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        dp(result, 0, nums);
        return result;
    }

    private void dp (List<List<Integer>> result, int index, int[] nums){
        if(index==nums.length){
            return;
        }

        List<List<Integer>> subsets = new ArrayList<>();
        for (List<Integer> list : result){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(nums[index]);
            subsets.add(temp);
        }
        result.addAll(subsets);
        dp(result, index+1, nums);
    }
}
