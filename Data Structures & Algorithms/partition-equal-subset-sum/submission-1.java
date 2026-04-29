class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return dfs(0, target, nums, memo);
    }

    private boolean dfs(int index, int target, int[] nums, Boolean[][] memo) {
        if (target == 0) return true;
        if (index == nums.length || target < 0) return false;

        if (memo[index][target] != null) return memo[index][target];

        boolean take = dfs(index + 1, target - nums[index], nums, memo);
        boolean skip = dfs(index + 1, target, nums, memo);

        return memo[index][target] = take || skip;
    }
}
