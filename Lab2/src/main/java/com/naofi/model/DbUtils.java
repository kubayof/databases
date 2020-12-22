package com.naofi.model;

import java.io.IOException;
import java.util.Properties;

public class DbUtils {
    private static final Properties properties = new Properties();

    public static Properties getProperties() {
        if (properties.isEmpty()) {
            try {
                properties.load(DbUtils.class.getClassLoader().getResourceAsStream("db.properties"));
                verifyDbProperties();
            } catch (IOException e) {
                throw new IllegalStateException("Cannot load database properties.", e);
            }
        }

        return (Properties) properties.clone();
    }

    private static void verifyDbProperties() {
        String[] requiredProps = {"url", "username", "password", "driver"};
        for (String prop : requiredProps) {
            if (!properties.containsKey(prop)) {
                throw new IllegalStateException("Property '" + prop + "' is missing in db.properties");
            }
        }
    }

    private DbUtils() {}
}
