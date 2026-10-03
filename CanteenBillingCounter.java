import java.util.Scanner;

public class CanteenBillingCounter {
    interface Customer { double finalAmount(double amount); }
    static class Student implements Customer { public double finalAmount(double a) { return a * 0.90; } }
    static class Staff implements Customer { public double finalAmount(double a) { return a * 0.95; } }
    static class Guest implements Customer { public double finalAmount(double a) { return a + 10; } }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Customer c;
            switch (p[0]) {
                case "STUDENT": c = new Student(); break;
                case "STAFF": c = new Staff(); break;
                case "GUEST": c = new Guest(); break;
                default: throw new IllegalArgumentException("Unknown customer type");
            }
            double amount = c.finalAmount(Double.parseDouble(p[1]));
            System.out.printf("%s: %.2f%n", p[0], amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
