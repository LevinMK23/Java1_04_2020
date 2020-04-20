package HomeWork;

public class TestDisney {

        public static void main(String[] args) {
            Disney[] Disney = new Disney[5];
            Disney[0] = new Disney("Alladin", 19, "man", "all-add-in@yahoo.com", "+1-123-123-12-12");
            Disney[1] = new Disney("Mickey Mouse", 44, "mouse", "justamouse@gmail.com", "+7-921-123-12-12");
            Disney[2] = new Disney("Donald Duck", 78, "duck", "mrduck@mailbox.com", "+7-911-234-23-23");
            Disney[3] = new Disney("Ariel", 24, "mermaid", "mermaid@undetthewater.com", "+7-901-345-34-34");
            Disney[4] = new Disney("Tom", 132, "cat", "meow@ihatejerry.com", "+1-234-234-23-23");
            showAgeOver40(Disney);
        }

        private static void showAgeOver40(Disney[] list) {
            System.out.println("Старше 40:");
            int count = 0;
            for (int i = 0; i < list.length; i++) {
                if((list[i]).getAge() > 40){
                    System.out.println(list[i]);
                    count++;
                }
            }
            if (count == 0) System.out.println("Все младше 40.");
        }
    }
