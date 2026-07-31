package Graph.Problems.Directed_Graph;
// Alien Dictionary
//
// Given words sorted according to an
// unknown alphabet, determine one
// possible ordering of the characters.
//
// Algorithm:
// 1. Compare every adjacent pair of words.
// 2. Find the first differing character.
// 3. Create a directed edge:
//      firstChar -> secondChar
// 4. Perform Topological Sort (Kahn's Algorithm).
// 5. If a cycle exists or an invalid prefix
//    ordering is found, return "".
//
// Time Complexity : O(Total Characters + V + E)
//
// Space Complexity : O(V + E)

import java.util.*;

public class Alien_Dictionary {
    List<Integer> topoSort(int V,List<List<Integer>> adjList) {
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int it:adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        return ans;
    }
    public String findOrder(String[] words) {
        List<List<Integer>> lt=new ArrayList<>();
        int uniqueCnt=0;
        for(int i=0;i<26;i++){
            lt.add(new ArrayList<>());
        }
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()){
                if(!present[c-'a']){
                    present[c-'a'] = true;
                    uniqueCnt++;
                }

            }
        }
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            int len=Math.min(s1.length(),s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    lt.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> topo=topoSort(26,lt);
        String ans="";
        for(int n:topo){
            if(present[n])
                ans=ans+(char)(n+(int)'a');
        }
        if(ans.length()<uniqueCnt)
            return "";
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Alien_Dictionary ob = new Alien_Dictionary();
        String words[]={"baa","abcd","abca","cab","cad"};
        String ans=ob.findOrder(words);
        if(!ans.isEmpty()){
            System.out.println("The Alien Dictionary contains the following words: "+ans);
        }
        else{
            System.out.println("No Alien Dictionary is considered.");
        }
    }
}
