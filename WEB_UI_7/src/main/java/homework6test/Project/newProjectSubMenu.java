package homework6test.Project;

import homework6test.AllPages.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class newProjectSubMenu extends BaseView {

    public newProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement projectsRequestsButton;

    public void createProject() {
        projectsRequestsButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new newProjectRequestsPage(driver).createProjectButtonLocator));
    }
}
