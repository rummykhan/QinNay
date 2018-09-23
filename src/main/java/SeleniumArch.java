import QinNay.QinNay;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumArch {
    public static void main(String[] args) throws Exception {

        QinNay app = QinNay.getInstance();
        app.setUp();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.helpbit.com");

    }
}
