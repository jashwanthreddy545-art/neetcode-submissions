class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.containsKey(0) && map.get(0) >= 3) {
            result.add(List.of(0, 0, 0));
        }
        int firstPositiveIndex = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            }else  {
                firstPositiveIndex = mid;
                right = mid - 1;
            }
        }
        if (firstPositiveIndex == 0 || firstPositiveIndex == -1) {
            return result;
        }
        int p1 = firstPositiveIndex;
        int p2 = firstPositiveIndex - 1;
        while (p1 < nums.length) {
            int p1Value = nums[p1];
            int p2Value = nums[p2];
            int req = -p1Value - p2Value;
            boolean isValid = false;
            if (map.containsKey(req)) {
                isValid = true;
                if (req == p1Value || req == p2Value) {
                    if (map.get(req) < 2) {
                        isValid = false;
                    }
                }
            }
            if (isValid) {
                List<Integer> temp = new ArrayList<>(List.of(p1Value, p2Value, req));
                Collections.sort(temp);
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
            if (p1Value + p2Value >-p1Value ) {
                p2 = p2 - 1;
            }
            if (p1Value + p2Value <= -p1Value || p2 < 0) {
                p1 = p1 + 1;
                p2 = firstPositiveIndex - 1;
            }
        }
        return result;
    }
}
