package homework6test.AllPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {

    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @FindBy(xpath = "//a[@title='Geekbrains']")

    public By geekBrainsHomeButtonLocator = By.xpath("//a[@title='Geekbrains']");


}
