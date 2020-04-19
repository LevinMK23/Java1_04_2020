package lesson5;

public class UserTest {
    public static void main(String[] args) throws InterruptedException {
        User[] usersArray = new User[5];
        usersArray[0] = new User("Ivan", "Ivanovich", "Ivanov", "Senior Developer", "ivivan@mailbox.com", "89112223344", 170000, 31);
        usersArray[1] = new User("Artur", "Arturovich", "Arturov", "Senior Manager", "ivivan@mailbox.com", "89223334455", 110000, 33);
        usersArray[2] = new User("Anastasia", "Anastasievna", "Anastasieva", "Middle QA", "ivivan@mailbox.com", "89334445566", 150000, 27);
        usersArray[3] = new User("Ilya", "Ilyich", "Ilyin", "Middle Designer", "ivivan@mailbox.com", "89445556677", 90000, 32);
        usersArray[4] = new User("Roman", "Romanovich", "Romanov", "Head of Department", "ivivan@mailbox.com", "89556767788", 400000, 49);

        //getting information about co-workers over age 40
        for(User user : usersArray) {
            if(user.getAge() > 40) {
                System.out.println(user.toString());
            }
        }
    }
}
