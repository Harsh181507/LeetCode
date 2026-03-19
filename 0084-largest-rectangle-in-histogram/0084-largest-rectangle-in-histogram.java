import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxHeight = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<=n;i++){
            int currentHeight;
            if(i ==  n){
                currentHeight=0;
            }else{
                currentHeight=heights[i];
            }

            while(!stack.isEmpty() && currentHeight < heights [stack.peek()]){
                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width =i;
                }else{
                    width = i - stack.peek() - 1;
                }
                maxHeight = Math.max(maxHeight, height * width);
            }
            stack.push(i);

        }
        return maxHeight;
    }
}
