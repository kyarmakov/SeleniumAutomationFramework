package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static final List<Map<String, String>> tests;

    private DataProviderUtils() {}

    static {
        tests = ExcelUtils.getTests("Registration");
    }

    @DataProvider
    public static Iterator<Map<String, String>> getData(Method method) {
        List<Map<String, String>> testsToReturn = new ArrayList<>();

        for (Map<String, String> test : tests) {
            String randomPassword = RandomUtils.getRandomPassword();
            String randomEmail = RandomUtils.getRandomEmail();

            if (test.get("email").equalsIgnoreCase("RANDOM_EMAIL"))
                test.put("email", randomEmail);

            if (test.get("password").equalsIgnoreCase("RANDOM_PASSWORD"))
                test.put("password", randomPassword);

            if (test.get("confirmPassword").equalsIgnoreCase("RANDOM_PASSWORD"))
                test.put("confirmPassword", randomPassword);

            testsToReturn.add(test);
        }

        return testsToReturn.iterator();
    }
}