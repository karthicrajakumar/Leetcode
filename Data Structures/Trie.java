class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
    boolean isLeaf;
    public TrieNode(){

    }

    public TrieNode(char x){
        this.c = x;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t;

        for(int i =0 ; i  < word.length(); i++){

            if(children.containsKey(word.charAt(i))){
                t = children.get(word.charAt(i));
            }else{
                t = new TrieNode(word.charAt(i));
                children.put(word.charAt(i), t);
            }
            children = t.children;
            if( i == word.length() -1 ){
                t.isLeaf = true;
            }
        }


    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = s(word);
        if( t != null && t.isLeaf == true)
            return true;
        return false;
    }
    public TrieNode s(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t= null;

        for(int i =0 ;i < word.length() ; i++){
            char c= word.charAt(i);
            if(children.containsKey(c))
            {
                t = children.get(c);
                children = t.children;

            }else
                return null;
        }
        return t;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       TrieNode t = s(prefix);
        if(t != null )
            return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
