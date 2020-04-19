package LessonOOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employer[] employers = new Employer[5];
        employers[0] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 29);
        employers[1] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 54);
        employers[2] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 68);
        employers[3] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 22);
        employers[4] = new Employer("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 19);

        for (int i = 0; i < 5; i++) {
            if (employers[i].getAge() > 40) System.out.println(employers[i]);
        }
    }
}
