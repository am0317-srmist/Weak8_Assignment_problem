import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    interface Plan { long validityDays(); }
    static class Basic implements Plan { public long validityDays() { return 30; } }
    static class Standard implements Plan { public long validityDays() { return 90; } }
    static class Premium implements Plan { public long validityDays() { return 365; } }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Plan plan;
            switch (p[0]) {
                case "BASIC": plan = new Basic(); break;
                case "STANDARD": plan = new Standard(); break;
                case "PREMIUM": plan = new Premium(); break;
                default: throw new IllegalArgumentException("Unknown plan type");
            }
            LocalDate start = LocalDate.parse(p[2]);
            System.out.println(p[1] + ": " + start.plusDays(plan.validityDays()));
        }
        sc.close();
    }
}
