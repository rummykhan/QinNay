package Chrome;

import Selio.TestCase.HeadTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class HomeTestCase extends HeadTestCase {

    @Override
    public String getSuccessUrl() {
        return null;
    }

    @Override
    public String getSuccessCode() {
        return null;
    }

    @Override
    public Map<String, String> getSuccessHeaders() {
        return null;
    }

    @Override
    public void setWebDriver() {
        webDriver = new ChromeDriver();
    }

    @Override
    public String getUrl() {
        return "https://www.helpbit.com";
    }

    @Override
    protected String getSuccessText() {
        return "What help do you need";
    }
}
