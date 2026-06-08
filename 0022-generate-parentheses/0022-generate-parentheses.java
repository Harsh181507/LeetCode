class Solution {

    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();

        fun(0, 0, n, new StringBuilder(), res);

        return res;
    }
    public void fun(int open, int close, int n,StringBuilder temp,ArrayList<String> res) {

        if(open == n && close == n){
            res.add(temp.toString());
            return;
        }

        if(open < n){
            temp.append('(');
            fun(open + 1, close, n, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
        if(close < open){
            temp.append(')');
            fun(open, close + 1, n, temp, res);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}