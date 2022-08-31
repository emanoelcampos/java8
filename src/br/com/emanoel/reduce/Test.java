package br.com.emanoel.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // reduce = pega todos os elementos de um stream e junta em uma só
        Optional<Integer> reduce = list.stream()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println(reduce.get());

        //reduce com valor de identidade
        Integer soma = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println(soma);
    }
}
