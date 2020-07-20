package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


i
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodsTest extends SettingsTest {

    protected void getUrl() {
        getDriver().get("http://www.sberbank.ru/ru/person");
    }

    protected void clickByInsurance(){
        String xpathInsurance = "//span[@class='lg-menu__text' and text()='Страхование']";
        Actions action = new Actions(getDriver());
        WebElement insurance = getDriver().findElement(By.xpath(xpathInsurance));
        action.moveToElement(insurance).build().perform();



    }

    protected void clickHeadInsurance() {
        String xpathHeadInsurance = "//a[@class='lg-menu__sub-link' and text()='Страхование путешественников']";
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathHeadInsurance)));
        WebElement headInsurance = getDriver().findElement(By.xpath(xpathHeadInsurance));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", headInsurance);


    }

    protected void assertHeadInsurance() {
        String xpathHeadInsurance2 = "//div[@class='kit-col_xs_12 kit-col_md_0 kit-col_lg_6 kit-col_xs-bottom_20 kit-col_lg-bottom_10 kit-col_xs-top_20 kit-col_lg-top_40']/h1";
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathHeadInsurance2)));
        WebElement headInsurance2 = getDriver().findElement(By.xpath(xpathHeadInsurance2));
        assertEquals("Страхование путешественников", headInsurance2.getText(), "Заголовок не совпадает");
    }

    protected void clickButtonArrangeOnline() {
        String xpathButtonArrangeOnline = "//b[@class='kit-button__text' and text()='Оформить онлайн']";
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathButtonArrangeOnline)));
        WebElement buttonArrangeOnline = getDriver().findElement(By.xpath(xpathButtonArrangeOnline));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", buttonArrangeOnline);


    }

    protected void clickMinSum() {
        String xpathMinSum = "//div[@class='online-card-program selected']";
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathMinSum)));
        WebElement minSum = getDriver().findElement(By.xpath(xpathMinSum));
        minSum.click();
    }

    protected void clickButtonArrange() {
        String xpathButtonArrange = "//button[@class='btn btn-primary btn-large']";
        WebElement buttonArrange = getDriver().findElement(By.xpath(xpathButtonArrange));
        Actions actions = new Actions(getDriver());
        actions.doubleClick(buttonArrange).build().perform();
    }


    protected void inputInsuredFieldsInsured(String surname, String name, String birthDate) {
        String xpathSurnameInsured = "//input[@id='surname_vzr_ins_0']";
        String xpathNameInsured = "//input[@id='name_vzr_ins_0']";
        String xpathBirthDate = "//input[@id='birthDate_vzr_ins_0']";

        WebElement surnameInsured = getDriver().findElement(By.xpath(xpathSurnameInsured));
        WebElement nameInsured = getDriver().findElement(By.xpath(xpathNameInsured));
        WebElement birthDateElem = getDriver().findElement(By.xpath(xpathBirthDate));
        surnameInsured.sendKeys(surname);
        nameInsured.sendKeys(name);
        birthDateElem.sendKeys(birthDate);

    }

    protected void inputFieldsPolicyholder(String firstName, String lastName, String middleName, String birthDate) {
        getDriver().findElement(By.xpath("//input[@id='person_lastName']")).click();
        getDriver().findElement(By.xpath("//input[@id='person_lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//input[@id='person_firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='person_middleName']")).sendKeys(middleName);
        getDriver().findElement(By.xpath("//input[@id='person_birthDate']")).sendKeys(birthDate);

    }

    protected void inputFieldsPassport(String passportSeries, String passportNumber, String documentIssue) {
        getDriver().findElement(By.xpath("//input[@id='passportSeries']")).click();
        getDriver().findElement(By.xpath("//input[@id='passportSeries']")).sendKeys(passportSeries);
        getDriver().findElement(By.xpath("//input[@id='passportNumber']")).sendKeys(passportNumber);
        getDriver().findElement(By.xpath("//input[@id='documentIssue']")).click();
        getDriver().findElement(By.xpath("//input[@id='documentIssue']")).sendKeys(documentIssue);

    }

    protected void inputFieldPassportDate(String passportDate) {
        getDriver().findElement(By.xpath("//input[@id='documentDate']")).sendKeys(passportDate);
    }

    protected void assertInputFieldsInsured(String surname, String name, String birthDate) {
        String attributeValue = "value";
        WebElement surnameElem = getDriver().findElement(By.xpath("//input[@id='surname_vzr_ins_0']"));
        WebElement nameElem = getDriver().findElement(By.xpath("//input[@id='name_vzr_ins_0']"));
        WebElement birthDateElem = getDriver().findElement(By.xpath("//input[@id='birthDate_vzr_ins_0']"));
        assertEquals(surname, surnameElem.getAttribute(attributeValue), "Фамилия не совпадает" );
        assertEquals(name, nameElem.getAttribute(attributeValue), "Имя не совпадает");
        assertEquals(birthDate, birthDateElem.getAttribute(attributeValue), "дата рождения не совпадает");

    }

    protected void assertInputFieldsPolicyHolder(String firstName, String lastName, String middleName, String birthDate) {
        String attributeValue = "value";
        WebElement firstNameElem = getDriver().findElement(By.xpath("//input[@id='person_firstName']"));
        WebElement lastNameElem = getDriver().findElement(By.xpath("//input[@id='person_lastName']"));
        WebElement middleNameElem = getDriver().findElement(By.xpath("//input[@id='person_middleName']"));
        WebElement birthDateElem = getDriver().findElement(By.xpath("//input[@id='person_birthDate']"));
        assertEquals(firstName, firstNameElem.getAttribute(attributeValue), "Фамилия не совпадает" );
        assertEquals(lastName, lastNameElem.getAttribute(attributeValue), "Имя не совпадает" );
        assertEquals(middleName, middleNameElem.getAttribute(attributeValue), "Отчество не совпадает");
        assertEquals(birthDate, birthDateElem.getAttribute(attributeValue), "Дата не совпадает");

    }

    protected void assertInputFieldsPassport(String passportSeries, String passportNumber, String documentIssue) {
        String attributeValue = "value";
        WebElement passportSeriesElem = getDriver().findElement(By.xpath("//input[@id='passportSeries']"));
        WebElement passportNumberElem = getDriver().findElement(By.xpath("//input[@id='passportNumber']"));
        WebElement documentIssueElem = getDriver().findElement(By.xpath("//input[@id='documentIssue']"));
        assertEquals(passportSeries, passportSeriesElem.getAttribute(attributeValue), "Серия не совпала");
        assertEquals(passportNumber, passportNumberElem.getAttribute(attributeValue), "Номер паспорта не совпал");
        assertEquals(documentIssue, documentIssueElem.getAttribute(attributeValue), "Кем выдано не совпало");
    }

    protected void assertInputFieldPassportDate(String passportDate) {
        String attributeValue = "value";
        WebElement passportDateElem = getDriver().findElement(By.xpath("//input[@id='documentDate']"));
        assertEquals(passportDate, passportDateElem.getAttribute(attributeValue), "Дата выдачи не совпала");
    }

    protected void clickButtonContinue() {
        WebElement buttonContinue = getDriver().findElement(By.xpath("//button[@class='btn btn-primary page__btn']"));
        buttonContinue.click();

    }

    protected void assertAlertFormError(String textError) {
        WebElement alertError = getDriver().findElement(By.xpath("//div[@class='alert-form alert-form-error']"));
        assertEquals(textError, alertError.getText(), "Текст не совпал");
    }

}

