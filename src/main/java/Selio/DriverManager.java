package Selio;

import Selio.Type.Browser;

public class DriverManager {

    private static DriverManager instance = null;

    private OSManager os = null;

    private String basePath = null;

    private DriverManager(OSManager os, String basePath) {
        this.os = os;
        this.basePath = basePath;
    }

    public static DriverManager getInstance() {
        return DriverManager.buildInstance();
    }

    private static DriverManager buildInstance() {
        if (DriverManager.instance == null) {
            DriverManager.instance = new DriverManager(OSManager.getInstance(), System.getProperty("user.dir"));
        }

        return DriverManager.instance;
    }

    public void setUp() throws Exception {
        registerDriverPath(getChromeDriverPath(), Browser.Chrome);
        registerDriverPath(getFireFoxDriverPath(), Browser.Firefox);
    }

    private String getChromeDriverPath() throws Exception {
        return getDriverPath(basePath, "/drivers/chrome-mac", "/drivers/chrome-win.exe");
    }

    private String getFireFoxDriverPath() throws Exception {
        return getDriverPath(basePath, "/drivers/firefox-mac", "/drivers/firefox-win.exe");
    }

    private String getDriverPath(String driverPath, String macDriverPath, String windowDriverPath) throws Exception {
        switch (os.detect()) {
            case Mac:
                driverPath += macDriverPath;
                break;
            case Windows:
                driverPath += windowDriverPath;
                break;
        }

        return driverPath;
    }

    private void registerDriverPath(String path, Browser browser) {

        // firefox = webdriver.gecko.driver
        // chrome = webdriver.chrome.driver
        String key = null;
        switch (browser) {

            case Firefox:
                key = "webdriver.gecko.driver";
                break;

            case Chrome:
                key = "webdriver.chrome.driver";
                break;
        }

        System.setProperty(key, path);
    }

}
