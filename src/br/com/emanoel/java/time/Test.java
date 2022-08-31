package br.com.emanoel.java.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        //saida com a data após um mês a partir da data atual
        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        System.out.println(mesQueVem);

        //saida com a data um ano atrás a partir da data atual
        LocalDate anoPassado = LocalDate.now().minusYears(1);
        System.out.println(anoPassado);

        //LocalDate representa uma data sem horário nem timezone
        //se as informações de horário forem importantes usamos = LocalDateTime
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        //LocalTime para reseprentar apenas as horas
        LocalTime agoraHora = LocalTime.now();
        System.out.println(agoraHora);

        //outra forma de criar uma LocalDateTime com horário específico
        //é utilizando o método atTime da classe LocalDate
        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);
        System.out.println(hojeAoMeioDia);

        //podemos usar o "at" para unir uma classe LocalDate com um LocalTime:
        LocalTime agoraH = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEhora = hoje.atTime(agoraH);
        System.out.println(dataEhora);

        //podemos a partir desse LocalDateTime, chamar o método atZone para construir
        //um ZonedDateTime, que é o modelo utilizado para representar uma data com hora e timezone
        ZonedDateTime dataComHoraETimezone = dataEhora.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(dataComHoraETimezone);

        //Para converter esses objetos para outras medidas de tempo podemos utilizar os métodos "to"
        //como é o caso do toLocalDateTime presente na classe ZonedDateTime
        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
        System.out.println(semTimeZone);

        //método estático of, que é um factory method para construção de suas novas instâncias
        LocalDate date = LocalDate.of(2023, 2, 10);
        LocalDateTime dateTime = LocalDateTime.of(2023, 2, 10, 8, 0);
        System.out.println(dateTime);

        //Para modificar o ano de um LocalDate, por exemplo, poderíamos utilizar o método withYear
        LocalDate dataDoPassado = LocalDate.now().withYear(1997);
        System.out.println(dataDoPassado);
        System.out.println(dataDoPassado.getYear());

        //o saber se alguma medida de tempo acontece antes, depois ou ao mesmo tempo que outra
        LocalDate dateHoje = LocalDate.now();
        LocalDate dateAmanha = LocalDate.now().plusDays(1);

        System.out.println(dateHoje);
        System.out.println(dateAmanha);

        System.out.println(dateHoje.isBefore(dateAmanha));
        System.out.println(dateHoje.isAfter(dateAmanha));
        System.out.println(dateHoje.isEqual(dateAmanha));

        //casos em que queremos comparar datas iguais, porém em timezones diferentes
        //devemos utilizar o método isEqual
        ZonedDateTime tokyo = ZonedDateTime
                .of(2022, 8, 10, 12, 0, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo = ZonedDateTime
                .of(2022, 8, 10, 12, 0, 0, 0, ZoneId.of("America/Sao_Paulo"));
        System.out.println(tokyo.isEqual(saoPaulo));

        //obter o dia do mês atual, utilizar o método getDayOfMonth de uma instância da classe MonthDay
        System.out.println("hoje é dia: " + MonthDay.now().getDayOfMonth());

        YearMonth ym = YearMonth.now(); //.from("de alguma determinada data");
        System.out.println(ym.getMonth() + " " + ym.getYear());

        //Enums no lugar de constantes
        System.out.println(LocalDate.of(2022, 11, 1));
        System.out.println(LocalDate.of(2022, Month.NOVEMBER, 1));

        //Outra vantagem de utilizar os enums são seus diversos métodos auxiliares
        //consultar o primeiro dia do trimestre de determinado mês, ou então incrementar/decrementar meses
        System.out.println(Month.DECEMBER.firstMonthOfQuarter());
        System.out.println(Month.DECEMBER.plus(2));
        System.out.println(Month.DECEMBER.minus(1));

        //Para imprimir o nome de um mês formatado, podemos utilizar o método getDisplayName
        //saidas em pt-br
        Locale pt = new Locale("pt");

        System.out.println(Month.DECEMBER
                .getDisplayName(TextStyle.FULL, pt));
        System.out.println(Month.DECEMBER
                .getDisplayName(TextStyle.SHORT, pt));

        //enum introduzido no java.time foi o DayOfWeek. Com ele, podemos representar facilmente 
        // um dia da semana, sem utilizar constantes ou números mágicos
        DayOfWeek dw = DayOfWeek.SUNDAY;
        System.out.println(dw);

        //Formatando com a nova API de datas
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String resultado = now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(resultado);

        //Mas como criar um DateTimeFormatter com um novo padrão?
        // Uma das formas é usando o método ofPattern, que recebe uma String como parâmetro
        LocalDateTime dtNow = LocalDateTime.now();
        String formatado = dtNow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(formatado);

        //podemos transformar uma String em alguma representação de data ou tempo válida
        //para isso usamos o método parse
        //podemos retornar nosso resultado anterior em um LocalDate usando o mesmo formatador
        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado2 = now2.format(formatador);
        LocalDate agoraEmData = LocalDate.parse(resultado2, formatador);
        System.out.println(agoraEmData);
        //Não poderíamos retornar um LocalDateTime, afinal quando formatamos em data
        // (com a padrão dd/MM/yyyy), perdemos as informações de tempo!

        //Duração e Período
        //quantos dias se passaram de uma data para outra = ChronoUnit.DAYS
        LocalDate dateNow = LocalDate.now();
        LocalDate dateOther = LocalDate.of(1999, Month.AUGUST, 20);
        long dias = ChronoUnit.DAYS.between(dateOther, dateNow);
        System.out.println(dias);

        //diferença de anos e meses entre essas duas datas = ChronoUnit.YEARS e ChronoUnit.MONTH
        long dias1 = ChronoUnit.DAYS.between(dateOther, dateNow);
        long meses = ChronoUnit.MONTHS.between(dateOther, dateNow);
        long anos = ChronoUnit.YEARS.between(dateOther, dateNow);
        System.out.printf("%s dias, %s meses e %s anos", dias1, meses, anos);
        System.out.println();

        //a forma de conseguir o resultado que esperamos: os dias, meses e anos entre
        //duas datas, é utilizando o modelo Period = api também possui o método between =
        // recebe duas instâncias de LocalDate
        //Period considera as medidas de data (dias, meses e anos)
        LocalDate now3 = LocalDate.now();
        LocalDate outraData = LocalDate.of(1997, Month.FEBRUARY, 10);
        Period periodo = Period.between(outraData, now3);
        System.out.printf("%s dias, %s meses e %s anos", periodo.getDays() , periodo.getMonths(), periodo.getYears());
        System.out.println();
        // método para negar valores negativos = sainda com valores positivos
        if (periodo.isNegative()) {
            periodo = periodo.negated();
        }

        //Existem diversas outras formas de se criar um Period, além do método
        //between. Uma delas é utilizando o método of(years, months, days) de forma fluente
        Period periodo1 = Period.of(2, 10, 5);

        //Também podemos criar um período com apenas dias, meses ou anos utilizando
        //os métodos: ofDays, ofMonths ou ofYears.
        Period periodo2 = Period.ofDays(7);
        Period periodo3 = Period.ofMonths(11);
        Period periodo4 = Period.ofYears(5);

        //Duration considera as medidas de tempo (horas, minutos, segundos etc.)
        LocalDateTime dataEHora = LocalDateTime.now();
        LocalDateTime daquiAUmaHora = LocalDateTime.now().plusHours(1);
        Duration duracao = Duration.between(dataEHora, daquiAUmaHora);
        if (duracao.isNegative()) {
            duracao = duracao.negated();
        }
        System.out.printf("%s horas, %s minutos e %s segundos",
                duracao.toHours(), duracao.toMinutes(), duracao.getSeconds());
        System.out.println();


    }
}
