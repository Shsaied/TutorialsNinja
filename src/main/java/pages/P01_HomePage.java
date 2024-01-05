package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    //Todo declare web driver
    WebDriver driver;

    //Todo constructor
    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Todo define Locators
    private final By MyAccount = By.xpath("//span[normalize-space()='My Account']");
    private final By Signup = By.xpath("//a[normalize-space()='Register']");
    private final By Login=By.xpath("//a[normalize-space()='Login']");

    //Todo define Methods
    public P01_HomePage clickMyAccount(){
        driver.findElement(this.MyAccount).click();
        return this;
    }
    public P01_HomePage clickLogin(){
        driver.findElement(this.Login).click();
        return this;
    }
    public P01_HomePage clickSignup(){
        driver.findElement(this.Signup).click();
        return this;
    }


}


