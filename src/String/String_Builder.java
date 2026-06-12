package String;

import java.util.*;
public class String_Builder {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        StringBuilder sb = new StringBuilder("Java");

        // 1. append()
        sb.append(" Programming");
        System.out.println("append(): " + sb);

        // 2. insert()
        sb.insert(5, "DSA ");
        System.out.println("insert(): " + sb);

        // 3. delete()
        sb.delete(5, 9);
        System.out.println("delete(): " + sb);

        // 4. deleteCharAt()
        sb.deleteCharAt(4);
        System.out.println("deleteCharAt(): " + sb);

        // 5. replace()
        sb.replace(0, 4, "Python");
        System.out.println("replace(): " + sb);

        // 6. reverse()
        sb.reverse();
        System.out.println("reverse(): " + sb);

        // Reverse back for further operations
        sb.reverse();

        // 7. charAt()
        System.out.println("charAt(2): " + sb.charAt(2));

        // 8. setCharAt()
        sb.setCharAt(0, 'J');
        System.out.println("setCharAt(): " + sb);

        // 9. length()
        System.out.println("length(): " + sb.length());

        // 10. capacity()
        System.out.println("capacity(): " + sb.capacity());

        // 11. substring()
        System.out.println("substring(0, 4): " + sb.substring(0, 4));

        // 12. toString()
        String str = sb.toString();
        System.out.println("toString(): " + str);
    }
}
