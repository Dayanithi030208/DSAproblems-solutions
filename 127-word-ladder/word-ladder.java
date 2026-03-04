class Pair{
    String word ;
    int steps ;
    Pair ( String word , int steps ){
        this.word = word ;
        this.steps = steps ;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for (int i = 0 ; i < n ; i++){
            set.add(wordList.get(i));
        }
        if(set.contains(beginWord)) set.remove(beginWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord , 1));
        while ( !queue.isEmpty() ){
            String word = queue.peek().word;
            int steps = queue.peek().steps;
            queue.poll();
            if (endWord.equals (word)) return steps;
            for (int i = 0 ; i < word.length() ; i++){
                for (char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] replacedcharArr = word.toCharArray();
                    replacedcharArr[i] = ch;
                    String replacedStr = new String(replacedcharArr);
                    if(set.contains(replacedStr)){
                        set.remove(replacedStr);
                        queue.offer(new Pair (replacedStr, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}