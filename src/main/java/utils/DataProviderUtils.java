package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {
    private static final List<Map<String, String>> tests;

    private DataProviderUtils() {}

    static {
//        tests = ExcelUtils.getTests("Registration");
        try {
            tests = new ObjectMapper()
                    .readValue(new File(FrameworkConstants.getRegistrationJsonFilePath()), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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