package utils;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class RandomStateCity {
    private static final Faker faker = new Faker(new Locale("en"));

    private static final Map<String, String[]> STATE_CITY_MAP = new LinkedHashMap<>();

    static {
        STATE_CITY_MAP.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        STATE_CITY_MAP.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        STATE_CITY_MAP.put("Haryana", new String[]{"Karnal", "Panipat"});
        STATE_CITY_MAP.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    public static String getRandomState() {
        return faker.options().option(STATE_CITY_MAP.keySet().toArray(new String[0]));
    }

    public static String getRandomCity(String state) {
        return faker.options().option(STATE_CITY_MAP.get(state));
    }
}
