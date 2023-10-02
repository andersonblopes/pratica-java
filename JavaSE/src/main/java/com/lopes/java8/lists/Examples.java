package com.lopes.java8.lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Examples {

    public static void main(String[] args) {

        /** Find the longest string from a given array**/

        String[] words = {"Anderson", "Lopes", "spring boot application", "Java", "Interview", "basic"};

        String longestWord = Arrays.stream(words).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();

        System.out.println(longestWord);

        /** Find an element from array who starts with 1**/

        int[] numbers = {1, 10, 25, 159, 459, 851};

        List<String> numbersAsString = Arrays.stream(numbers).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(numbersAsString.toString());

        /** Join ementes from string a given array **/

        String[] valuesToJoin = {"1", "2", "3", "4", "5"};

        String result = String.join("-", valuesToJoin);

        System.out.println(result.toString());


        /** Skip & limit example method use case-based example (2-9) **/

        IntStream.range(1, 10).skip(1).limit(8).forEach(System.out::println);
    }
}
