package br.com.emanoel.stream;

import java.util.Arrays;
import java.util.List;

public class TestOI {
    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);

        //java 8 com stream: fluxo de dados
        //nesse caso cada número da lista é um tipo de dado que está percorrendo o stream

        numList.stream() //operação intermediária

                .skip(2) //ignora dois elementos

                .limit(2) //limita a dois elementos

                .distinct() //ignora elementos repetidos > equals e hashcode

                .filter(e -> e % 2 == 0) //implementar o filtro da forma que eu quiser

                .map(e -> e * 2 ) //é uma transformação, a lista original não é modificada

                .forEach(e -> System.out.println(e)); //operação final
    }
}
