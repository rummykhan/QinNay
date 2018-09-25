package Selio.TestCase;

import Selio.Type.HttpMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class TestCase implements ITestCase {

    final static Logger logger = Logger.getLogger(TestCase.class);

    protected WebDriver webDriver;

    public abstract void setWebDriver();

    public abstract String getUrl();

    public WebDriver getWebDriverInstance() {
        if (webDriver == null) {
            setWebDriver();
        }
        return webDriver;
    }

    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    public boolean visit() throws Exception {

        if (getHttpMethod() == null) {
            throw new Exception("Invalid http method");
        }

        return visitByGet(getUrl());
    }

    private boolean visitByGet(String url) {
        System.out.println("Visit by GET " + url);
        getWebDriverInstance().get(url);

        return true;
    }

    protected abstract String getSuccessText();

    protected void checkForSuccess(boolean isVerbose) {
        System.out.println("Wait for 10 seconds");
        getWebDriverInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (getSuccessText() != null) {
            System.out.println("Testing for success text");
            checkForSuccessText(isVerbose);
        }

        // TODO: Add status code check after visit
        // TODO: Add headers check after visit
    }

    protected void checkForSuccessText(boolean isVerbose) {

        if (!getWebDriverInstance().getPageSource().contains(this.getSuccessText())) {

            System.out.println("Couldn't found what you're looking for.");
            //TODO: Log failed results to file
            return;
        }

        //TODO: Log success results to text file
        System.out.println("Test case success.");
    }

}
