class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> keypad = new HashMap<>();
        keypad.put(2, Arrays.asList('a', 'b', 'c'));
        keypad.put(3, Arrays.asList('d', 'e', 'f'));
        keypad.put(4, Arrays.asList('g', 'h', 'i'));
        keypad.put(5, Arrays.asList('j', 'k', 'l'));
        keypad.put(6, Arrays.asList('m', 'n', 'o'));
        keypad.put(7, Arrays.asList('p', 'q', 'r', 's'));
        keypad.put(8, Arrays.asList('t', 'u', 'v'));
        keypad.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        List<String> words = new ArrayList<>();
        if(digits.isEmpty()){
            return words;
        }
        backtracking(words, digits, "", 0, keypad);
        return words;
    }

    private void backtracking(List<String> words, String digits, String current, int index, Map<Integer, List<Character>> keypad) {
        if (current.length() == digits.length()) {
            words.add(current);
            return;
        }
        List<Character> chars = keypad.get(digits.charAt(index) - '0');
        for (int i = 0; i < chars.size(); i++) {
            backtracking(words, digits, current + "" + chars.get(i), index + 1, keypad);
        }
    }
}
