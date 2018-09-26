package Chrome;

import Selio.Form.FormInput;
import Selio.Form.InputType;
import Selio.TestCase.FormTestCase;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class LoginTestCase extends FormTestCase {
    @Override
    public String getSubmitButtonSelector() {
        return "//*[@id=\"login_btn\"]";
    }

    @Override
    public void fillInputs() {
        inputs.put("//*[@id=\"loginform-username\"]", new FormInput(InputType.TextBox, "rummykhan9621"));
        inputs.put("//*[@id=\"loginform-password\"]", new FormInput(InputType.TextBox, "rummykhan"));
    }

    @Override
    public String getSuccessUrl() {
        return null;
    }

    @Override
    public String getSuccessCode() {
        return null;
    }

    @Override
    public void setWebDriver() {
        // Set it to const, From user just collect the constant string and construct in the base class
        webDriver = new ChromeDriver();
    }

    @Override
    public String getUrl() {
        return "https://www.helpbit.com/login";
    }

    @Override
    protected String getSuccessText() {
        return "My Requests";
    }
}
