import java.util.Scanner;

public class CampusParkingChargeCalculator {
    interface Vehicle { double charge(int hours); }
    static class Bike implements Vehicle { public double charge(int h) { return 10.0 * h; } }
    static class Car implements Vehicle { public double charge(int h) { return 30.0 + 20.0 * (h - 1); } }
    static class Truck implements Vehicle { public double charge(int h) { return Math.max(100.0, 50.0 * h); } }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            int hours = Integer.parseInt(p[1]);
            Vehicle v;
            switch (p[0]) {
                case "BIKE": v = new Bike(); break;
                case "CAR": v = new Car(); break;
                case "TRUCK": v = new Truck(); break;
                default: throw new IllegalArgumentException("Unknown vehicle type");
            }
            double amount = v.charge(hours);
            System.out.printf("%s: %.2f%n", p[0], amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
