package lesson1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User /* implements Comparable<User>*/ {
    String name;
    int age;

    User(String n, int a) {
        name = n;
        age = a;
    }

    public static void main(String[] args) {
        TreeSet<User> tree = new TreeSet<>(Comparator.comparing(o -> o.name));
        Integer [] a = {16, 28, 60, 22, 67, 54, 11};
        // GregorianCalendar
        Arrays.sort(a, a.length/2, a.length);
        System.out.println(Arrays.toString(a));
        HashSet collection = new HashSet();
        collection.add("3");
        collection.add("21");
        collection.add("1");
        collection.add("25");
        System.out.println(collection);
        TreeMap<String, String> pets = new TreeMap<>();
        pets.put("Barsik", "Ivan");
        pets.put("ZigZag", "Donald");

//        Map<String, String> mondayPets = pets.entrySet().stream()
//                .filter(entry -> entry.getKey().charAt(0) >= 'A')
//                .filter(entry -> entry.getKey().charAt(0) <= 'H')
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //System.out.println(map);
        TreeMap <String, String> mondayPets = new TreeMap<>();
        for (Map.Entry<String, String> entry : pets.entrySet()) {
            if (entry.getKey().charAt(0) >= 'A' && entry.getKey().charAt(0) <= 'H') {
                mondayPets.put(entry.getKey(), entry.getValue());
            }
        }
    }

//    @Override
//    public int compareTo(User o) {
//        // >
//        return name.compareTo(o.name);
//    }
}