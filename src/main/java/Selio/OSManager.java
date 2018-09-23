package Selio;

import Selio.Type.OSType;

public class OSManager {

    private static OSManager instance = null;

    private OSManager() {

    }

    public static OSManager getInstance() {
        return OSManager.buildInstance();
    }

    private static OSManager buildInstance() {
        if (OSManager.instance == null) {
            OSManager.instance = new OSManager();
        }

        return OSManager.instance;
    }

    public OSType detect() throws Exception {

        String OSName = getOSName();

        if (OSName == null) {
            throw new Exception("Failed to detect OSManager Name");
        }

        if (isWindows(OSName)){
            return OSType.Windows;
        } else if(isLinux(OSName)){
            return OSType.Linux;
        }else if (isMac(OSName)){
            return OSType.Mac;
        }

        throw new Exception("Unsupported OSManager Type");
    }

    private String getOSName() {
        return System.getProperty("os.name");
    }

    private boolean isWindows(String OSName){
        return OSName.toLowerCase().startsWith("windows");
    }

    private boolean isLinux(String OSName){
        return OSName.toLowerCase().startsWith("linux");
    }

    private boolean isMac(String OSName){
        return OSName.toLowerCase().startsWith("mac");
    }


}
