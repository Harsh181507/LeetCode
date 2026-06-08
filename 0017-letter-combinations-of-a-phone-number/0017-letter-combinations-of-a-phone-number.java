class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");
        int n = digits.length();
        
        ArrayList<String> res = new ArrayList<>();
        fun(digits,n,0,new StringBuilder(),res,digitToLetters);
        return res;

    }

    public void fun(String digits, int n, int idx, StringBuilder diary,ArrayList <String> res,HashMap<Character,String> digitToLetters){
        if(idx == n){
            res.add(diary.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String choice = digitToLetters.get(digit);
        for(int j =0;j<choice.length();j++){
            diary.append(choice.charAt(j));
            fun(digits,n,idx+1,diary,res,digitToLetters);
            diary.deleteCharAt(diary.length()-1);
        }
        return;
    }
}