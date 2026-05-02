class Solution {
    public int maxArea(int[] heights) {
        int p1 = 0;
        int p2 = heights.length-1;
        int max = -1;
        while (p1 < p2) {
            int h1 = heights[p1];
            int h2 = heights[p2]; 
            int area = Math.min(h1, h2) * (p2 - p1);
            max = Math.max(area, max);
            if (h1 > h2) {
                p2--;
            }
            if (h2 >= h1) {
                p1++;
            }
        }
        return max;
    }
}
