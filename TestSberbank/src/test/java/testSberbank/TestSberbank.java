package testSberbank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import settings.MethodsTest;

public class TestSberbank extends MethodsTest {
    @ParameterizedTest(name = "Проверка с данными: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}.")
    @MethodSource("data.DataClass#data")
    void test(String surNameZ, String nameZ, String dateBirthday, String lastName, String name, String middleName, String passportSerial, String passportNumber, String passportDate, String passportIssued, String birthDatePolicyholder){
        //1 - переход на главную страницу
        getUrl();
        //2 - Нажимаем на страхование
        clickByInsurance();
        //3 - Нажимаем на страхование путешественников
        clickHeadInsurance();
        //4 - Проверяем заголовок на странице "Страхование путешественников"
        assertHeadInsurance();
        //5 - Нажимаем на кнопку "Оформить онлайн"
        clickButtonArrangeOnline();
        //6 - Выбираем минимальную сумму
        clickMinSum();
        //7 - Нажимаем оформить
        clickButtonArrange();
        //8 - Заполняем поля
        //Вводим фамилию, имя и дату рождения застрахованного
        inputInsuredFieldsInsured(surNameZ, nameZ , dateBirthday);
        //Вводима ФИО и дату рождения Страхователя
        inputFieldsPolicyholder(name, lastName, middleName, birthDatePolicyholder);
        //Заполянем паспортные данные
        inputFieldsPassport(passportSerial, passportNumber, passportIssued);
        inputFieldPassportDate(passportDate);
        //9 Проверка данных
        assertInputFieldsInsured(surNameZ, nameZ , dateBirthday);
        assertInputFieldsPolicyHolder(name, lastName, middleName, birthDatePolicyholder );
        assertInputFieldsPassport(passportSerial, passportNumber, passportIssued);
        assertInputFieldPassportDate(passportDate);
        // Нажимаем на кнопку продолжить
        clickButtonContinue();
        //Проверяем сообщение об ошибке
        assertAlertFormError("При заполнении данных произошла ошибка");

    }

}
