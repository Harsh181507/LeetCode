class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        PriorityQueue<Pair<Integer, String>> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getKey().equals(b.getKey())) {
                    return a.getKey() - b.getKey();
                }
                return b.getValue().compareTo(a.getValue()); 
            }
        );

        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {

            String word = entry.getKey();
            int frequency = entry.getValue();

            Pair<Integer, String> curr =
                new Pair<>(frequency, word);

            if (pq.size() < k) {
                pq.add(curr);
                continue;
            }

            Pair<Integer, String> top = pq.peek();

            if (curr.getKey() > top.getKey()
                || (curr.getKey().equals(top.getKey())
                    && curr.getValue().compareTo(top.getValue()) < 0)) {

                pq.poll();
                pq.add(curr);
            }
        }

        LinkedList<String> res = new LinkedList<>();

        while (!pq.isEmpty()) {
            res.addFirst(pq.poll().getValue());
        }

        return res;
    }
}