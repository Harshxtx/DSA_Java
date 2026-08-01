package Graph.Problems.Shortest_Path;
// Word Ladder I
//
// Given a begin word and an end word,
// find the minimum number of transformations.
//
// Rules:
// • Change only one character at a time.
// • Every intermediate word must exist
//   in the dictionary.
//
// Algorithm:
// 1. Store all words in a HashSet.
// 2. Start BFS from beginWord.
// 3. Generate all possible one-letter changes.
// 4. Visit every valid unvisited word.
// 5. The first time endWord is reached,
//    its level is the answer.
//
// Time Complexity : O(N × L × 26)
//
// N = number of words
// L = length of each word
//
// Space Complexity : O(N)
//
// Applications:
// • Shortest Path in Implicit Graph
// • String Transformation Problems
// • BFS on States

import java.util.*;

public class Word_Ladder_I {
    class Pair{
        String word;
        int step;
        Pair(String word,int step){
            this.word=word;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new ArrayDeque<>();
        q.add(new Pair(beginWord,1));
        Set<String> hs=new HashSet<>();
        for(String word:wordList){
            hs.add(word);
        }
        hs.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.word;
            int steps=curr.step;
            if(word.equals(endWord))
                return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char temp[]=word.toCharArray();
                    temp[i]=ch;
                    String newWord=new String(temp);
                    if(hs.contains(newWord)){
                        hs.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Word_Ladder_I ob = new Word_Ladder_I();
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int steps=ob.ladderLength(beginWord,endWord,wordList);
        if(steps!=0)
            System.out.println("Minimum steps to convert '"+beginWord+"' to '"+endWord+"' is "+steps);
        else
            System.out.println("Not possible");
    }
}
