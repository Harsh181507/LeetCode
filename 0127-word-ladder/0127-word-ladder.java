class Pair{
    String first;
    int second;
    Pair(String f,int s){
        first=f;
        second=s;
    }
}
class Solution {
    public int ladderLength(String beginWord,String endWord,List<String> wordList) {
        HashSet<String> f = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            f.add(wordList.get(i));
        }
        if(!f.contains(endWord)){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        f.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.first;
            int val = p.second;
            if(s.equals(endWord)){
                return val;
            }
            char[] arr = s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char old = arr[i];
                for(char ch='a';ch<='z';ch++){
                    if(ch==old){
                        continue;
                    }
                    arr[i]=ch;
                    String next = new String(arr);
                    if(f.contains(next)){
                        q.add(new Pair(next,val+1));
                        f.remove(next);
                    }
                }
                arr[i]=old;
            }
        }
        return 0;
    }
}