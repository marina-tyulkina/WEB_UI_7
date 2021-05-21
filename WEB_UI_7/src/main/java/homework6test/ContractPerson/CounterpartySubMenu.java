package homework6test.ContractPerson;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartySubMenu extends BaseView {

    public CounterpartySubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement counterpartyPersonRequestButton;

    public void createCounterpartyPerson() {
        counterpartyPersonRequestButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CounterpartyRequestsPage(driver).createCounterpartyPersonButtonLocator));
    }
}
