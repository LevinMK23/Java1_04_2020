package lesson5;

public class HomeWork {
    public static void main(String[] args) {
        Sotrudnik[] sotrudniks = new Sotrudnik[5];
        sotrudniks[0] = new Sotrudnik("Филиппов Вячеслав Евгеньевич", "Java-developer",
                "negativ337@mail.ru", "8800553535", 100000, 40);
        sotrudniks[1] = new Sotrudnik("Огарков Эммануил Андреевич", "Product manager",
                "mailmail@gmail.com", "88006666666", 110000, 21);
        sotrudniks[2] = new Sotrudnik("Чехов Макар Эрнестович", "Retual-agent",
                "korn@gmail.com", "88006666688", 140000, 22);
        sotrudniks[3] = new Sotrudnik("Яскин Викентий Эрнстович", "Warehouse manager",
                "ersh@gmail.com", "88006666699", 100000, 41);
        sotrudniks[4] = new Sotrudnik("Милехин Наум Эмилевич", "Barmen",
                "agaf@gmail.com", "88006668999", 70000, 24);

        for (Sotrudnik sotrudniki: sotrudniks) {
            if (sotrudniki.getAge() > 40){
                System.out.println(sotrudniki.toString());
            }
        }
    }
}
