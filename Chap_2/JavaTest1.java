package Chap_2;

/**
 * Created by user1 on 7/18/15.
 */
public class JavaTest1 {

    private double balance;

    public JavaTest1(double amt) {
        balance = amt;
    }

    public double getBalance() {
        return balance;
    }

    public void method1() {
        JavaTest1 obj1 = new JavaTest1(300.00);
        System.out.println("Balance in method1 before method2= " + obj1.getBalance());
        method2(obj1);
        System.out.println("Balance in method1 after method2 = " + obj1.getBalance());
    }

    public void method2(JavaTest1 o) {
        o.balance -= 100.00;
    }

    public static void main(String[] args) {
        JavaTest1 j1 = new JavaTest1(500.00);
        System.out.println("Balance in main before= " + j1.getBalance());

        j1.method1();
        System.out.println("Balance in main after = " + j1.getBalance());

    }
}
