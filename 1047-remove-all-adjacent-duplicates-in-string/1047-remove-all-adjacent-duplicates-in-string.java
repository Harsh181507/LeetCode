class Solution {
    public String removeDuplicates(String s) {
        //ek stack banaya
        //if elements on top and the elemt we are pshngi are not same then push  and if they are same
        //then pop
        //at the end return the stack, the left over elemts are the answer since they odnt exist in pair
        //also given that they must be adjusent to each other.
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!stack.isEmpty() && ch == stack.peek()){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}