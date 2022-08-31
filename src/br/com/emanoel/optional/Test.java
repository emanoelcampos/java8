package br.com.emanoel.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        String s = "1";
        Optional<Integer> numero = converteEmNumero(s);
        System.out.println(numero);

        //retorna um booleano se existe um número ou não
        System.out.println(numero.isPresent());

        //retorna o valor convertido
        System.out.println(numero.get());

        //só executa se algum valor existir
        //converteEmNumero(s).ifPresent(n -> System.out.println(n));
        numero.ifPresent(n -> System.out.println(n));

        //retorna um valor default determinado em casos de retorno null
        Integer orElse = converteEmNumero(s).orElse(7);
        System.out.println(orElse);

        //em caso de retorno NULL uma operação lambda é executada
        //Integer orElseGet = converteEmNumero(s).orElseGet(() -> {return operacaoPesada();});
        Integer orElseGet = converteEmNumero(s).orElseGet(() -> 5);
        System.out.println(orElseGet);

        //lança uma exceção se o optional estiver vazio
        Integer orElseThrow = converteEmNumero(s).orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(orElseThrow);

        //exemplos com tipos primitivos usando stream
        Optional<Integer> numeroPrimeiro = Stream.of(1, 2, 3)
                .findFirst();
        System.out.println(numeroPrimeiro);

        //exemplo sem armazenar em uma variável
        Stream.of(1, 2, 3)
                .findFirst()
                .ifPresent(n -> System.out.println(n));

        String s2 = "1";
        int numero2 = converteEmNumeroInt(s2)
                .orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(numero2);


    }

    //útil para retorno de método
    public static Optional<Integer> converteEmNumero(String numString) {
        try {
            return Optional.of(Integer.valueOf(numString));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static OptionalInt converteEmNumeroInt (String numeroString){
        try {
            return OptionalInt.of(Integer.parseInt(numeroString));
        } catch (Exception e) {
            return OptionalInt.empty();
        }
    }
}
