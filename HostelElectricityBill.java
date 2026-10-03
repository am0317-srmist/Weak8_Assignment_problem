import java.util.Scanner;

public class HostelElectricityBill {
    interface Room { double bill(); }
    static class Single implements Room {
        double units;
        Single(double u) { units = u; }
        public double bill() { return units * 8; }
    }
    static class Shared implements Room {
        double units; int occupants;
        Shared(double u, int o) { units = u; occupants = o; }
        public double bill() { return units * 6 / occupants; }
    }
    static class AC implements Room {
        double units;
        AC(double u) { units = u; }
        public double bill() { return units * 10 + 200; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Room r;
            switch (p[0]) {
                case "SINGLE": r = new Single(Double.parseDouble(p[1])); break;
                case "SHARED": r = new Shared(Double.parseDouble(p[1]), Integer.parseInt(p[2])); break;
                case "AC": r = new AC(Double.parseDouble(p[1])); break;
                default: throw new IllegalArgumentException("Unknown room type");
            }
            double amount = r.bill();
            System.out.printf("%s: %.2f%n", p[0], amount);
            total += amount;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
