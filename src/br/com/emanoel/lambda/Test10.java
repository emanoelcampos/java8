package br.com.emanoel.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Test10 {

    public static void main(String[] args) {
        List<User> users = Arrays.asList((new User("emanoel", 290)), new User("ana", 780),
                new User("ana", 780));


        Set<User> seList = users.stream()
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(seList);

    }
}
