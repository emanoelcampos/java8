package br.com.emanoel.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test7 {

    public static void main(String[] args) {

        //constructor reference
        Supplier<User> userCreator = User::new;
        User newUser = userCreator.get();

        Function<String, User> userCreator2 = User::new;
        User emanoel = userCreator2.apply("Emanoel");

        BiFunction<String, Integer, User> userCreator3 = User::new;
        User ana = userCreator3.apply("ana", 790);

    }
}
