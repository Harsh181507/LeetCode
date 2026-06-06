import java.util.*;

class Pair {
    int first;
    String second;

    Pair(int f, String s) {
        first = f;
        second = s;
    }
}

class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.first != b.first)
                    return a.first - b.first;      // Min frequency

                return b.second.compareTo(a.second); // Max word
            }
        );

        HashMap<String, Integer> freq = new HashMap<>();

        for(int i = 0; i < n; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : freq.entrySet()) {

            String word = entry.getKey();
            int frequency = entry.getValue();

            Pair curr = new Pair(frequency, word);

            if(pq.size() < k) {
                pq.add(curr);
                continue;
            }

            if(curr.first > pq.peek().first ||
               (curr.first == pq.peek().first &&
                curr.second.compareTo(pq.peek().second) < 0))
            {
                pq.poll();
                pq.add(curr);
            }
        }

        LinkedList<String> res = new LinkedList<>();

        while(!pq.isEmpty()) {
            res.addFirst(pq.poll().second);
        }

        return res;
    }
}