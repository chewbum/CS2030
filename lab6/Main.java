import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Roster r = new Roster("roster");
        for (int i = 0; i < num; i++) {
            String name = scanner.next();
            String module = scanner.next();
            String assessment = scanner.next();
            String grade = scanner.next();
            r = r.add(name, module, assessment, grade);
        }

        while (scanner.hasNext()) {
            String name = scanner.next();
            String module = scanner.next();
            String assessment = scanner.next();
            String grade = r.getGrade(name, module, assessment);
            System.out.println(grade);
        }

        scanner.close();
    }
}