package OOPS.Wrapper_Class;

class Wrapper_Comparison {
    public static void main(String[] args) {

        //Constants
        System.out.println("\nInteger.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE: " + Integer.SIZE + " bits");


        //Character functions
        char ch = 'A';
        System.out.println("\nCharacter.isLetter('A'): "+Character.isLetter(ch));
        System.out.println("Character.isDigit('5'): "+Character.isDigit('5'));
        System.out.println("Character.isUpperCase('A'): "+Character.isUpperCase(ch));
        System.out.println("Character.toLowerCase('A'): "+Character.toLowerCase(ch));
        System.out.println("Character.toUpperCase('a'): "+Character.toUpperCase('a'));
        System.out.println("Character.isLowerCase('a'): " +Character.isLowerCase('a'));
        System.out.println("Character.isWhitespace(' '): " +Character.isWhitespace(' '));
        System.out.println("\nCharacter.getNumericValue('7'): "+Character.getNumericValue('7'));


        //Object comparison
        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;

        System.out.println("\n100 == 100: " + (a == b));        //true
        System.out.println("100 equals 100: " + a.equals(b));   //true

        System.out.println("200 == 200: " + (c == d));          //false        //Integer caching range: -128 to 127
        System.out.println("200 equals 200: " + c.equals(d));   //true


        Integer x = new Integer(50);
        Integer y = new Integer(50);

        System.out.println(x == y);                      //false        //new Integer() creates new objects for both
        System.out.println(x.equals(y));                 //true


        //comapare(): object value comaprison
        System.out.println("\nInteger.compare(10, 20): "+Integer.compare(10, 20));  //return -1 : smaller
        System.out.println("Integer.compare(20, 10): "+Integer.compare(20, 10));    //return 1: greater
        System.out.println("Integer.compare(10, 10): "+Integer.compare(10, 10));    //return 0: equal

        // compare() and compareTo()
        System.out.println("\nInteger.compare(10, 20): "+Integer.compare(10, 20));
        System.out.println("Integer.compare(20, 10): " +Integer.compare(20, 10));
        System.out.println("Integer.compare(10, 10): " +Integer.compare(10, 10));
        System.out.println("\n10.compareTo(20): " +Integer.valueOf(10).compareTo(20));  //have to compare with object
        System.out.println("20.compareTo(10): " +Integer.valueOf(20).compareTo(10));
        System.out.println("10.compareTo(10): "+Integer.valueOf(10).compareTo(10));

        //String comparison
        String str1 = Integer.toString(123);
        String str2 = String.valueOf(456);
        System.out.println("\nInteger.toString(): " + str1);
        System.out.println("String.valueOf(): " + str2);



        // Boolean Wrapper Methods
        System.out.println("\nBoolean.logicalAnd(true, false): " +Boolean.logicalAnd(true, false));
        System.out.println("Boolean.logicalOr(true, false): "+Boolean.logicalOr(true, false));
        System.out.println("Boolean.logicalXor(true, false): "+Boolean.logicalXor(true, false));


        // Numeric Wrapper Conversion
        Integer t = 65;
        System.out.println("\nbyteValue(): " + t.byteValue());
        System.out.println("shortValue(): " + t.shortValue());
        System.out.println("longValue(): " + t.longValue());
        System.out.println("floatValue(): " + t.floatValue());
        System.out.println("doubleValue(): " + t.doubleValue());


    }
}
