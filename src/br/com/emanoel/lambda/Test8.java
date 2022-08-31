package br.com.emanoel.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Test8 {
    public static void main(String[] args) {

        User user1 = new User("Emanoel", 290);
        User user2 = new User("Ana", 780);
        User user3 = new User("Lucas", 360);
        User user4 = new User("David", 550);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        users.stream()
                .filter(user -> user.getPoints() > 300)
                .forEach(System.out::println);

        /*vantagem de se utilizar streams: evitar efeitos
        colaterais na coleção com que estamos trabalhando*/

        /*forEach devolve void, ent&atilde;o nesse ponto n&atilde;o temos mais
        a refer&ecirc;ncia ao Stream resultante do filter*/
        Stream<User> stream = users.stream()
                .filter(user -> user.getPoints() > 300);
                stream.forEach(System.out::println);



    }
}
