package br.com.emanoel.stream;

import java.util.*;
import java.util.stream.Collectors;


public class TestOF {
    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        //operações finais
        //quando uma operação final é chamada o stream fecha e não pode fazer mais operações

        //conta número de elementos
        long count = numList.stream()
                //pode ter operações intermediárias no meio
                .count();
        System.out.println(count);

        //retorna menor valor
        Optional<Integer> min = numList.stream()
                .min(Comparator.naturalOrder());
        System.out.println(min.get());

        //retorna maior valor
        Optional<Integer> max = numList.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        //coletor que pode pegar os resultados das OI e transformar em uma nova lista
        List<Integer> newNumList = numList.stream()
                .collect(Collectors.toList());

        //no exemplo agrupou dois grupos por true or false
        //é do tipo Boolean porque o retorno é do tipo boolean > o exemplo é uma comparação > ==
        Map<Boolean, List<Integer>> mapa = numList.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0));

        //exemplo de um mapa que está agrupado pelo resto da divisão de 3
        //exemplo util para agrupar entidades > lista de cliente agrupadas por idade
        Map<Integer, List<Integer>> mapa2 = numList.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(mapa2);

        //joining agrupa Strings
        String mapa3 = numList.stream()
                .map(e -> String.valueOf(e)) // transformando lista de int em Strings
                .collect(Collectors.joining(";")); //string com delimitadores
        System.out.println(mapa3); //retorna todos os número concatenados

        //streams são loops implícitos
        //for - while - do..while = loops explícitos
    }
}
