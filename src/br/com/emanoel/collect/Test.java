package br.com.emanoel.collect;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        List<Object> collect = list.stream().
                collect(() -> new ArrayList<>(), // fornecedor
                        (l, e) -> l.add(e), // acumulação
                        (l1, l2) -> l1.addAll(l2) // combinação
                );
        System.out.println(collect);

        //toList, toSet, toCollection
        List<Integer> toAlgumaCoisa = list.stream().
                collect(Collectors.toList());
        System.out.println(toAlgumaCoisa);

        //joining = agrupo elementos numa única string
        String join = list.stream() //devolve string
                .map(n -> n.toString())
                .collect(Collectors.joining(", "));
        System.out.println(join);

        //averaging = média
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        //summing = soma
        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(soma);

        //summarizing = .getAverange, .getCount, .getMax, .getMin, .getSum
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println(stats);

        //counting = outra forma de retorna o total de elementos
        Long count = list.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        //max/min
        list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        //groupingBy = retorna agrupado em um mapa
        Map<Integer, List<Integer>> grouping = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(grouping);

        //partitioningBy = retorna agrupado em booleano
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0)); //comparação
        System.out.println(partitioningBy);

        //toMap = acumula elementos em um mapa com chave e valor
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(toMap);

    }
}
