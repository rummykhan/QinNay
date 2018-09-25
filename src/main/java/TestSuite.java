import Chrome.HomeTestCase;

public class TestSuite extends Selio.TestSuite {

    @Override
    public String[] getChromeTestCases(){
        return new String[]{
                HomeTestCase.class.getName(),
        };
    }

}
