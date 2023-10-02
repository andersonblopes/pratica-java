package com.lopes8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * The type Sort string.
 */
public class SortString
{

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<String> family = new ArrayList<String>();
        family.add("Anderson");
        family.add("Elaine");
        family.add("Helena");

        // Anonymous class parameter
        family.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Remove anonymous class with lambda - refactor 1
        family.forEach((String s) -> {
            System.out.println(s);
        });

        // Remove require parameter type - refactor 2
        family.forEach(s -> {
            System.out.println(s);
        });

        // Just one line - refactor 3
        family.forEach(s -> System.out.println(s));

        // Ordering sending anonymous class - refactor 1
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        };

        // Ordered by new  criteria
        Collections.sort(family, comparator);
        System.out.println(family);

        // Reordering with lambda - refactor 2
        family.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(family);

        // Remove comparator use - refactor 2
        family.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(family);

        // Refactor to using lambda
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable running");
            }

        }).start();

        // Convert to use lambda
        new Thread(() -> System.out.println("Runnable running")).start();
    }
}
