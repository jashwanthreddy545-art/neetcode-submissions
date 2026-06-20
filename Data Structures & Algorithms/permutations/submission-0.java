class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, result, new ArrayList<>(), used);
        return result;
    }

    public void backTracking(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used){
        if (current.size()==nums.length){
            result.add(new ArrayList<>(current));
        }
        for (int i=0; i<nums.length; i++){
            if (used[i]){
                continue;
            }
            current.add(nums[i]);
            used[i]=true;
            backTracking(nums, result,current,used);

            current.remove(current.size()-1);
            used[i]= false;
        }
    }
}
