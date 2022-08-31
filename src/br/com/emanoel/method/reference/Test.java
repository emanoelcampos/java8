package br.com.emanoel.method.reference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //method reference
        list.stream()
                .forEach(System.out::println);

        //sem method reference
        list.stream()
                .forEach(n -> System.out.println(n));

        //métodos estáticos
        list.stream()
                .map((n) -> multPorDois(n))
                .forEach(System.out::println);
        //com MR
        list.stream()
                .map(Test::multPorDois)
                .forEach(System.out::println);

        //construtores
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach(System.out::println);
        //com MR
        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        //várias instâncias
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach(System.out::println);
        //com MR
        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        //única intância
        //transformou em big decimale dps x2
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((b) -> dois.multiply(b))
                .forEach(System.out::println);

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);
    }

    private static Integer multPorDois(Integer i){
        return i * 2;
    }
}
