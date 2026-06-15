package OOPS.Data_Abstraction;

abstract class Payment {
    abstract void pay(double amount);
}
class CreditCardPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}
class UpiPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
public class Sample1 {
    public static void main(String[] args) {
        Payment p;

        p = new CreditCardPayment();
        p.pay(1000);

        p = new UpiPayment();
        p.pay(500);
    }
}
