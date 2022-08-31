package br.com.emanoel.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);
        //User user5 = new User("Teste", 0);

        //Arrays.asList retorna uma lista que pode ser modificada ao contrário de List.of
        //Arrays.asList tem tamanho fixo, podendo mudar somente os valores que ja existem
        //Arrays.asList aceita elementos nulos ao contrário de List.of
        /*Quando um array é passado para método Arrays.asList, a referêcia é mantida para o array original
        e uma mudança no array reflete no método. No List.of não acontece a mesma coisa*/
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        for (User user : users){
            System.out.println("1" + user.getName());
        }

        //instancia da classe criada para mostrar o nome dos usuários passando o parametro Consumer implementando
        ShowName mostrar = new ShowName();
        users.forEach(mostrar);
        System.out.println("2");

        //usando classe anônima para tarefas mais simples
        Consumer<User> showName = new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("3" + user.getName());
            }
        };

        //sem variável local
        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println("4" + user.getName());
            }
        });

        //Lambda no Java, é uma maneira mais simples de implementar uma interface que tem somente um método
        Consumer<User> showSomething = (User user) -> {
            System.out.println("5" + user.getName());
        };

        //passagem sem o tipo
        Consumer<User> showInf = user -> {
            System.out.println("6" + user.getName());
        };

        //bloco {} somente com uma instrução pode ser omitido junto com ponto e virgula
        Consumer<User> showNames = user -> System.out.println(user.getName());

        users.forEach(user -> System.out.println("7" + user.getName()));

        System.out.println("depurando");







    }
}
