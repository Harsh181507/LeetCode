class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for(int i=0 ;i<n; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new Pair <>(ch,1));
                continue;
            }
            if(stack.peek().getKey() !=ch){
                stack.push(new Pair<>(ch,1));
            }else{
                Pair<Character, Integer> p = stack.peek();
                stack.pop();
                if(p.getValue() < k - 1) {
                    stack.push(new Pair<>(ch, p.getValue() + 1));
                }
            }
            
        }
            StringBuilder res = new StringBuilder();
            while(!stack.isEmpty()){
                Pair<Character,Integer> p = stack.peek();
                stack.pop();

                for(int j =0;j<p.getValue() ;j++){
                    res.append(p.getKey());
                }
            }
            return res.reverse().toString();
            
        
    }
}