package br.com.emanoel.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {

    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);
        //User user5 = new User("Teste", 0);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Consumer<User> mostraMensagem = user ->
                System.out.println("antes de imprimir os nomes");
        Consumer<User> imprimeNome = user ->
                System.out.println(user.getName());
        users.forEach(mostraMensagem.andThen(imprimeNome));
    }
}
