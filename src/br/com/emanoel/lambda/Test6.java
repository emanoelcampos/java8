package br.com.emanoel.lambda;

import java.util.Arrays;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1,2,3,4,5,6);
        asList.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));



    }
}
