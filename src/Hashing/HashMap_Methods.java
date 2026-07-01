package Hashing;

import java.util.*;

public class HashMap_Methods {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        HashMap<Integer, String> map=new HashMap<>();     //<K,V>

        //Insert (insertion order is not retain)    //no guaranteed order   // O(1) average
        map.put(3, "Harshit");                      //update and insert both
        map.put(2, "Tanishq");
        map.put(1, "Nickel");

        System.out.println("HashMap: ");
        System.out.println(map);

        // Contains Key                             // O(1) average
        System.out.println("Contains key 3? "+map.containsKey(3));

        // Contains Value                           // O(1) average
        System.out.println("Contains value Tanishq? "+map.containsValue("Tanishq"));

        // Remove by key                            // O(1) average
        map.remove(1);
        System.out.println("After Removing key 1:");
        System.out.println(map);

        //remove()      //remove only if both matches       // O(1) average
        map.remove(2, "Harshit");
        System.out.println("After trying to remove key 2 with value 'Harshit' :"+map);

        // Size                                         // O(1) average
        System.out.println("Size: "+map.size());

        // Empty Check
        System.out.println("Is Empty: "+ map.isEmpty());

        // Traversing using keySet()        //will only give keys       // O(n)
        System.out.println("\nTraversal using keySet():");
        for(Integer key : map.keySet()) {
            System.out.println(key+" -> "+map.get(key));
        }

        // Traversing using entrySet()       //will give key and value both // O(n)
        System.out.println("\nTraversal using entrySet():");
        for(Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey()+" -> "+e.getValue());
        }

        // getOrDefault()
        System.out.print("getOrDefault at 2:");
        System.out.println(map.getOrDefault(2,"Not Found"));
        System.out.print("getOrDefault at 5:");
        System.out.println(map.getOrDefault(5,"Not Found"));

        // putIfAbsent()
        map.putIfAbsent(3, "Karan");
        map.putIfAbsent(4, "Karan");
        System.out.println("After putIfAbsent:");
        System.out.println(map);

        System.out.println("Adding the key 1 again:");
        map.put(1, "Rohit");
        System.out.println(map);

        //replace(key,value)                        //Only works if key exists
        map.replace(1, "Nickel");                   //update only
        System.out.println("After replacing first element: "+map);

        //replace(key, oldValue, newValue)         //Replaces only if old value matches
        map.replace(4, "Karan", "Abhi");
        System.out.println("After replacing fourth element : "+map);

        //keySet()           //Returns all keys
        System.out.println("All the keys in the list: "+map.keySet());

        //values()           //Returns all values
        System.out.println("All the values in the list: "+map.values());

        //entrySet()         //Returns complete entries
        System.out.println(map.entrySet());

        // Clear                    // O(1) average
        map.clear();
        System.out.println("\nAfter clear():");
        System.out.println(map);
        //System.out.println(map);


        //frequency counter
        //map.put(value, map.getOrDefault(value, 0) + 1);
    }
}
