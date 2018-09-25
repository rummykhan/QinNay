package Selio.TestCase;


import Selio.Form.FormInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class FormTestCase extends TestCase {

    protected Map<String, FormInput> inputs;

    public abstract String getSubmitButtonSelector();

    public Map<String, FormInput> getInputs() {

        if (inputs.size() == 0) {
            fillInputs();
        }

        return inputs;
    }

    public abstract void fillInputs();

    public abstract String getSuccessUrl();

    public abstract String getSuccessCode();

    public Map<String, String> getSuccessHeaders() {
        return new HashMap<String, String>();
    }

    @Override
    public void run(boolean isVerbose) throws Exception {
        if (!visit()) {
            throw new Exception("Please check for your internet connection and website url");
        }

        findAndEnterInputValues(isVerbose);
        submitForm(isVerbose);
        checkForSuccess(isVerbose);
    }

    protected void findAndEnterInputValues(boolean isVerbose) {
        for (Map.Entry<String, FormInput> input : inputs.entrySet()) {
            enterInputValue(input.getKey(), input.getValue());
        }
    }

    protected void submitForm(boolean isVerbose) {
        getWebDriverInstance().findElement(By.xpath(getSubmitButtonSelector())).click();
    }

    private void enterInputValue(String selector, FormInput formInput) {

        switch (formInput.getInputType()) {
            case TextBox:
                enterTextBoxValue(selector, formInput);
                break;
            case CheckBox:
                enterCheckBoxValue(selector, formInput);
                break;
            case RadioBox:
                enterRadioBoxValue(selector, formInput);
                break;
            case SelectBox:
                enterSelectBoxValue(selector, formInput);
                break;
        }
    }

    private void enterTextBoxValue(String selector, FormInput formInput) {
        getWebDriverInstance().findElement(By.xpath(selector)).sendKeys(formInput.getValue());
    }

    private void enterCheckBoxValue(String selector, FormInput formInput) {
        getWebDriverInstance().findElement(By.xpath(selector)).click();
    }

    private void enterRadioBoxValue(String selector, FormInput formInput) {
        getWebDriverInstance().findElement(By.xpath(selector)).click();
    }

    private void enterSelectBoxValue(String selector, FormInput formInput) {
        WebElement elem = getWebDriverInstance().findElement(By.xpath(selector));

        Select select = new Select(elem);

        select.selectByVisibleText(formInput.getValue());
    }

}
