package br.com.emanoel.stream;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {

        //Arrays
        Integer[] intArray = new Integer[] {1,2,3,4};
        Arrays.stream(intArray).forEach(System.out::println);

        //Stream.of = passar lista de qualquer coisa, qualquer objeto pode ser passado
        Stream
                .of("Meu", "nome", "é", "Emanoel")
                .forEach(System.out::println);

        //IntStream.range
        IntStream.range(0,8).forEach(System.out::println);
        IntStream.rangeClosed(0,8).forEach(System.out::println); //inclui o ultimo número

        //Stream.iterate -> valor inicial / transformação = que é aplicada ao valor inicial
        Stream.iterate(7, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);

        //BufferedReader - lines = ler arquivos em java
        //método para ler as linhas de um arquivo como stream
        File file = new File("C:/Users/emano/IdeaProjects/Java8/src/br/com/emanoel/stream.txt");
        FileReader in = null;
        try {
            in = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(in);
        br.lines().forEach(System.out::println);

        //Files - não trabalha com o conteúdo do arquivo e sim com os arquivos que está presentes no diretório
        Path p = Paths.get("");
        try {
            Files.list(p).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
