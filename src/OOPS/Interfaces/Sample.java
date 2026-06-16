package OOPS.Interfaces;

interface Payment {
    double service_charges=36.36;
    void pay(double amount);
}
class UpiPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Total paid ₹" + (amount+Payment.service_charges) + " using UPI");
    }
}
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Total paid ₹" + (amount+Payment.service_charges) + " using Credit Card");
    }
}
public class Sample {
    public static void main(String[] args) {
        Payment p;
        System.out.println("Paid ₹500 by UPI");
        p = new UpiPayment();
        p.pay(500);
        System.out.println();

        System.out.println("Paid ₹1000 by Credit Card");
        p = new CreditCardPayment();
        p.pay(1000);
    }
}
