package homework6test;

import homework6test.AllPages.LoginPage;
import homework6test.ContractPerson.CounterpartyCreateRequestPage;
import homework6test.ContractPerson.CounterpartyRequestsPage;
import homework6test.ContractPerson.CounterpartySubMenu;
import homework6test.Project.newProjectCreateRequestPage;
import homework6test.Project.newProjectRequestsPage;
import homework6test.Project.newProjectSubMenu;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;
import static homework6test.AllPages.Configuration.BASE_URL;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Feature("Тестирование создания нового проекта и нового контрагента")
public class LoginWithPageObjectTests extends BaseTest{

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void loginTest() {
        loginPage.inputLogin.sendKeys("Applanatest1");
        loginPage.inputPassword.sendKeys("Student2020!");
        loginPage.buttonSubmit.click();
    }

    @Test
    void loginPage() {
        new LoginPage(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .submitLogin();
    }

    @Test
    void createNewMyProject() {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Проекты");

        new newProjectSubMenu(driver).createProject();
        new newProjectRequestsPage(driver).createProject();

        new newProjectCreateRequestPage(driver)
                .fillName("My Test")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Амелин Владимир")
                .selectRp("Воденеев Денис")
                .selectAdministrator("Исаева Анастасия")
                .selectManager("Ломакина Ксения")
                .organisationSelect("Test_from_GB")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new newProjectCreateRequestPage(driver).requestSuccessLocator)));

        assertThat(new newProjectCreateRequestPage(driver).requestSuccess, isDisplayed());
    }

    @Test
    void createNewContractPerson() {
        new LoginPage(driver).login("Applanatest1", "Student2020!")
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new CounterpartySubMenu(driver).createCounterpartyPerson();
        new CounterpartyRequestsPage(driver).createCounterPartyPerson();

        new CounterpartyCreateRequestPage(driver)
                .fillLastName("Иванов")
                .fillFirstName("Петр")
                .jobTitle("Директор")
                .organisationSelect("Test_from_GB")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CounterpartyCreateRequestPage(driver).requestSuccessLocator)));

        assertThat(new CounterpartyCreateRequestPage(driver).requestSuccess, isDisplayed());
    }

}
