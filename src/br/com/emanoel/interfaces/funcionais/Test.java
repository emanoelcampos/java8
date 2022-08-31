package br.com.emanoel.interfaces.funcionais;

public class Test {

    public static void main(String[] args) {

        //toda interface do Java que possui apenas um método abstrato pode ser instaciado como um código lambda

        //interface funcional = apenas 1 método
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 1000; i++){
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();

        //com lambda
        Runnable r2 = () -> {
            for (int i = 0; i <= 1000; i++){
                System.out.println(i);
            }
        };
        new Thread(r2).start();

        //com apenas um único statement, com menos legibilidade
        new Thread(() -> {
            for (int i = 0; i <= 1000; i++){
                System.out.println(i);
            }
        }).start();

       //o lambda por si só não existe, e sim expressões lambdas que é atribuida/infirida a uma interface funcional








    }
}
