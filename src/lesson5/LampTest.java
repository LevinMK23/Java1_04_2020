package lesson5;

public class LampTest {
    public static void main(String[] args) throws InterruptedException {
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp(true);
        lamp1.on();
        lamp2.on();
        lamp2.off();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            if (lamp1.isOn()) {
                lamp1.off();
            } else {
                lamp1.on();
            }
        }
    }
}
