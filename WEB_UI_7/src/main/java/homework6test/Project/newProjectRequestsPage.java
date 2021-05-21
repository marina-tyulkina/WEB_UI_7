package homework6test.Project;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class newProjectRequestsPage extends BaseView {

    public newProjectRequestsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Создать проект']")
    public WebElement createProjectButton;

    public void createProject() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("crm_project[name]")));
    }

    public By createProjectButtonLocator = By.xpath("//a[text()='Создать проект']");
}
