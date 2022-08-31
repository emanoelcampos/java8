package br.com.emanoel.interfaces.funcionais;

import java.util.*;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {

        //Supplier = representa função que entrega algo e não recebe parâmetro
        //função lambda não recebe nada e retorna um número aleatório
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        //Consumer e BiConsume = não retorna nada mas recebe um valor
        //recebe função com valor, função faz algo com esse valor mas o consumer não retorna nada
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(e -> System.out.println(e)); //consumer

        //Predicate = função que recebe um valor e retorna um booleano -> comparação
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        //Function = recebe um valor e retorna um valor
        list.stream()
                .map(e -> e.doubleValue())
                .forEach(System.out::println);

        //UnaryOperator = recebe um valor e retorna um valor do mesmo tipo
        list.stream()
                .reduce((e1, e2) -> e1 + e2)
                .ifPresent(System.out::println);

        //removeIf -> remove da List dentro de um filter, faz um teste -> recebe Predicate

        //replaceAll -> Map e List
        // list = recebe os elementos e uma operação é feita
        //map = recebe a chave e o valor e uma operação é feita

        //compute -> map = recebe uma chave e uma operação é feito para o valor dessa chave

        //forEach -> BiConsumer = exemplo de map, que recebe uma chave e um valor

        //merge -> map = parecido com compute mas caso a chave não exista é criada
        //recebe uma chave e um valor e para chave e valor uma operação pode ser feita

        List<Integer> listArray = new ArrayList<>();
        listArray.add(1);
        listArray.add(2);
        listArray.add(3);
        listArray.add(4);

        listArray.removeIf(e -> e % 2 == 0);
        listArray.replaceAll(e -> e * 2);
        listArray.forEach(e -> System.out.println(e));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Meu");
        map.put(2, "nome");
        map.put(3, "é");
        map.put(4, "Ana");

        map.replaceAll((k, v) -> v + "!");
        map.compute(4, (k, v) -> v + " Lucia");
        map.merge(2, " e sobrenome", (v1, v2) -> v1 + v2);
        map.merge(5, " Gomes", (v1, v2) -> v1 + v2);

        map.forEach((k, v) -> System.out.println(k + v));




    }
}
