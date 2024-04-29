package lesson1.task2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private PropertiesUtil(){}

    private static void loadProperties() {
        /*
        Немного перепутал я на уроке. Я получал ресурсы через Class.getResourceAsStream,
        а уже внутри метода используется ClassLoader. А напрямую через ClassLoader
        можно только по URL загружать как я понял.
        */
        try (InputStream resourceStream = PropertiesUtil.class.getResourceAsStream("/database.properties")){
            System.out.println(resourceStream);
            PROPERTIES.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
