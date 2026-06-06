import java.util.*;

class Pair{
    int first;
    char second;

    Pair(int f, char s){
        first = f;
        second = s;
    }
}

class Solution {

    public String reorganizeString(String s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.first != b.first){
                    return b.first - a.first; // Max frequency
                }
                return b.second - a.second;
            }
        );

        HashMap<Character,Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : freq.entrySet()){

            char ch = entry.getKey();
            int frequency = entry.getValue();

            pq.add(new Pair(frequency, ch));
        }

        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()){

            Pair p = pq.poll();

            if(res.length() == 0 ||
               res.charAt(res.length() - 1) != p.second){

                res.append(p.second);

                p.first--;

                if(p.first > 0){
                    pq.add(p);
                }
            }
            else{

                if(pq.isEmpty()){
                    return "";
                }

                Pair p2 = pq.poll();

                res.append(p2.second);

                p2.first--;

                if(p2.first > 0){
                    pq.add(p2);
                }

                pq.add(p);
            }
        }

        return res.toString();
    }
}