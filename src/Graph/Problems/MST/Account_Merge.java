package Graph.Problems.MST;

import java.util.*;

public class Account_Merge {
    int[] parent;
    int[] size;
    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }
    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int V=accounts.size();
        parent = new int[V];
        size = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<V;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    unionBySize(i,map.get(mail));
                }
            }
        }
        List<String>[] mergedMail=new ArrayList[V];
        for(int i=0;i<V;i++){
            mergedMail[i]=new ArrayList<>();
        }
        for(Map.Entry<String, Integer> it:map.entrySet()){
            String mail=it.getKey();
            int par=findParent(it.getValue());
            mergedMail[par].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mergedMail[i].isEmpty())
                continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String st:mergedMail[i]){
                temp.add(st);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Account_Merge ob = new Account_Merge();
        List<List<String>> accounts = List.of(
                List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        List<List<String>> mergedMail=ob.accountsMerge(accounts);
        for(List<String> st:mergedMail) {
            System.out.println(st);
        }
    }
}
