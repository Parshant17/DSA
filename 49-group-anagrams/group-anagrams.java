class Solution {
   /*  boolean isAnagram(String first ,String second){
       if(first.length()!= second.length()){
            return false;
        }
        char []x = first.toCharArray();
        char []y = second.toCharArray();
         Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x,y);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> bigList= new ArrayList<>();
       for (String word : strs){
        boolean added = false;
        for(List<String>smallList: bigList){
            if(isAnagram(smallList.get(0),word)){
                smallList.add(word);
                added = true;
                break ;
            }
        }
        if(!added){
            List<String> newSmallList = new ArrayList<>();
            newSmallList.add(word);
            bigList.add(newSmallList);
        }
       } 
       return bigList;*/
         public List<List<String>> groupAnagrams(String[] strs) {
            Map<String , List<String>> map = new HashMap<>();
            for(String word: strs){
                 int countArr[]= new int[26];
                for(char c : word.toCharArray()){
                  countArr[c-'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for(int k : countArr){
                    sb.append(k).append('#');
                }
                String key = sb.toString();
                map.computeIfAbsent (key , k->new ArrayList<>()).add(word);
            }
            return new ArrayList<>(map.values());
         }
}