import java.util.Scanner;

public class FestivalBonusCalculator {
    interface Employee { double bonus(); }
    static class FullTime implements Employee {
        double salary; FullTime(double s) { salary = s; }
        public double bonus() { return salary * 0.10; }
    }
    static class PartTime implements Employee {
        double salary; PartTime(double s) { salary = s; }
        public double bonus() { return salary * 0.05; }
    }
    static class Intern implements Employee {
        public double bonus() { return 2000.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Employee e;
            switch (p[0]) {
                case "FULLTIME": e = new FullTime(Double.parseDouble(p[2])); break;
                case "PARTTIME": e = new PartTime(Double.parseDouble(p[2])); break;
                case "INTERN": e = new Intern(); break;
                default: throw new IllegalArgumentException("Unknown employee type");
            }
            double amount = e.bonus();
            System.out.printf("%s: %.2f%n", p[1], amount);
            total += amount;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
