package ArrayList;

import java.util.*;

public class ArrayList_Methods {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        // 2. add(E e)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("After add(): " + list);

        // 3. add(int index, E element)
        list.add(1, 15);
        System.out.println("After add(index, element): " + list);

        // 4. get(int index)
        System.out.println("Element at index 2: " + list.get(2));

        // 5. set(int index, E element)
        list.set(2, 25);
        System.out.println("After set(): " + list);

        // 6. size()
        System.out.println("Size: " + list.size());

        // 7. contains(Object o)
        System.out.println("Contains 30? " + list.contains(30));

        // 8. indexOf(Object o)
        System.out.println("Index of 30: " + list.indexOf(30));

        // 9. lastIndexOf(Object o)
        list.add(30);
        System.out.println("After adding another 30: " + list);
        System.out.println("Last Index of 30: " + list.lastIndexOf(30));

        // 10. remove(int index)
        list.remove(1);
        System.out.println("After remove(index): " + list);

        // 11. remove(Object o)
        list.remove(Integer.valueOf(30));
        System.out.println("After remove(object): " + list);

        // 12. isEmpty()
        System.out.println("Is Empty? " + list.isEmpty());

        // 13. clone()
        @SuppressWarnings("unchecked")
        ArrayList<Integer> clonedList =
                (ArrayList<Integer>) list.clone();
        System.out.println("Cloned List: " + clonedList);

        // 14. addAll(Collection)
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);

        list.addAll(list2);
        System.out.println("After addAll(): " + list);

        // 15. addAll(int index, Collection)
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(50);
        list3.add(60);

        list.addAll(2, list3);
        System.out.println("After addAll(index, collection): " + list);

        // 16. removeAll(Collection)
        list.removeAll(list2);
        System.out.println("After removeAll(): " + list);

        // 17. retainAll(Collection)
        ArrayList<Integer> retainList = new ArrayList<>();
        retainList.add(10);
        retainList.add(50);

        list.retainAll(retainList);
        System.out.println("After retainAll(): " + list);

        // 18. clear()
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);

        temp.clear();
        System.out.println("After clear(): " + temp);

        // 19. toArray()
        Object[] arr = list.toArray();

        System.out.print("toArray(): ");
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // 20. sort()
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        Collections.sort(numbers);
        System.out.println("After sort(): " + numbers);

        // 21. reverse()
        Collections.reverse(numbers);
        System.out.println("After reverse(): " + numbers);

        // 22. shuffle()
        Collections.shuffle(numbers);
        System.out.println("After shuffle(): " + numbers);

        // 23. min() and max()
        System.out.println("Minimum: " + Collections.min(numbers));
        System.out.println("Maximum: " + Collections.max(numbers));

        // 24. forEach()
        System.out.print("forEach(): ");
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();

        //Or 24.forEach Loop
//        for (Integer n : numbers) {
//            System.out.println(n);
//        }
    }
}
