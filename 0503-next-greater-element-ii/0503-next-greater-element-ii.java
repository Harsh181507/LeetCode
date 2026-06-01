class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] res = new int[nums.length];
        res[n-1] = -1;
        Stack <Integer> stack = new Stack<>();
        stack.push(nums[n-1]);

        for(int i=2 * n-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i % n]){
                stack.pop();
                
            }
            if(i < n){
                if(stack.empty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i % n]);
        }
        return res;
    }
}