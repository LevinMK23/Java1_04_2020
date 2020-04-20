package lesson5;

public class Lamp {

    private boolean isOn;
    // Функция с именем класса - это особая функция,
    // которая называется конструктор (она создает инстанс класса)
    public Lamp() {
        isOn = false;
    }

    public Lamp(boolean isOn) {
        this.isOn = isOn;
    }

    public void on() {
        if (isOn) {
            System.out.println("И так включена!");
        } else {
            isOn = true;
            System.out.println("Вы включили лампочку");
        }
    }

    public void off() {
        if (!isOn) {
            System.out.println("И так выключена!");
        } else {
            isOn = false;
            System.out.println("Вы выключили лампочку");
        }
    }

    public boolean isOn() {
        return isOn;
    }
}
