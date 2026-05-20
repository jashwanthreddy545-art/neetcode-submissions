class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        int[] result = new int[temperatures.length];
        int i = 0;
        while (i<temperatures.length){
            if(tempStack.isEmpty() || tempStack.peek()>= temperatures[i]){
                indexStack.push(i);
                tempStack.push(temperatures[i]);
                i++;
            } else {
                int index = indexStack.pop();
                result[index] = i-index;
                tempStack.pop();
            }
        }
        return result;
    }
}
