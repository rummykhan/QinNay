package Selio.TestCase;

import Selio.Type.HttpMethod;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public abstract class TestCase implements ITestCase {

    public abstract WebDriver getWebDriver();

    public abstract String getUrl();

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
        getWebDriver().get(url);

        return true;
    }

}
