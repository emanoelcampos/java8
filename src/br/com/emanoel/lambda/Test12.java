package br.com.emanoel.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test12 {

    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        List<User> pointFilter = users.stream()
                .filter(user -> user.getPoints() > 300)
                .sorted(Comparator.comparing(user -> user.getName()))
                .collect(Collectors.toList());
        System.out.println(pointFilter);

        //devolve qualquer usuario com + de 100 pontos na posição 0
        //filta, coleta em uma lista
        //todos users são filtrados para uma nova coleção
        User maisDe100 = users.stream()
                .filter(u -> u.getPoints() > 100)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(maisDe100);

        //faz a mesma coisa de forma sem que seja interamente filtrado
        Optional<User> usuarioOptional = users.stream()
                .filter(u -> u.getPoints() > 100)
                .findAny();
        System.out.println(usuarioOptional);

        //peek = só serão mostrados os elementos até que seja encontrado algum
        //elemento que cumpra o predicado
        users.stream()
                .filter(u -> u.getPoints() > 100)
                .peek(System.out::println)
                .findAny();

        //sorted é um método intermediário stateful. Operações stateful podem precisar
        // processar todo o stream mesmo que sua operação terminal não demande isso
        //peek imprime todos os nomes
        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .peek(System.out::println)
                .findAny();

        boolean hasModerator = users.stream()
                .anyMatch(User::getModerator);
        System.out.println(hasModerator);

    }
}
