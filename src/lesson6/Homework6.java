package lesson6;


/**
 * Создать классы Собака и Кот с наследованием от класса Животное. - DONE
 * Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.). - DONE
 * Добавить подсчет созданных котов, собак и животных.
 */

public class Homework6 {
    public static void main(String[] args) {

        Cat Cat1 = new Cat("Барсик", "3", "Черный");
        Cat Cat2 = new Cat("Васька", "2", "Белый");
        Cat Cat3 = new Cat("Солнце", "1", "Полосатый");
        Cat Cat4 = new Cat("Рыжик", "4", "Рыжий");
        Dog Dog1 = new Dog("Кусь", "1", "Черный");
        Dog Dog2 = new Dog("Рекс", "2", "Белый");
        Dog Dog3 = new Dog("Тявка", "3", "Рыжий");
        //Dog Dog4 = new Dog("Щенок", "4", "Лысый");

        Cat1.Swim(29);
        System.out.println();
        Dog2.Swim(-1);
        System.out.println();
        Cat3.Run(199);
        System.out.println();
        Dog3.Run(203);
        System.out.println("============");
        Cat1.getCountCat();
        Dog1.getCountDog();
        Cat1.getAnimalCount();
    }
}
