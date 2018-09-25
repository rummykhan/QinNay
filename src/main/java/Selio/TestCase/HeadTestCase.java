package Selio.TestCase;

import java.util.Map;

public abstract class HeadTestCase extends TestCase {

    public abstract String getSuccessUrl();

    public abstract String getSuccessCode();

    public abstract Map<String, String> getSuccessHeaders();

    @Override
    public void run(boolean isVerbose) throws Exception {

        if (!visit()) {
            throw new Exception("Please check for your internet connection and website url");
        }

        checkForSuccess(isVerbose);
    }

}
