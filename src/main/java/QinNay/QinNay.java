package QinNay;

public class QinNay {

    public static QinNay instance = null;

    private DriverManager driverManager = null;

    private QinNay(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public static QinNay getInstance() {
        return QinNay.buildInstance();
    }

    private static QinNay buildInstance() {
        if (QinNay.instance == null) {
            QinNay.instance = new QinNay(DriverManager.getInstance());
        }

        return QinNay.instance;
    }

    public void setUp() throws Exception {
        driverManager.setUp();
    }
}
