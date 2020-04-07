package lesson1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //      name           product   sumPrice
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
        while (in.hasNext()) {
            String [] data = in.nextLine().split(" +");
            String name = data[0], product = data[1];
            int price = Integer.parseInt(data[2]);
            if (map.containsKey(name)) {
                if (map.get(name).containsKey(product)) {
                    map.get(name).put(product, map.get(name).get(product) + price);
                } else {
                    map.get(name).put(product, price);
                }
            } else {
                TreeMap<String, Integer> newProd = new TreeMap<>();
                newProd.put(product, price);
                map.put(name, newProd);
            }
        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, Integer> prod : entry.getValue().entrySet()) {
                System.out.println(prod.getKey() + " " + prod.getValue());
            }
        }
    }
}
