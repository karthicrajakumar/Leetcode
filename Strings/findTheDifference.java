// Given two strings s and t which consist of only lowercase letters.

// String t is generated by random shuffling string s and then add one more letter at a random position.
// Find the letter that was added in t.

// Example:

// Input:
// s = "abcd"
// t = "abcde"

// Output:
// e

// Explanation:
// 'e' is the letter that was added.

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        for(int i =0 ; i< t.length() ; i++){
            char x= t.charAt(i);
            if(map.containsKey(x)){
                if(map.get(x) == 0)
                    return x;
                else
                    map.put(x, map.get(x) -1);
            }else
                return x;

        }
        return 'j';
    }
}
