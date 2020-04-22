package homework5;

import java.util.Random;

public class Homework5 {

    private static Random rnd = new Random();

    public static void main(String[] args) {
        String[] names = {"Aahan", "Aala", "Aaleahya", "Aaleyah", "Aalijah", "Aaliyah", "Aaliyah", "Aamori", "Aanjay", "Aaralyn"};
        String[] surnames = {"Ingarfill", "Haddington", "Stang-Gjertsen", "Greneham", "Beavon", "Gouch", "Songist", "Staries", "Goldes", "Cleal"};
        String[] patronymics = {"Аалферов", "Аалферова", "Ааль", "Ааман", "Аамана", "Ааманая", "Ааманий", "Аандреев", "Аандреева", "Аарон",};

        String[] positions = {"Payment Adjustment Coordinator", "Financial Analyst", "Biostatistician IV", "Director of Sales", "Community Outreach Specialist", "Programmer II", "Project Manager", "Legal Assistant", "Software Consultant", "Dental Hygienist"};

        Person[] persons = new Person[5];

        for (int i = 0; i < persons.length ; i++) {
            String name = names[rnd.nextInt(names.length)];
            String surname = surnames[rnd.nextInt(surnames.length)];
            String patronymic = patronymics[rnd.nextInt(patronymics.length)];

            int age = rnd.nextInt(65);

            String position = positions[rnd.nextInt(positions.length)];

            double salary = Math.floor(rnd.nextDouble() * 1000 * 100) / 100;

            String phone = "+7" +
                    (rnd.nextInt(899) + 100) +
                    (rnd.nextInt(89) + 10) +
                    (rnd.nextInt(89) + 10);

            String email = name + surname + rnd.nextInt(100) + "@mail.com";

            persons[i] = new Person(name, surname, patronymic, age, position, salary, phone, email);

        }

        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge() > 40) {
                System.out.println(persons[i]);
            }
        }

    }
}
