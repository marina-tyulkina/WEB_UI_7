package homework6test.Project;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class newProjectCreateRequestPage extends BaseView {

    public newProjectCreateRequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement fillName;
    public newProjectCreateRequestPage fillName(String name) {
        fillName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
    public WebElement uniqueProjectSelect;
    public newProjectCreateRequestPage organisationSelect(String organisationName) {
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+organisationName+"']")));
        driver.findElement(By.xpath("//*[text()='"+organisationName+"']")).click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement projectSelect;
    public newProjectCreateRequestPage selectBusinessUnit(String businessUnitName) {
        new Select(projectSelect).selectByVisibleText(businessUnitName);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;
    public newProjectCreateRequestPage selectCurator(String curatorName) {
        new Select(curatorSelect).selectByVisibleText(curatorName);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;
    public newProjectCreateRequestPage selectRp(String rpName) {
        new Select(rpSelect).selectByVisibleText(rpName);
        return this;
    }
    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;
    public newProjectCreateRequestPage selectAdministrator(String administratorName) {
        new Select(administratorSelect).selectByVisibleText(administratorName);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;
    public newProjectCreateRequestPage selectManager(String managerName) {
        new Select(managerSelect).selectByVisibleText(managerName);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;


    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";
}
