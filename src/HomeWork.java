package lesson5;

public class HomeWork {
    public static void main(String[] args) {
        Sotrudnik[] sotrudniks = new Sotrudnik[5];
        sotrudniks[0] = new Sotrudnik("Борисов Владислав Олегович", "Java-developer",
                "borisovvlad.spb@gmail.com", "89995358285", 100000, 24);
        sotrudniks[1] = new Sotrudnik("Борис Влад Олег", "Product manager",
                "borisvlad@gmail.com", "89995358787", 110000, 41);
        sotrudniks[2] = new Sotrudnik("Корнелюк Ян Игоревич", "Retual-agent",
                "korn@gmail.com", "89995787477", 140000, 25);
        sotrudniks[3] = new Sotrudnik("Ершов Максим Владимирович", "Warehouse manager",
                "ersh@gmail.com", "89995554443", 100000, 26);
        sotrudniks[4] = new Sotrudnik("Агафонова Валерия Михайловна", "Barmen",
                "agaf@gmail.com", "89990292450", 70000, 44);

        for (Sotrudnik sotrudniki: sotrudniks) {
            if (sotrudniki.getAge() < 40){
                System.out.println(sotrudniki.toString());
            }
        }
    }
}
