package br.com.emanoel.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class Test5 {
    public static void main(String[] args) {

        /*User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        // com forEach
        users.forEach(user -> user.setModeratorTrue());

        // usando method reference
        users.forEach(User::setModeratorTrue);

        Consumer<User> setModeratorTrue = User::setModeratorTrue;
        //setModeratorTrue.accept(user1);
        users.forEach(setModeratorTrue);

        //referência ao método usando o comparing
        users.sort(comparing(User::getName)); // sem Comparator por conta do import estático

        //import estático do método comparing extraindo expressão para variável
        Function<User, String> byName = User::getName;
        users.sort(comparing(byName));

        //comparando por pontos com comparingInt para evitar boxing
        users.sort(Comparator.comparingInt(user -> user.getPoints()));
        //com referência ao método
        users.sort(Comparator.comparingInt(User::getPoints));*/


    }
}
