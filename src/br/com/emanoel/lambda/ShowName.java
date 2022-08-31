package br.com.emanoel.lambda;

import java.util.function.Consumer;

public class ShowName implements Consumer<User> {

    @Override
    public void accept(User user) {
        System.out.println(user.getName());
    }
}
