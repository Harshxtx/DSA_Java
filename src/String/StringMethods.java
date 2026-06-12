package String;

import java.util.*;

public class StringMethods {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String str = "  Java Programming  ";
        String str2 = "java programming";
        String str3 = "Java";

        // 1. length()
        System.out.println("Length: " + str.length());

        // 2. charAt()
        System.out.println("Character at index 2: " + str.charAt(2));

        // 3. substring()
        System.out.println("Substring (2, 6): " + str.substring(2, 6));

        // 4. concat()
        System.out.println("Concatenation: " + str3.concat(" DSA"));

        // 5. equals()
        System.out.println("Equals: " + str3.equals("Java"));

        // 6. equalsIgnoreCase()
        System.out.println("Equals Ignore Case: " + str.equalsIgnoreCase(str2));

        // 7. compareTo()
        System.out.println("CompareTo: " + str3.compareTo("Python"));

        // 8. compareToIgnoreCase()
        System.out.println("CompareTo Ignore Case: " + str3.compareToIgnoreCase("java"));

        // 9. indexOf()
        System.out.println("Index of 'a': " + str.indexOf('a'));

        // 10. lastIndexOf()
        System.out.println("Last Index of 'a': " + str.lastIndexOf('a'));

        // 11. contains()
        System.out.println("Contains 'Program': " + str.contains("Program"));

        // 12. startsWith()
        System.out.println("Starts With '  Ja': " + str.startsWith("  Ja"));

        // 13. endsWith()
        System.out.println("Ends With 'ng  ': " + str.endsWith("ng  "));

        // 14. toUpperCase()
        System.out.println("Uppercase: " + str.toUpperCase());

        // 15. toLowerCase()
        System.out.println("Lowercase: " + str.toLowerCase());

        // 16. trim()
        System.out.println("Trim: '" + str.trim() + "'");

        // 17. replace()
        System.out.println("Replace: " + str.replace('a', 'o'));

        // 18. replaceAll()
        System.out.println("ReplaceAll: " + str.replaceAll("a", "@"));

        // 19. replaceFirst()
        System.out.println("ReplaceFirst: " + str.replaceFirst("a", "@"));

        // 20. isEmpty()
        System.out.println("Is Empty: " + "".isEmpty());

        // 21. isBlank() (Java 11+)
        System.out.println("Is Blank: " + "   ".isBlank());

        // 22. toCharArray()
        char[] arr = str3.toCharArray();
        System.out.print("toCharArray(): ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 23. split()
        String sentence = "Java,is,fun";
        String[] words = sentence.split(",");
        System.out.println("Split:");
        for (String word : words) {
            System.out.println(word);
        }

        // 24. valueOf()
        int num = 100;
        String converted = String.valueOf(num);
        System.out.println("String Value: " + converted);

        // 25. repeat() (Java 11+)
        System.out.println("Repeat: " + "Hi ".repeat(3));

        // 26. intern()
        String s1 = new String("Hello");
        String s2 = s1.intern();
        System.out.println("Intern: " + (s2 == "Hello"));
    }
}
