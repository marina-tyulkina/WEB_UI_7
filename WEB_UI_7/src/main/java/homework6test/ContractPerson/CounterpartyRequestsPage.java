package homework6test.ContractPerson;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartyRequestsPage extends BaseView {

    public CounterpartyRequestsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать контактное лицо']")
    public WebElement createCounterpartyPersonButton;
    public void createCounterPartyPerson() {
        createCounterpartyPersonButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("crm_contact[lastName]")));
    }

    public By createCounterpartyPersonButtonLocator = By.xpath("//a[text()='Создать контактное лицо']");
}
