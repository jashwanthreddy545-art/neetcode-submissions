class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        if (map.containsKey(s.charAt(0))) {
            stack.push(s.charAt(0));
        } else {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()).equals(s.charAt(i))) {
                stack.pop();
            } else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
