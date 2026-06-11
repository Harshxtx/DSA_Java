public class Operators {
    public static void main(String[] args){
        int a=10,b=5;

        // Arithmetic Operators
        System.out.println("Arithmetic Operators:");
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
        System.out.println("a%b="+(a%b));

        // Unary Operators
        System.out.println("\nUnary Operators:");
        System.out.println("a="+a);
        System.out.println("++a="+(++a)); // Pre-increment
        System.out.println("a++="+(a++)); // Post-increment
        System.out.println("After a++:"+a);

        System.out.println("--a="+(--a)); // Pre-decrement
        System.out.println("a--="+(a--)); // Post-decrement
        System.out.println("After a--:"+a);

        // Relational Operators
        System.out.println("\nRelational Operators:");
        System.out.println("a==b:"+(a==b));
        System.out.println("a!=b:"+(a!=b));
        System.out.println("a>b:"+(a>b));
        System.out.println("a<b:"+(a<b));
        System.out.println("a>=b:"+(a>=b));
        System.out.println("a<=b:"+(a<=b));

        // Logical Operators
        boolean x=true, y=false;
        System.out.println("\nLogical Operators:");
        System.out.println("x && y : " + (x && y));
        System.out.println("x || y : " + (x || y));
        System.out.println("!x : " + (!x));

        // Assignment Operators
        int c=20;
        System.out.println("\nAssignment Operators:");
        c+=5;
        System.out.println("c+=5:"+c);
        c-=3;
        System.out.println("c-=3:"+c);
        c*=2;
        System.out.println("c*=2:"+c);
        c/=4;
        System.out.println("c/=4:"+c);
        c%=3;
        System.out.println("c%=3:"+c);

        // Bitwise Operators
        int p=6,q=3;
        System.out.println("\nBitwise Operators:");
        System.out.println("p & q :"+(p & q));
        System.out.println("p | q :"+(p | q));
        System.out.println("p ^ q :"+(p ^ q));
        System.out.println("~p :"+(~p));

        // Shift Operators
        System.out.println("\nShift Operators:");
        System.out.println("p << 1: "+(p<<1));  // 'p=p*2'
        System.out.println("p >> 1: "+(p>>1));  // 'p=p/2'
        System.out.println("p >>> 1 "+(p>>>1));

        // Ternary Operator
        System.out.println("\nTernary Operator:");
        int max = (a > b) ? a : b;
        System.out.println("a="+a+" b="+b);
        System.out.println("Greater number(a,b) = " + max);

        // instanceof Operator
        System.out.println("\ninstanceof Operator:");
        String str = "Hello";
        System.out.println("str instanceof String : " + (str instanceof String));//type checking
    }
}
