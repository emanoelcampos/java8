package br.com.emanoel.lambda;

public class TesteMetodoDefault {
    public static void main(String[] args) {

        new Pessoa().correrRapido();

    }

    interface Corredor {
        default void correrRapido(){
            System.out.println("Corredor correndo rápido.");
        }
    }
    interface Piloto extends Corredor {
        default void correrRapido(){
            System.out.println("Correr rápido do método default");
        }
    }

    static class Pessoa implements Piloto {

    }
}
