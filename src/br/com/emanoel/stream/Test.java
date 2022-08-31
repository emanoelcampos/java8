package br.com.emanoel.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290, true);
        User user2 = new User("Ana", 780, false);
        User user3 = new User("Lucas", 360, false);
        User user4 = new User("David", 550, false);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        //guardar uma lista com apenas o nome de cada usuário,
        // usando o mapping para coletar esses nomes em uma lista
        Map<Boolean, List<String>> nomePorTipo =
                users.stream()
                        .collect(Collectors.partitioningBy(User::getModerator,
                                Collectors.mapping(User::getName,
                                Collectors.toList())));
        System.out.println(nomePorTipo);

        //particionar por moderação, mas ter como valor
        // não os usuários, mas sim a soma de seus pontos
        Map<Boolean, Integer> pontuacaoPorTipo = users
                .stream()
                .collect(
                        Collectors.partitioningBy(
                                User::getModerator,
                                Collectors.summingInt(User::getPoints)));
        System.out.println(pontuacaoPorTipo);

        //Até mesmo para concatenar todos os nomes dos usuários há um coletor
        String nomes = users
                .stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.println(nomes);

        //Filtrar os usuários com mais de 100 pontos, 
        // ordená-los e coletar o resultado em uma lista
        List<User> filtradosOrdenados = users.stream()
                .filter(u -> u.getPoints() > 300)
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
        System.out.println(filtradosOrdenados);

        //usando parallel
        List<User> parallel = users.parallelStream()
                .filter(u -> u.getPoints() > 100)
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
        System.out.println(parallel);


    }
}
