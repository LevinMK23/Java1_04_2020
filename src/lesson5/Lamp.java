package Lesson5_HW5;

public class Colleague {

    //private Object getMax;


    private Colleague(String иванов_иван_, String s, String s1, String s2, int i, int i1) {
    }

    public static void main(String[] args) {

        Colleague[] collArray = new Colleague[5];
        collArray[0] = new Colleague("Иванов Иван ", "Начальник Тех. отдела ", "IvanIvan@person.ru ", "  8 912 345 67 89 ", 50000, 42);
        collArray[1] = new Colleague("Петров Петр ", "Менеджер ", "PetrovPetr@person.ru ", "  8 912 345 67 89 ", 35000, 33);
        collArray[2] = new Colleague("Сидоров Даниил ", "Эксперт ", "SidorovDaniil@person.ru ", "  8 912 345 67 89 ", 35000, 40);
        collArray[3] = new Colleague("Попов Алексей ", "Специалист ", "PopovAlex@person.ru ", "  8 912 345 67 89 ", 50000, 37);
        collArray[4] = new Colleague("Корнеев Дмитрий ", "Мастер наладчик ", "KornDmitr@person.ru ", "  8 912 345 67 89 ", 50000, 56);

        collArray[0].getMax); // те кто свыше 40


        for (int i = 0; i < ; i++) {
            if(collArray[i].getMax() >= 40){
                System.out.println("Сотрудниками в возрасте 40 лет и выше у нас являются: ");
            }
        }
    }
}
