package Selio.TestCase;

import Selio.Type.HttpMethod;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public abstract class TestCase implements ITestCase {

    protected WebDriver driver;

    protected String url;

    protected HttpMethod httpMethod;

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public HttpMethod getHttpMethod(){
        return httpMethod;
    }

    public void visit(){

    }

}
