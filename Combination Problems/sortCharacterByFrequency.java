// Given a string, sort it in decreasing order based on the frequency of characters.

//Example 1:

//Input:
//"tree"

//Output:
//"eert"

//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

// Combination of Priority Queue and HashMap. 

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i =0 ;i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue() );

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.offer(e);

        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() != 0){
            Map.Entry<Character,Integer> e = pq.poll();
            for(int i =0 ; i < e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
