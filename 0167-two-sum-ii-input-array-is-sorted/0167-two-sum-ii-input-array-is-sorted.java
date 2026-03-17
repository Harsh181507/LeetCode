class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int n = numbers.length;
        for(int i=0;i<n;i++){
            int req = target - numbers[i];
            if(hm.containsKey(req)){
                int [] arr = {hm.get(req+1),i+1};

                return arr;
            }
            hm.put(numbers[i], i);
        }
        return null;
    }
}