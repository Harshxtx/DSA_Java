package String;

import java.util.*;

public class String_Tokenizer {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String str = "Java,Python,C++,JavaScript";

        // Constructor with custom delimiter
        StringTokenizer st = new StringTokenizer(str, ",");

        // 1. countTokens()
        System.out.println("Number of Tokens: " + st.countTokens());

        // 2. hasMoreTokens() and 3. nextToken()
        System.out.println("\nTokens:");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        // Constructor with returnDelims = true
        StringTokenizer st2 = new StringTokenizer(str, ",", true);

        System.out.println("\nTokens including delimiters:");

        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }

        // nextToken(String delimiter)
        String str2 = "Java-Python:C++";
        StringTokenizer st3 = new StringTokenizer(str2, "-");

        System.out.println("\nUsing nextToken(String delim):");

        System.out.println(st3.nextToken());   // Java

        // Change delimiter from "-" to ":"
        System.out.println(st3.nextToken(":"));
    }
}
