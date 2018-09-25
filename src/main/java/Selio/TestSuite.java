package Selio;

import Selio.TestCase.ITestCase;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public abstract class TestSuite {

    protected boolean isVerbose(){
        return true;
    }

    protected String[] getChromeTestCases() {
        return new String[0];
    }

    protected String[] getFirefoxTestCases() {
        return new String[0];
    }

    public void run() throws Exception {

        runTestCases(getChromeTestCases());
        runTestCases(getFirefoxTestCases());
    }

    public void runTestCases(String[] testCases) throws Exception {

        for (String testCase : testCases) {
            runTestCase(testCase);
        }
    }

    public void runTestCase(String testCaseClass) throws Exception {
        ITestCase testCase = (ITestCase) InstanceManager.getInstance().build(testCaseClass);

        testCase.run(isVerbose());
    }


}
