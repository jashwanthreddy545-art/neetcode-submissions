class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Combine both arrays
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = speed[i]; // speed
        }

        // Sort by position
        Arrays.sort(cars, Comparator.comparingInt(a -> a[0]));

        // Put back into original arrays
        for (int i = 0; i < n; i++) {
            position[i] = cars[i][0];
            speed[i] = cars[i][1];
        }
        Stack<Double> fleet = new Stack<>();
        for (int i=n-1; i>=0; i--){
            double duration = (double)(target - position[i])/speed[i];
            if (fleet.isEmpty() || fleet.peek()< duration){
                fleet.push(duration);
            }
        }
        return fleet.size();
    }
}
