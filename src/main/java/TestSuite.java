import Chrome.HomeTestCase;
import Chrome.LoginTestCase;

public class TestSuite extends Selio.TestSuite {

    @Override
    public String[] getChromeTestCases(){
        return new String[]{
                //HomeTestCase.class.getName(),
                LoginTestCase.class.getName(),
        };
    }

}
