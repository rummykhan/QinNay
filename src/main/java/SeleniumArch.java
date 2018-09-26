
import Selio.Selio;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumArch {

    public static void main(String[] args) throws Exception {
        Selio.getInstance().setUp();
        TestSuite suite = new TestSuite();
        suite.run();
    }


}
