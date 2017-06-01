package org.fundacionjala.pivotal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 6/1/2017.
 */
public final class Environment {
    private static Environment instance;
    private Properties userProperties;
    private FileInputStream file;

    /**
     * Private constructor.
     */
    private Environment() {
        userProperties = new Properties();
        try {
            file = new FileInputStream("user.properties");
            userProperties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The method returns the instance of the class.
     *
     * @return a Environment instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * The method returns the value of one specific key.
     *
     * @param key of String type.
     * @return a value of String type.
     */
    public String getPropertyValue(final String key) {
        return userProperties.getProperty(key);
    }
}
