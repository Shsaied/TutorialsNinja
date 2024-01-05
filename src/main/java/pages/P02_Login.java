package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login {
    //Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public P02_Login(WebDriver driver) {
        this.driver = driver;
    }

    //Todo define Locators
    private final By Email = By.xpath("//input[@id='input-email']");
    private final By Password = By.xpath("//input[@id='input-password']");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By logoutLink=By.xpath("//span[normalize-space()='Checkout']");

    //Todo define Methods
    public P02_Login insertEmail(String email){
        driver.findElement(this.Email).sendKeys(email);
        return this;
    }
    public P02_Login insertPassword(String password){
        driver.findElement(this.Password).sendKeys(password);
        return this;
    }
    public P02_Login clickSubmitbutton(){
        driver.findElement(this.loginButton).click();
        return this;

        }
    public boolean checkLogin(){

    return driver.findElement(this.logoutLink).isDisplayed();
    }
}
