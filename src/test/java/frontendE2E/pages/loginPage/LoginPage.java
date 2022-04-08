package frontendE2E.pages.loginPage;

import frontendE2E.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

    private String userNameFieldId = "username";
    private String pwdFieldId = "password";
    private String signInBtnXpath = "//*[contains(text(), 'Sign In')]";
    private String errorContainerSelector = "body > * > *.error-container > *";


    public void fillUserNameId(String data){
        WebElement loginField = findElement(By.id(userNameFieldId));
        fillField(loginField, data);
    }

    public void fillUserPwd(String data) {
        WebElement pwdField = findElement(By.id(pwdFieldId));
        fillField(pwdField, data);
    }

    public void clickSingInBtn(){
        WebElement signInBtn = findElement(By.xpath(signInBtnXpath));
        signInBtn.click();
    }

    public String getInvalidCrednetialsMessage() {
        WebElement loginErrorMsg = findElement(By.cssSelector(errorContainerSelector));
        return loginErrorMsg.getText();
    }
}
