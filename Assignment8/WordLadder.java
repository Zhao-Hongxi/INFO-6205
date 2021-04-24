package Assignment8;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] s = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(s);
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Map<String,List<String>> map = new HashMap<>();
        for(String s1: wordList){
            if(isValid(beginWord,s1)){
                if(!map.containsKey(beginWord)){
                    List<String> l = new ArrayList<>();
                    l.add(s1);
                    map.put(beginWord,l);
                }
                else{
                    List<String> l = map.get(beginWord);
                    l.add(s1);
                    map.put(beginWord,l);
                }
            }
            if(isValid(s1,endWord)){
                if(!map.containsKey(s1)){
                    List<String> l = new ArrayList<>();
                    l.add(endWord);
                    map.put(s1,l);
                }
                else{
                    List<String> l = map.get(s1);
                    l.add(endWord);
                    map.put(s1,l);
                }
            }
            for(String s2: wordList){
                if(!s1.equals(s2)){
                    if(isValid(s1,s2)){
                        if(!map.containsKey(s1)){
                            List<String> l = new ArrayList<>();
                            l.add(s2);
                            map.put(s1,l);
                        }
                        else{
                            List<String> l = map.get(s1);
                            l.add(s2);
                            map.put(s1,l);
                        }
                    }
                }
            }
        }
        Queue<String> q = new LinkedList<>();
        if(!map.containsKey(beginWord))
            return 0;
        q.offer(beginWord);
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                String cur = q.poll();
                if(cur.compareTo(endWord) == 0)
                    return step+1;
                for(String s: map.get(cur)){
                    if(!visited.contains(s)){
                        q.offer(s);
                        visited.add(s);
                    }

                }
                size--;
            }
            step++;
        }
        return 0;
    }
    static boolean isValid(String s1, String s2){
        int l = 0;
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i))
                l++;
        }
        return l == s1.length() - 1;
    }
}
