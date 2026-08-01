package Graph.Problems.Shortest_Path;

import java.util.*;

public class Word_Ladder_II {
     // 1st Method: BFS only
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> hs=new HashSet<>();
//        for(String word:wordList){
//            hs.add(word);
//        }
//        Queue<ArrayList<String>> q=new LinkedList<>();
//        ArrayList<String> lt=new ArrayList<>();
//        lt.add(beginWord);
//        q.add(lt);
//        ArrayList<String> lvl=new ArrayList<>();
//        lvl.add(beginWord);
//        int level=0;
//        List<List<String>> ans=new ArrayList<>();
//        while(!q.isEmpty()){
//            ArrayList<String> vec=q.poll();
//            if(vec.size()>level){
//                level++;
//                for(String st:lvl){
//                    hs.remove(st);
//                }
//            }
//            String word=vec.get(vec.size()-1);
//            if(word.equals(endWord)){
//                if(ans.size()==0)
//                    ans.add(vec);
//                else if(ans.get(0).size()==vec.size())
//                    ans.add(vec);
//            }
//            for(int i=0;i<word.length();i++){
//                for(char ch='a';ch<='z';ch++){
//                    char temp[]=word.toCharArray();
//                    temp[i]=ch;
//                    String newWord=new String(temp);
//                    if(hs.contains(newWord)){
//                        vec.add(newWord);
//                        ArrayList<String> t=new ArrayList<>(vec);
//                        q.add(t);
//                        lvl.add(newWord);
//                        vec.remove(vec.size()-1);
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    // 2nd Method: BFS + DFS (optimal)
    HashMap<String, Integer> mp;
    List<List<String>> ans;
    String b;
    void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=mp.get(word);
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char temp[]=word.toCharArray();
                temp[i]=ch;
                String newWord=new String(temp);
                if(mp.containsKey(newWord) && mp.get(newWord)+1==steps){
                    seq.add(newWord);
                    dfs(newWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs=new HashSet<>();
        for(String word:wordList){
            hs.add(word);
        }
        b=beginWord;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        mp=new HashMap<>();
        mp.put(beginWord,1);
        hs.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.poll();
            int steps=mp.get(word);
            if(word.equals(endWord))
                break;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char temp[]=word.toCharArray();
                    temp[i]=ch;
                    String newWord=new String(temp);
                    if(hs.contains(newWord)){
                        q.add(newWord);
                        hs.remove(newWord);
                        mp.put(newWord,steps+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(mp.containsKey(endWord)){
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Word_Ladder_II ob = new Word_Ladder_II();
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> ans=ob.findLadders(beginWord, endWord, wordList);
        if(!ans.isEmpty()) {
            System.out.println(ans);
        }
        else
            System.out.println("No path exists");
    }
}
