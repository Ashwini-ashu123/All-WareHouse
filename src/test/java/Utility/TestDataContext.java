package Utility;

import java.util.HashMap;
import java.util.Map;

public class TestDataContext {

    private static Map<String, String> data = new HashMap<>();

    public static void set(String key, String value) {
        data.put(key, value);
    }

    public static String get(String key) {
        return data.get(key);
    }

    public static void clear() {
        data.clear();
    }
}
