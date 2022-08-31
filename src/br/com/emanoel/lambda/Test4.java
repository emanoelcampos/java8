package br.com.emanoel.lambda;

import java.util.*;

import static java.util.Comparator.comparing;

public class Test4 {
    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);


        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        /*Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getName().compareTo(u2.getName());
            }
        };*/
        // Collections.sort(users, comparator);

        //Comparator<User> comparator = (u1, u2) -> u1.getName().compareTo(u2.getName());
        //Collections.sort(users, comparator);

        //colocando tudo em uma mesma linha, sem a declaração da variável local "comparator"
        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));

        //formas mais simples
        //1
        Collections.sort(users, comparing(User::getName));
        //2
        users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        users.sort(comparing(User::getName));
















    }
}
