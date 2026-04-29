class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1=0;
        int p2=1;
        while(p1<p2 && p1<numbers.length-1){
            int toFind = target-numbers[p1];
            if(numbers[p2]==toFind){
                return new int[]{p1+1, p2+1};
            }
            else if(numbers[p2]>toFind){
                p1++;
                p2=p1+1;
            }else{
                p2++;
            }

            if(p2==numbers.length){
                p1++;
                p2=p1+1;
            }
        }
        return new int[2];
    }
}
