package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataClass {
    protected static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments("Лазарев","Гарик","13.07.1997","Валик","Ваня","Пургович", "4511","333333","15.10.2005","Каким-то органом", "17.02.1999"),
                Arguments.arguments("Мотов","Павел","15.06.1995","Непупкин","Петя","Оганезович", "4512","150130","16.05.1999","Кем-то", "16.03.1999"),
                Arguments.arguments("Notpupkin","Petr","15.06.1995","Лысый","Борис","Рамильевич", "4531","333213","15.11.2006","ГУ МВД", "19.09.1988")
        );
    }
}
