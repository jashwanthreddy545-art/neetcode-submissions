class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "");
        int start = 0;
        int end = cleaned.length() - 1;
        while (start <= end) {
            if (Character.toLowerCase(cleaned.charAt(start)) != Character.toLowerCase(cleaned.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
