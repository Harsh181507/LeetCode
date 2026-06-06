class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n= nums.length;
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.getKey() != b.getKey()){
                    return a.getKey() - b.getKey();
                }
                return a.getValue().compareTo(b.getValue());
            }
        );
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i =0; i<n;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);

        }
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            int element = entry.getKey();
            int frequency = entry.getValue();

            Pair<Integer,Integer> curr = new Pair<>(frequency,element);
            if(pq.size() < k){
                pq.add(curr);
                continue;
            }
            else if(curr.getKey() > pq.peek().getKey()){
                pq.poll();
                pq.add(curr);
            }
            
        }
        int [] res = new int[k];
        int idx =0;
        while(!pq.isEmpty()){
            res[idx++] = pq.poll().getValue();
        }
        return res;
    }
    
}