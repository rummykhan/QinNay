package Selio;

import java.lang.reflect.Constructor;

public class InstanceManager {

    private static InstanceManager instance;

    public static InstanceManager getInstance() {
        return InstanceManager.buildInstance();
    }

    private static InstanceManager buildInstance() {

        if (InstanceManager.instance == null) {
            InstanceManager.instance = new InstanceManager();
        }

        return new InstanceManager();
    }

    public Object build(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class c = Class.forName(className);
        Constructor constructor = c.getConstructor();

        try {
            return constructor.newInstance();
        } catch (Exception e) {

        }

        return null;
    }
}
