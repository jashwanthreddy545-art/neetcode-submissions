class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sbCount = new StringBuilder();
        StringBuilder sbString = new StringBuilder();
        List<String> list = new ArrayList();
        char[] chars = str.toCharArray();
        int i =0;
        while (i<chars.length){
            while (chars[i]!='#'){
                sbCount.append(chars[i]);
                i++;
            }
            int j = i+1;
            int end = j + Integer.parseInt(sbCount.toString());

            while(j<end){
                sbString.append(chars[j]);
                j++;
            }
            list.add(sbString.toString());
            i=j;
            sbCount.setLength(0);
            sbString.setLength(0);
        }
        return list;
    }
}
