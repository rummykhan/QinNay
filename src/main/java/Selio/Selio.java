package Selio;

public class Selio {

    private static Selio instance = null;

    private DriverManager driverManager = null;

    private Selio(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public static Selio getInstance() {
        return Selio.buildInstance();
    }

    private static Selio buildInstance() {
        if (Selio.instance == null) {
            Selio.instance = new Selio(DriverManager.getInstance());
        }

        return Selio.instance;
    }

    public void setUp() throws Exception {
        driverManager.setUp();
    }
}
