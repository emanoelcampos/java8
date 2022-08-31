package br.com.emanoel.lambda;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

public class Test3 {

    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);

        Predicate<User> predicado = new Predicate<User>() {
            public boolean test(User user) {
                return user.getPoints() > 300;
            }
        };

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        users.removeIf(user -> user.getPoints() > 300); //não precisa declarar a variável
        users.forEach(user -> System.out.println(user));

        //métodos defaults foram adicionados para permitir que interfaces evoluam sem quebrar código existente

    }
}
