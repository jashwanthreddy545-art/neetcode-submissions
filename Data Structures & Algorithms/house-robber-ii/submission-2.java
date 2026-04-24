class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
    }

    private int rob(int[] nums, int start, int end){
        if(nums.length==1){
            return nums[start];

        }
        int[] dp = new int[end+1];
        dp[start]= nums[start];
        dp[start+1]= Math.max(nums[start+1], nums[start]);

        for(int i= start+2; i<=end; i++){
            dp[i]=Math.max(dp[i-1],(dp[i-2]+nums[i]));
        }
        return dp[end];
    }
}
