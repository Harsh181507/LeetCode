class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for(int i=0; i< ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            need.put(ch, need.getOrDefault(ch,0)+1);
        }
        for(int i=0; i<magazine.length(); i++){
            char ch = magazine.charAt(i);
            have.put(ch, have.getOrDefault(ch,0)+1);
        }
        return test(have, need);
    }
    public boolean test(HashMap<Character, Integer> have, HashMap<Character, Integer> need){
        for(Map.Entry<Character, Integer> entry : need.entrySet()){
            char ch = entry.getKey();
            int fneed = entry.getValue();

            int fhave = have.getOrDefault(ch, 0);
            if(fhave < fneed){
                return false;
            }
        }
        
        return true;
    }
}