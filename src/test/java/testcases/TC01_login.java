package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_Login;
import retryTest.Retry;
import util.Utility;

import java.io.IOException;
import static util.Utility.getSingleJsonData;


public class TC01_login extends TestBase {
  String  email=getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/DataDriven/LoginData.json","Email");
  String  password=getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/DataDriven/LoginData.json","Password");




    public TC01_login() throws IOException, ParseException {
    }

@Description("Check login with valid data")
@Severity(SeverityLevel.CRITICAL)
@Story("Login")
    @Test(priority = 1, description = "Login With Valid Email and Password", retryAnalyzer = retryTest.Retry.class)
    public void checkLogin_P(){
    new P01_HomePage(driver).clickMyAccount().clickLogin();
    new P02_Login(driver).insertEmail(email).insertPassword(password).clickSubmitbutton();
    //take screenshot
    Utility.captureScreenshot(driver,"Positive_Login");
    //assert
    Assert.assertTrue(new P02_Login(driver).checkLogin());

  }


  @Description("Check login with invalid Email")
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Test(priority = 2, description = "Login With invalid Email ")
  public void checkLoginWithInvalidEmail(){
      email="test@test.com";
    new P01_HomePage(driver).clickMyAccount().clickLogin();
    new P02_Login(driver).insertEmail(email).insertPassword(password).clickSubmitbutton();
  }


  @Description("Check login with invalid password")
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Test(priority = 3, description = "Login With invalid  Password")
  public void checkLoginWithInvalidPassword(){
      password="test";
    new P01_HomePage(driver).clickMyAccount().clickLogin();
    new P02_Login(driver).insertEmail(email).insertPassword(password).clickSubmitbutton();
  }


  @Description("Check login with invalid data")
  @Severity(SeverityLevel.CRITICAL)
  @Story("Login")
  @Test(priority = 4, description = "Login With inValid Email and Password")
  public void checkLoginInvalidData_P(){
      email="test@test.com";
      password="test";
    new P01_HomePage(driver).clickMyAccount().clickLogin();
    new P02_Login(driver).insertEmail(email).insertPassword(password).clickSubmitbutton();
  }

}
