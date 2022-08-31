package br.com.emanoel.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test11 {
    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        List<Integer> points = users.stream()
                        .map(User::getPoints)
                        .collect(Collectors.toList());
        System.out.println(points);

        //evitar autoboxing = mapToInt
        IntStream stream = users.stream()
                .mapToInt(User::getPoints);

        //obter a média de pontos dos usuários
        OptionalDouble media = users.stream()
                .mapToInt(User::getPoints)
                .average();
        double pontuacaoMedia = media.orElse(0.0);
        System.out.println(pontuacaoMedia);

        //em uma ínica linha
        double averagePoints = users.stream()
                .mapToInt(User::getPoints)
                .average()
                .orElse(0.0);
        System.out.println(averagePoints);
    }
}
