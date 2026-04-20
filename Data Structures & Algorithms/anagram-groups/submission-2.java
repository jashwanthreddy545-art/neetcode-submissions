class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        for(String s : strs){
            Map<Character,Integer> freq = getCharFrequency(s);
            if(anagrams.containsKey(freq)){
                anagrams.get(freq).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                anagrams.put(freq, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : anagrams.values()){
            result.add(list);
        }
        return result;
    }

    private Map<Character,Integer> getCharFrequency(String s){
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        return freq;
    }
}
