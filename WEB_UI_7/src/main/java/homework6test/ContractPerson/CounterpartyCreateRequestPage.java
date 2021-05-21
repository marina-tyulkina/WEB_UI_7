package homework6test.ContractPerson;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CounterpartyCreateRequestPage extends BaseView {

    public CounterpartyCreateRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement lastName;
    public CounterpartyCreateRequestPage fillLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement firstName;
    public CounterpartyCreateRequestPage fillFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement organisationSelect;
    public CounterpartyCreateRequestPage organisationSelect(String counterpartyName) {
        driver.findElement(By.id("//span[text()='Укажите организацию']/..")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+counterpartyName+"']")));
        driver.findElement(By.xpath("//*[text()='"+counterpartyName+"']")).click();
        return this;
    }


    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement jobTitle;
    public CounterpartyCreateRequestPage jobTitle(String jobTitleName) {
        jobTitle.sendKeys(jobTitleName);
        return this;
    }



    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;


    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Контактное лицо сохранено']";
}
