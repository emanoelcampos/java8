package br.com.emanoel.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test9 {

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

        Set<User> maisQue300 = users
                .stream()
                .filter(u -> u.getPoints() > 300)
                .collect(Collectors.toSet());
        System.out.println(maisQue300);


        Stream<User> stream = users.stream();
        Set<User> set = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(set);



    }
}
